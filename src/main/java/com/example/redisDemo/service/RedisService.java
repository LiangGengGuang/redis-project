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
    public String setString(String key, String val) {
        redisTemplate.opsForValue().set(key, val);
        return "success";
    }

    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public String setHash(String map, String key, String val) {
        redisTemplate.opsForHash().put(map, key, val);
        return "success";
    }

    public String getHash(String map, String key) {
        return (String) redisTemplate.opsForHash().get(map, key);
    }

    public String setList(String key, String val) {
        redisTemplate.opsForList().leftPush(key, val);
        return "success";
    }

    public List getList(String map) {
        return redisTemplate.opsForList().range(map, 0, -1);
    }

    public String setSet(String key, String val01, String val02) {
        redisTemplate.opsForSet().add(key, val01, val02);
        return "success";
    }

    public Set getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    public String setZSet(String key, String val, long num) {
        redisTemplate.opsForZSet().add(key, val, num);
        return "success";
    }

    public Set getZSet(String key) {
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
