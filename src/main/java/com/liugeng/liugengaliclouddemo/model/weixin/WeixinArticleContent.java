package com.liugeng.liugengaliclouddemo.model.weixin;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class WeixinArticleContent {

	List<WeixinArticleNewsItem> newsItem;
	Date createTime;
	Date updateTime;

}
