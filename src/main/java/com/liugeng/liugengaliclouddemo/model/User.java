package com.liugeng.liugengaliclouddemo.model;

import com.liugeng.liugengaliclouddemo.model.dto.UserDto;
import lombok.Data;

public class User extends UserDto {

	public User(Long id, String account, String name) {
		super(id, account, name, null, null, null);
	}

	public User() {
	}
}
