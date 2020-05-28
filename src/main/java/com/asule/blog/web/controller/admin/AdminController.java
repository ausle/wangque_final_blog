/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.asule.blog.web.controller.admin;


import com.asule.blog.modules.service.ChannelService;
import com.asule.blog.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class AdminController {
    @Autowired
    private ChannelService channelService;
//
//    @Autowired
//    private PostService postService;
//    @Autowired
//    private CommentService commentService;
    @Autowired
    private UserService userService;

	@RequestMapping("/admin")
	public String index(HttpServletRequest request, ModelMap model) {
//		pushSystemStatus(request, model);
//		model.put("channelCount", channelService.count());
//        model.put("postCount", postService.count());
//        model.put("commentCount", commentService.count());
//        model.put("userCount", userService.count());
        model.addAttribute("isIndexChecked",true);
		return "/admin/index";
	}
}
