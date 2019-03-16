package com.liugeng.liugengaliclouddemo.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liugeng.liugengaliclouddemo.model.CommonResponse;
import com.liugeng.liugengaliclouddemo.model.User;

@Component
@CrossOrigin(allowCredentials = "true")
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		String[] noNeedToAuthPage = new String[]{
			"/login", "/list", "/article"
		};
		CommonResponse commonResponse = new CommonResponse();
		if(!Arrays.asList(noNeedToAuthPage).contains(uri)){
			User user = (User) session.getAttribute("user");
			if(null == user){
				commonResponse.setCode(888);
				commonResponse.setMsg("请先登录");
				response.setStatus(403);
				response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
				response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.getWriter().write(objectMapper.writeValueAsString(commonResponse));
				response.getWriter().flush();
				return false;
			}
		}
		return true;
	}
}
