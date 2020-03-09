package com.example.redisDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author LiangGengguang
 * @create 2020-03-07 23:28
 */
@Service
public class RedisService implements MessageListener {

    @Autowired
    RedisTemplate redisTemplate;

    //五种基本类型
    public String string(String key, String val) {
        redisTemplate.opsForValue().set(key, val);
        return   (String) redisTemplate.opsForValue().get(key);
    }

    public String hash(String map, String key, String val) {
        redisTemplate.opsForHash().put(map, key, val);
        return (String) redisTemplate.opsForHash().get(map, key);
    }

    public List list(String map, long key, String val) {
        redisTemplate.opsForList().set(map, key, val);
        return redisTemplate.opsForList().range(map, 0, -1);
    }

    public Set set(String key, String val01, String val02) {
        redisTemplate.opsForSet().add(key, val01, val02);
        return redisTemplate.opsForSet().members(key);
    }

    public Set zSet(String key, String val, long num) {
        redisTemplate.opsForZSet().add(key, val, num);
        return redisTemplate.opsForZSet().range(key, 0, -1);
    }


    //订阅与发布
    public void publish(ChannelTopic topic, String message) {

        redisTemplate.convertAndSend(topic.getTopic(), message);
    }


    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("接收到的主题:" + new String(bytes) + "，接收到的内容：" + new String(message.getBody()) + "");
    }
}
