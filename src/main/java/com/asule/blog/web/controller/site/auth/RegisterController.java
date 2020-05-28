/**
 * 
 */
package com.asule.blog.web.controller.site.auth;

import com.asule.blog.base.lang.Consts;
import com.asule.blog.modules.domain.AccountProfile;
import com.asule.blog.modules.domain.vo.UserVO;
import com.asule.blog.modules.service.UserService;
import com.asule.blog.web.controller.BaseController;
import com.asule.blog.web.controller.site.Views;
import com.asule.entity.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
//@ConditionalOnProperty(name = "site.controls.register", havingValue = "true", matchIfMissing = true)
public class RegisterController extends BaseController {

	@Autowired
	private UserService userService;
//	@Autowired
//	private SecurityCodeService securityCodeService;

	@GetMapping("/register")
	public String view() {
//		AccountProfile profile = getProfile();
//		if (profile != null) {
//			return String.format(Views.REDIRECT_USER_HOME, profile.getId());
//		}
		return view(Views.REGISTER);
	}
	
	@PostMapping("/register")
	public String register(UserVO userVO, HttpServletRequest request, ModelMap model) {
		String view = view(Views.REGISTER);
		try {
			userService.register(userVO);
			ServerResponse<AccountProfile> result = executeLogin(userVO.getUsername(),
					userVO.getPassword(), false);
			view = Views.REDIRECT_INDEX;
		} catch (Exception e) {
			model.addAttribute("user", userVO);
			model.put("data", ServerResponse.createError(e.getMessage()));
		}
		return view;
	}

}