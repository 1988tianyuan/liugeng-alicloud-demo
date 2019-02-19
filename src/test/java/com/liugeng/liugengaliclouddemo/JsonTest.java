package com.liugeng.liugengaliclouddemo;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liugeng.liugengaliclouddemo.model.LoginRequest;
import com.liugeng.liugengaliclouddemo.model.weixin.AccessTokenModel;

public class JsonTest extends LiugengAlicloudDemoApplicationTests{

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void test1() throws Exception {
		AccessTokenModel tokenModel = new AccessTokenModel();
		tokenModel.setAccessToken("132231231");
		tokenModel.setExpiresIn(new Date());
		String tokenString = objectMapper.writeValueAsString(tokenModel);
		System.out.println(tokenString);
	}

	@Test
	public void test2() throws Exception {
		String tokenString = "{\"access_token\":\"132231231\",\"expires_in\":9999999}";
		AccessTokenModel newModel = objectMapper.readValue(tokenString, AccessTokenModel.class);
		System.out.println(newModel);
		System.out.println(objectMapper.writeValueAsString(newModel));
	}

	@Test
	public void test3() throws Exception {
		String modelStr = "{\"account\":\"132231231\",\"password\":\"9999999\", \"keepLogin\":true}";
		LoginRequest request = objectMapper.readValue(modelStr, LoginRequest.class);
		System.out.println(request);
	}

}
