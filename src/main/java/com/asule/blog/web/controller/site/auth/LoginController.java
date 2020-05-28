/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.asule.blog.web.controller.site.auth;


import com.asule.blog.modules.domain.AccountProfile;
import com.asule.blog.modules.repository.UserRepository;
import com.asule.blog.web.controller.BaseController;
import com.asule.blog.web.controller.site.Views;
import com.asule.entity.ServerResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录
 */
@Controller
public class LoginController extends BaseController {


	@Autowired
	private UserRepository repository;

	/**
     * 跳转登录页
     * @return
     */
	@GetMapping(value = "/do/login")
	public String view(ModelMap modelMap) {
		return view(Views.LOGIN);
	}

    /**
     * 提交登录
     * @param username
     * @param password
     * @param model
     * @return
     */
	@PostMapping(value = "/login")
	public String login(String username,
                        String password,
                        @RequestParam(value = "rememberMe",defaultValue = "0") Boolean rememberMe,
                        ModelMap model) {
		String view = view(Views.LOGIN);
		ServerResponse<AccountProfile> result = executeLogin(username, password, rememberMe);
		if (result.isSuccess()) {
			view = Views.REDIRECT_INDEX;
		} else {
			model.put("msg", result.getMsg());
		}
		return view;
	}

	@GetMapping(value = "/logout")
	public String logout(ModelMap modelMap) {
		String view=view(Views.INDEX);
		SecurityUtils.getSubject().logout();
		return view(view);
	}

}
