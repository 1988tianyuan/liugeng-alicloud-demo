package com.liugeng.liugengaliclouddemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liugeng.liugengaliclouddemo.model.weixin.WeixinUserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public Jackson2JsonRedisSerializer<WeixinUserDto> weixinUserSerializer(ObjectMapper objectMapper) {
        Jackson2JsonRedisSerializer<WeixinUserDto> redisSerializer = new Jackson2JsonRedisSerializer<>(WeixinUserDto.class);
        redisSerializer.setObjectMapper(objectMapper);
        return redisSerializer;
    }
}
