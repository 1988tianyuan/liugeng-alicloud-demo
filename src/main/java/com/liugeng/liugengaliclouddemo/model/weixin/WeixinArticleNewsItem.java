package com.liugeng.liugengaliclouddemo.model.weixin;

import lombok.Data;

@Data
public class WeixinArticleNewsItem {

	String title;
	String thumbMediaId;
	String showCoverPic;
	String author;
	String digest;
	String content;
	String url;
	String contentSourceUrl;
	String thumbUrl;
	int needOpenComment;
	int onlyFansCanComment;
}
