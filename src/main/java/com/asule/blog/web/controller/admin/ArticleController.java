package com.asule.blog.web.controller.admin;

import com.asule.blog.base.lang.Consts;
import com.asule.blog.base.stroage.StorageFactory;
import com.asule.blog.config.SiteOptions;
import com.asule.blog.modules.domain.AccountProfile;
import com.asule.blog.modules.domain.UploadResult;
import com.asule.blog.modules.domain.vo.PostVO;
import com.asule.blog.modules.service.ChannelService;
import com.asule.blog.modules.service.PostService;
import com.asule.blog.web.controller.BaseController;
import com.asule.utils.FileKit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {

    public static HashMap<String, String> errorInfo = new HashMap<>();

    @Autowired
    protected StorageFactory storageFactory;

    static {
        errorInfo.put("SUCCESS", "SUCCESS"); //默认成功
        errorInfo.put("NOFILE", "未包含文件上传域");
        errorInfo.put("TYPE", "不允许的文件格式");
        errorInfo.put("SIZE", "文件大小超出限制，最大支持2Mb");
        errorInfo.put("ENTYPE", "请求类型ENTYPE错误");
        errorInfo.put("REQUEST", "上传请求异常");
        errorInfo.put("IO", "IO异常");
        errorInfo.put("DIR", "目录创建失败");
        errorInfo.put("UNKNOWN", "未知错误");
    }

    @Autowired
    private SiteOptions siteOptions;

    @Autowired
    private PostService postService;

    @Autowired
    private ChannelService channelService;


    @RequestMapping("/list")
    public String list(String title, ModelMap model, HttpServletRequest request) {
        model.put("channels", channelService.findAll(Consts.STATUS_NORMAL));

        return "/admin/article";
    }

    @RequestMapping("/post")
    public String post(String title, ModelMap model, HttpServletRequest request) {
        model.put("channels", channelService.findAll(Consts.STATUS_NORMAL));

        return "/admin/article-post";
    }

    @ResponseBody
    @RequestMapping(value = "/post/upload-editormd",method = RequestMethod.POST)
    public UploadResult uploadMD(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file,
                               HttpServletRequest request, HttpServletResponse response) {
        String crop = request.getParameter("crop");
        int size = ServletRequestUtils.getIntParameter(request, "size",
                Integer.parseInt(siteOptions.getValue(Consts.STORAGE_MAX_WIDTH)));
        UploadResult result = uploadImage(file, crop, size);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/post/upload",method = RequestMethod.POST)
    public UploadResult upload(@RequestParam(value = "file", required = true) MultipartFile file,
                               HttpServletRequest request) {
        String crop = request.getParameter("crop");
        int size = ServletRequestUtils.getIntParameter(request, "size",
                Integer.parseInt(siteOptions.getValue(Consts.STORAGE_MAX_WIDTH)));
        UploadResult result = uploadImage(file, crop, size);
        return result;
    }

    @PostMapping("/submit")
    public String post(PostVO post) {

        Assert.notNull(post, "参数不完整");
        Assert.state(StringUtils.isNotBlank(post.getTitle()), "标题不能为空");
        Assert.state(StringUtils.isNotBlank(post.getContent()), "内容不能为空");

        AccountProfile profile = getProfile();
        post.setAuthorId(profile.getId());

        System.out.println(post);
        postService.post(post);

        return "/admin/article";
    }


    public UploadResult uploadImage(MultipartFile file,String crop,int size) {
        UploadResult result = new UploadResult();
        // 检查空
        if (null == file || file.isEmpty()) {
            return result.error(errorInfo.get("NOFILE"));
        }

        String fileName = file.getOriginalFilename();

        // 检查类型
        if (!FileKit.checkFileType(fileName)) {
            return result.error(errorInfo.get("TYPE"));
        }

        //检查大小，图片大小需小于2Mb
        String limitSize = siteOptions.getValue(Consts.STORAGE_LIMIT_SIZE);
        if (StringUtils.isBlank(limitSize)) {
            limitSize = "2";
        }
        if (file.getSize() > (Long.parseLong(limitSize) * 1024 * 1024)) {
            return result.error(errorInfo.get("SIZE"));
        }

        try {
            String path;
            if (StringUtils.isNotBlank(crop)) {
                Integer[] imageSize = siteOptions.getIntegerArrayValue(crop, Consts.SEPARATOR_X);
                int width = imageSize[0];
                int height = imageSize[1];
                path = storageFactory.get().storeScale(file, Consts.thumbnailPath, width, height);
            } else {
                path = storageFactory.get().storeScale(file, Consts.thumbnailPath, size);
            }
            result.ok(errorInfo.get("SUCCESS"));
            result.setUrl(path);
        } catch (Exception e) {
            result.error(errorInfo.get("UNKNOWN"));
            e.printStackTrace();
        }
        return result;
    }

}
