package com.liugeng.liugengaliclouddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.liugeng.liugengaliclouddemo.model.CommonResponse;
import com.liugeng.liugengaliclouddemo.model.LoginRequest;
import com.liugeng.liugengaliclouddemo.service.LoginService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public CommonResponse login(@RequestBody LoginRequest loginRequest) {
		CommonResponse response = new CommonResponse();
		boolean isValid = loginService.tryLogin(loginRequest.getAccount(), loginRequest.getPassword());
		if (isValid) {
			response.setCode(0);
			response.setMsg("登陆成功！");
		} else {
			response.setCode(999);
			response.setMsg("账号或密码错误！");
		}
		return response;
	}






}
