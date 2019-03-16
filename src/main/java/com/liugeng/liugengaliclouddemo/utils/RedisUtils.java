package com.liugeng.liugengaliclouddemo.utils;

import com.liugeng.liugengaliclouddemo.model.weixin.WeixinUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RedisUtils {
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    Jackson2JsonRedisSerializer<WeixinUserDto> weixinUserSerializer;

    public Boolean publishWeixinMsg(String chatKey, WeixinUserDto userDto) {
        double createTime = userDto.getCreateTime();
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            byte[] key = redisTemplate.getStringSerializer().serialize(chatKey);
            return connection.zAdd(key, createTime, weixinUserSerializer.serialize(userDto));
        });
    }

    public List<WeixinUserDto> getWeixinMsgListByPage(String chatKey, int start, int end) {
        return redisTemplate.execute((RedisCallback<List<WeixinUserDto>>) connection -> {
            byte[] key = redisTemplate.getStringSerializer().serialize(chatKey);
            return connection.zRevRange(key, start, end)
                    .stream()
                    .map(bytes -> weixinUserSerializer.deserialize(bytes))
                    .collect(Collectors.toList());
        });
    }
}
