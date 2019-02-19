package com.liugeng.liugengaliclouddemo.model.weixin;

import java.util.Date;

import lombok.Data;

@Data
public class AccessTokenModel {

	String accessToken;
	Date expiresIn;

}
