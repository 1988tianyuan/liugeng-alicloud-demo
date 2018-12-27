package com.liugeng.liugengaliclouddemo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liugeng.liugengaliclouddemo.dao.UserDao;
import com.liugeng.liugengaliclouddemo.model.dto.UserDto;

@RestController
@CrossOrigin
@RequestMapping(path = {"/index", "/"})
public class IndexController {

	@RequestMapping("/test")
	public List<String> test() {
		List<String> names = new LinkedList<>();
		names.add("刘耕");
		names.add("飞熊");
		names.add("舟雄");
		return names;
	}

}
