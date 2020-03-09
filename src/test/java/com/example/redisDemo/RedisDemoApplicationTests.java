package com.example.redisDemo;

import com.example.redisDemo.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.listener.ChannelTopic;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    RedisService redisService;

    @Test
    void string() {

        redisService.string("msg", "hello");
    }

    @Test
    void hash() {

        redisService.hash("list", "name", "lgg");
    }

    @Test
    void list() {

        redisService.list("listL", 1, "hello");
    }

    @Test
    void set() {

        redisService.set("msg", "hello01", "hello02");
    }

    @Test
    void zSet() {

        redisService.zSet("msg", "hello", 1);
    }


    @Test
    void publish() {
        ChannelTopic topic = new ChannelTopic("msg");
        String message = "hello everyone";
        redisService.publish(topic, message);

    }

}
