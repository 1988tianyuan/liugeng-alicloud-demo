package com.liugeng.liugengaliclouddemo.controller;

import java.util.List;

import com.liugeng.liugengaliclouddemo.model.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liugeng.liugengaliclouddemo.dao.UserDao;
import com.liugeng.liugengaliclouddemo.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("")
	public CommonResponse<List<UserDto>> getUsers() {
		CommonResponse<List<UserDto>> response = new CommonResponse<>();
		response.setData(userDao.findAll());
		response.setCode(0);
		response.setMsg("获取user成功");
		return response;
	}

	@GetMapping("/{account}")
	public CommonResponse<UserDto> getUserByName(@PathVariable("account") String account) {
		CommonResponse<UserDto> response = new CommonResponse<>();
		response.setData(userDao.findUserDtoByAccount(account));
		response.setCode(0);
		return response;
	}

	@PostMapping("")
	public boolean createNewUser(@RequestBody UserDto user) {
		log.info("create new user: {}", user);
		try {
			userDao.save(user);
			return true;
		} catch (Exception e) {
			log.warn("error during create user: {}", user);
		}
		return false;
	}
}
