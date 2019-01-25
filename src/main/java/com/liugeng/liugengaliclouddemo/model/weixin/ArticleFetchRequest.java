package com.liugeng.liugengaliclouddemo.model.weixin;

import lombok.Data;

@Data
public class ArticleFetchRequest {
	String type;
	int offset;
	int count;
}
