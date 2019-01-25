package com.liugeng.liugengaliclouddemo.controller;

import java.nio.charset.Charset;
import java.util.Collections;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.liugeng.liugengaliclouddemo.model.weixin.ArticleFetchRequest;
import com.liugeng.liugengaliclouddemo.model.weixin.WeixinArticleList;
import com.liugeng.liugengaliclouddemo.service.WeixinArticleService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class WeixinArticleContoller {

	@Autowired
	private WeixinArticleService articleService;

	@Value("${weixin.article.url}")
	private String url;

	@GetMapping("/list")
	public WeixinArticleList getArticleList() throws Exception {
		return articleService.getArticleList();
	}

	@GetMapping("/article")
	public String getArticle() throws Exception {
		WeixinArticleList articleList = articleService.getArticleList();
		return StringEscapeUtils.unescapeJson(articleList.getItem().get(0).getContent().getNewsItem().get(0).getContent());
	}


}
