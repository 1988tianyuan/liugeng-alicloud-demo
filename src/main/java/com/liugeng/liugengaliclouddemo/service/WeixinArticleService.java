package com.liugeng.liugengaliclouddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.liugeng.liugengaliclouddemo.model.weixin.AccessTokenModel;
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
		String token = getAccessToken();
		String articleListString =  restTemplate.getForObject(articleUrl + "?" + "accessToken=" + token, String.class);
		log.info("article list: " + articleListString);
		return articleListString;
	}


}
