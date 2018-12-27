package com.liugeng.liugengaliclouddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liugeng.liugengaliclouddemo.dao.UserDao;
import com.liugeng.liugengaliclouddemo.model.dto.UserDto;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/user")
	public List<UserDto> getUsers() {
		return userDao.findAll();
	}

	@RequestMapping("/user/{account}")
	public UserDto getUserByName(@PathVariable("account") String account) {
		return userDao.findUserDtoByAccount(account);
	}
}
