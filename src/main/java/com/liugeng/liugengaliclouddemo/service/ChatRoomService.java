package com.liugeng.liugengaliclouddemo.service;

import com.liugeng.liugengaliclouddemo.model.weixin.WeixinUserDto;
import com.liugeng.liugengaliclouddemo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    private RedisUtils redisUtils;
    @Value("${weixin.chat.key}")
    private String chatKey;

    public String publishMsg(WeixinUserDto userDto) {
        userDto.setCreateTime(System.currentTimeMillis());
        boolean num = redisUtils.publishWeixinMsg(chatKey, userDto);
        System.out.println("当前num:" + num);
        return num ? "发布成功！" : "发布失败！";
    }

    public List<WeixinUserDto> getMsgListByPage(int start, int end) {
        return redisUtils.getWeixinMsgListByPage(chatKey, start, end);
    }


}
