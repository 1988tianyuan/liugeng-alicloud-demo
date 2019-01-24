package com.liugeng.liugengaliclouddemo.model.weixin;

import lombok.Data;

@Data
public class WeixinArticleItem {
	String mediaId;
	String updateTime;
	WeixinArticleContent content;
}
