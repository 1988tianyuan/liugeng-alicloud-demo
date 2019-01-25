package com.liugeng.liugengaliclouddemo.service;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liugeng.liugengaliclouddemo.model.weixin.AccessTokenModel;
import com.liugeng.liugengaliclouddemo.model.weixin.ArticleFetchRequest;
import com.liugeng.liugengaliclouddemo.model.weixin.WeixinArticleList;
import com.liugeng.liugengaliclouddemo.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeixinArticleService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${weixin.token.url}")
	private String tokenUrl;

	@Value("${weixin.article.url}")
	private String articleUrl;

	@Value("${weixin.appId}")
	private String appId;

	@Value("${weixin.appSecret}")
	private String appSecret;

	@Autowired
	private ObjectMapper objectMapper;

	public String getAccessToken() {
		String url = tokenUrl + "&" + "appId=" + appId + "&secret=" + appSecret;
		try {
			AccessTokenModel token = restTemplate.getForObject(url, AccessTokenModel.class);
			log.info("token is {}", token);
			if (token != null) {
				return token.getAccessToken();
			}
		} catch (RestClientException e) {
			log.warn("can't get token", e);
		}
		return null;
	}

	public String getArticleListString() {
		ArticleFetchRequest request = new ArticleFetchRequest();
		request.setType("news");
		request.setCount(20);
		request.setOffset(0);
		HttpHeaders headers = new HttpHeaders();
		headers.setAcceptCharset(Collections.singletonList(Charset.defaultCharset()));
		HttpEntity<ArticleFetchRequest> fetchRequestEntity = new HttpEntity<>(request, headers);
		ResponseEntity<byte[]> responseEntity =  restTemplate.postForEntity(articleUrl + "?" + "access_token=" + getAccessToken(),
			fetchRequestEntity, byte[].class);
		String content = new String(responseEntity.getBody(), Charset.defaultCharset());
		log.info("article list response headers: {}", responseEntity.getHeaders());
		log.info("article list String: " + content);
		return content;
	}


	public WeixinArticleList getArticleList() throws Exception{
		String articleListString = getArticleListString();
		WeixinArticleList articleList = objectMapper.readValue(articleListString, WeixinArticleList.class);
		log.info("article list: " + articleList);
		return articleList;
	}



}
