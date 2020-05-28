package com.asule.blog.modules.domain.vo;

import com.asule.blog.modules.domain.entity.Channel;
import com.asule.blog.modules.domain.entity.Post;


public class PostVO extends Post {

    private String content;

    private UserVO author;
    private Channel channel;

    public void setAuthor(UserVO author) {
        this.author = author;
    }


    public UserVO getAuthor() {
        return author;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
