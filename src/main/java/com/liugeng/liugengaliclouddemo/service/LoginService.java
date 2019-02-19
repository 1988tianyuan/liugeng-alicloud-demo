package com.liugeng.liugengaliclouddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugeng.liugengaliclouddemo.dao.UserDao;
import com.liugeng.liugengaliclouddemo.model.CommonResponse;
import com.liugeng.liugengaliclouddemo.model.User;
import com.liugeng.liugengaliclouddemo.model.dto.UserDto;

@Service
public class LoginService {

	@Autowired
	private UserDao userDao;

	public User tryLogin(String account, String password) {
		UserDto user = userDao.findUserDtoByAccount(account);
		if (user != null && user.getPassword().equals(password)) {
			return new User(user.getId(), user.getAccount(), user.getName());
		}
		return null;
	}

}
