package com.liugeng.liugengaliclouddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liugeng.liugengaliclouddemo.model.weixin.WeixinArticleList;
import com.liugeng.liugengaliclouddemo.service.WeixinArticleService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class WeixinArticleContoller {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeixinArticleService articleService;

	@Value("${weixin.article.url}")
	private String url;

	@GetMapping("/list")
	public WeixinArticleList getArticleList() {
		WeixinArticleList articleList =
			restTemplate.getForObject(url + "?" + "accessToken=" + articleService.getAccessToken(), WeixinArticleList.class);
		log.info("article list: " + articleList);
		return articleList;
	}

	@GetMapping("/listString")
	public String getArticleListString() {
		return articleService.getArticleListString();
	}


}
