package com.asule.blog.modules.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  文章-图片映射表
 */
@Data
@Entity
@Table(name = "wangque_post_resource", indexes = {
        @Index(name = "IK_POST_ID", columnList = "post_id")
})
public class PostResource implements Serializable {
    private static final long serialVersionUID = -2343406058301647253L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_id")
    private long postId;

    private long resourceId;

    private String path;

    @Column(name = "sort", columnDefinition = "int(11) NOT NULL DEFAULT '0'")
    private int sort;

}
