/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.asule.blog.modules.domain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 系统配置
 */
@Data
@Entity
@Table(name = "wangque_options")
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * 类型(冗余)
	 */
	@Column(length = 5)
	private int type;

	/**
	 * 标识
	 */
	@Column(name = "key_", unique = true, length = 32)
	private String key;

	/**
	 * 值
	 */
	@Column(length = 300)
	private String value;


}
