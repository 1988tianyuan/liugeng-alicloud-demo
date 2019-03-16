package com.liugeng.liugengaliclouddemo.model.weixin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeixinUserDto {

    private String nickName;

    private String avatarUrl;

    private Long createTime;

    private String message;
}
