package com.liugeng.liugengaliclouddemo.model.weixin;

import java.util.List;

import lombok.Data;

@Data
public class WeixinArticleList {
	long totalCount;
	long itemCount;
	List<WeixinArticleItem> item;
	String errcode;
	String errmsg;
}
