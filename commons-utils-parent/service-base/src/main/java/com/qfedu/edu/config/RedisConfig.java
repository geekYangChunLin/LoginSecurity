package com.qfedu.edu.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author：当归
 * @description: Redis编写配置的地方
 * @Date：2024/6/22 下午9:27
 */
@ConditionalOnProperty(name = "config.enable.redis", havingValue = "true")
@SpringBootConfiguration
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        //序列化的配置
        //什么是序列化？将原始的数据 弄成我们希望的样子存储到Redis中
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        //设置这个工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //做开发的时候要注意 事务的支持
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }
}
