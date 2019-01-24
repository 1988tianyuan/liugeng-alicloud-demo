package com.liugeng.liugengaliclouddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.liugeng.liugengaliclouddemo.model.dto.UserDto;

public interface UserDao extends JpaRepository<UserDto, Long> {

	UserDto findUserByName(String name);

	UserDto findUserDtoByAccount(String account);

	List<UserDto> findAll();

}
