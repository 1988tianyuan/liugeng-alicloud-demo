package com.liugeng.liugengaliclouddemo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LiugengAlicloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiugengAlicloudDemoApplication.class, args);
	}
}

