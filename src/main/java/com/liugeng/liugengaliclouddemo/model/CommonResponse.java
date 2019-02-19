package com.liugeng.liugengaliclouddemo.model;

import lombok.Data;

@Data
public class CommonResponse<T> {

	private String msg;
	private int code;
	private T data;

}
