package com.asule.blog.base.exception;


import com.asule.constant.CommonConstant;
import com.asule.entity.ServerResponse;
import com.asule.exception.AccessForbiddenException;
import com.asule.exception.LoginFailedException;
import com.asule.utils.CommonUtils;
import com.asule.utils.JsonUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionResolver {
	
	@ExceptionHandler(value = LoginFailedException.class)
	public ModelAndView resolveLoginFailedException(
				LoginFailedException exception,
				HttpServletRequest request,
				HttpServletResponse response
			) throws IOException {
		String viewName = "/do/login";
		return commonResolve(viewName, exception, request, response);
	}

	@ExceptionHandler(value = AccessForbiddenException.class)
	public ModelAndView resolveAccessForbiddenException(
			AccessForbiddenException exception,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {

		String viewName = "/denied/error";
		return commonResolve(viewName, exception, request, response);
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView resolveNullPointerException(
			AccessForbiddenException exception,
			HttpServletRequest request,
			HttpServletResponse response
	) throws IOException {
		String viewName = "/denied/error";
		return commonResolve(viewName, exception, request, response);
	}

	// @ExceptionHandler将一个具体的异常类型和一个方法关联起来
	private ModelAndView commonResolve(String viewName, Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean judgeResult = CommonUtils.judgeRequestType(request);
		
		// 2.如果是Ajax请求
		if(judgeResult) {
			ServerResponse serverResponse = ServerResponse.createError(exception.getMessage());
			String json=JsonUtil.obj2String(serverResponse);
			response.getWriter().write(json);
			return null;
		}
		ModelAndView modelAndView = new ModelAndView();
		request.setAttribute("message",exception);
		modelAndView.addObject(CommonConstant.ATTR_NAME_EXCEPTION, exception);
		modelAndView.setViewName(viewName);
		return modelAndView;
	}

}
