package com.liugeng.liugengaliclouddemo.model;

import lombok.Data;

@Data
public class LoginRequest {

	private String account;
	private String password;
	private boolean keepLogin;

}
