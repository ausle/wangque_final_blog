package com.asule.blog.modules.service.impl;


import com.asule.blog.base.lang.Consts;
import com.asule.blog.base.utils.BeanMapUtils;
import com.asule.blog.modules.domain.entity.Post;
import com.asule.blog.modules.domain.entity.PostAttribute;
import com.asule.blog.modules.domain.entity.PostResource;
import com.asule.blog.modules.domain.entity.Resource;
import com.asule.blog.modules.domain.vo.PostVO;
import com.asule.blog.modules.domain.vo.UserVO;
import com.asule.blog.modules.event.PostUpdateEvent;
import com.asule.blog.modules.repository.PostAttributeRepository;
import com.asule.blog.modules.repository.PostRepository;
import com.asule.blog.modules.repository.PostResourceRepository;
import com.asule.blog.modules.repository.ResourceRepository;
import com.asule.blog.modules.service.PostService;
import com.asule.blog.modules.service.TagsService;
import com.asule.blog.modules.service.UserService;
import com.asule.utils.MarkdownUtils;
import com.asule.utils.PreviewTextUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagsService tagsService;

    @Autowired
    private PostAttributeRepository postAttributeRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private PostResourceRepository postResourceRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserService userService;

    //分页的同时添加查询条件
    @Override
    public Page<PostVO> paging(Pageable pageable, int channelId, Set<Integer> excludeChannelIds) {

        Specification<Post> specification = new Specification<Post>() {
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                //大于0表示，要查询某个分类下的文章
                if (channelId> Consts.ZERO){
                    Path<Integer> id = root.get("channelId");
                    predicate.getExpressions().add(criteriaBuilder.equal(id,channelId)); //where channelId=?
                }
                //排除掉其他分类
                if (null!=excludeChannelIds&&excludeChannelIds.size()>0){
                    Path<Integer> id = root.get("channelId");
                    predicate.getExpressions().add(criteriaBuilder.not(id.in(excludeChannelIds)));
                    // where channelId not in (?,?,?)
                }
                return predicate;
            }
        };


        Page<Post> page = postRepository.findAll(specification, pageable);

        return new PageImpl<PostVO>(toPosts(page.getContent()),pageable,page.getTotalElements());
    }


    //处理文章内容
    private  List<PostVO> toPosts(List<Post> content) {

        List<Long> uids=new ArrayList<>();
        List<Integer> channelIds=new ArrayList<>();

        List<PostVO> postVOS=content.stream().map(post -> {
            uids.add(post.getAuthorId());
            channelIds.add(post.getChannelId());
            return BeanMapUtils.copy(post);})
                .collect(Collectors.toList());


        buildUser(uids,postVOS);


        return postVOS;
    }

    private void buildUser(List<Long> uids, List<PostVO> postVOS) {
        //查询所有用户
        Map<Long, UserVO> ids = userService.findMapByIds(uids);
        postVOS.forEach(postVO -> postVO.setAuthor(ids.get(postVO.getId())));
    }

    @Override
    public long post(PostVO post) {
        Post po = new Post();
        BeanUtils.copyProperties(post, po);
        po.setCreated(new Date());
        po.setStatus(post.getStatus());

        // 处理摘要
        if (StringUtils.isBlank(post.getSummary())) {
            po.setSummary(trimSummary(post.getContent()));
        } else {
            po.setSummary(post.getSummary());
        }

        postRepository.save(po);
        tagsService.batchUpdate(po.getTags(), po.getId());

        PostAttribute attr = new PostAttribute();
        attr.setContent(post.getContent());
        attr.setId(po.getId());
        postAttributeRepository.save(attr);

        countResource(po.getId(), null,  attr.getContent());
        onPushEvent(po, PostUpdateEvent.ACTION_PUBLISH);
        return po.getId();

    }

    private void onPushEvent(Post post, int action) {
        PostUpdateEvent event = new PostUpdateEvent(System.currentTimeMillis());
        event.setPostId(post.getId());
        event.setUserId(post.getAuthorId());
        event.setAction(action);
        applicationContext.publishEvent(event);
    }


    //获取文章内容中被引用的资源md5值，根据该值查询资源表，添加到文章-资源映射表中。
    private void countResource(Long postId, String originContent, String newContent){
        if (StringUtils.isEmpty(originContent)){
            originContent = "";
        }
        if (StringUtils.isEmpty(newContent)){
            newContent = "";
        }

        Set<String> exists = extractImageMd5(originContent);
        Set<String> news = extractImageMd5(newContent);

        List<String> adds = ListUtils.removeAll(news, exists);
        List<String> deleteds = ListUtils.removeAll(exists, news);

        if (adds.size() > 0) {
            List<Resource> resources = resourceRepository.findByMd5In(adds);
            List<PostResource> prs = resources.stream().map(n -> {
                PostResource pr = new PostResource();
                pr.setResourceId(n.getId());
                pr.setPostId(postId);
                pr.setPath(n.getPath());
                return pr;
            }).collect(Collectors.toList());
            postResourceRepository.saveAll(prs);

            //引用资源数量+1
            resourceRepository.updateAmount(adds, 1);
        }
    }

    private Set<String> extractImageMd5(String text) {
        Pattern pattern = Pattern.compile("(?<=/_signature/)(.+?)(?=\\.)");

        Set<String> md5s = new HashSet<>();

        Matcher originMatcher = pattern.matcher(text);
        while (originMatcher.find()) {
            String key = originMatcher.group();
            md5s.add(key);
        }
        return md5s;
    }

    /**
     * 截取文章内容
     * @param text
     * @return
     */
    private String trimSummary(final String text){
        return PreviewTextUtils.getText(MarkdownUtils.renderMarkdown(text), 126);
    }
}
