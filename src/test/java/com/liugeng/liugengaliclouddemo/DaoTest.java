package com.liugeng.liugengaliclouddemo;

import javax.persistence.Table;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.liugeng.liugengaliclouddemo.dao.UserDao;
import com.liugeng.liugengaliclouddemo.model.dto.UserDto;

public class DaoTest extends LiugengAlicloudDemoApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	public void findAll() {
		System.out.println(userDao.findAll());
	}

	@Test
	public void findByName() {
		System.out.println(userDao.findUserByName("刘耕"));
	}

//	@Test
//	public void updateOne() {
//		UserDto user = userDao.findUserByName("刘耕");
//		user.setAccount("liugeng");
//		userDao.save(user);
//	}

//	@Test
//	public void saveOne() {
//		userDao.save(new UserDto(null, "yexiaozhou","叶小舟", "123456", "我是叶小舟", 29));
//	}
//
//	@Test
//	public void deleteOne() {
//		userDao.deleteById(1L);
//	}
}
