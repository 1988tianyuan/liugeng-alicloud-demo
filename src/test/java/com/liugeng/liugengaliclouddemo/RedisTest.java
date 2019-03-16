package com.liugeng.liugengaliclouddemo;

import com.liugeng.liugengaliclouddemo.model.weixin.WeixinUserDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RedisTest extends LiugengAlicloudDemoApplicationTests {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    Jackson2JsonRedisSerializer<WeixinUserDto> weixinUserSerializer;

    @Test
    public void test() {
//        final WeixinUserDto weixinUser = WeixinUserDto.builder().avatarUrl("https://wx.qlogo.cn/mmopen/vi_32/uMNIkiafz2NspFaC1M9ORkA1yDbAZ4NKVcHzDS6jwqVYlSibjAUIficjE1gnbHt6ice9fLickhU8UBgQzxRELUIicKqA/132")
//                .createTime(System.currentTimeMillis()).message("这是消息！").nickName("天渊").build();
//        Long result1 = redisTemplate.execute((RedisCallback<Long>) connection -> {
//            byte[] key = redisTemplate.getStringSerializer().serialize("chat");
//            return connection.lPush(key, weixinUserSerializer.serialize(weixinUser));
//        });
//        System.out.println(result1);
//        List<WeixinUserDto> weixinUserDto = redisTemplate.execute((RedisCallback<List<WeixinUserDto>>) connection -> {
//            byte[] key = redisTemplate.getStringSerializer().serialize("chat");
//            return connection.lRange(key, 0, 10)
//                    .stream()
//                    .map(bytes -> weixinUserSerializer.deserialize(bytes))
//                    .sorted((o1, o2) -> (int)(o1.getCreateTime() - o2.getCreateTime()))
//                    .collect(Collectors.toList());
//
//        });
//        System.out.println("消息一共有：" + weixinUserDto);
    }

}
