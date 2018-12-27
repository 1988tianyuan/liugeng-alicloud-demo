package com.liugeng.liugengaliclouddemo.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
	@Index(name = "account_index", columnList = "account", unique = true)
})
public class UserDto{

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String account;

	@Column
	private String name;

	@Column
	private String password;

	@Column
	private String info;

}
