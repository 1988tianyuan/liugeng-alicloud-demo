package com.liugeng.liugengaliclouddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugeng.liugengaliclouddemo.dao.UserDao;
import com.liugeng.liugengaliclouddemo.model.CommonResponse;
import com.liugeng.liugengaliclouddemo.model.dto.UserDto;

@Service
public class LoginService {

	@Autowired
	private UserDao userDao;

	public boolean tryLogin(String account, String password) {
		UserDto user = userDao.findUserDtoByAccount(account);
		return user != null && user.getPassword().equals(password);
	}

}
