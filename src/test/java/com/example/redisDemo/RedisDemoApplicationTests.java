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
    void setString() {
        redisService.setString("age", "18");

    }

    @Test
    void getString() {
        System.out.println("==========================================");
        System.out.println(redisService.getString("age"));
        System.out.println("==========================================");
    }

    @Test
    void setHash() {
        redisService.setHash("list", "name", "lgg");
    }

    @Test
    void getHash() {
        System.out.println("==========================================");
        System.out.println(redisService.getHash("list", "name"));
        System.out.println("==========================================");
    }

    @Test
    void setList() {
        redisService.setList("listL", 1, "hello");
    }

    @Test
    void getList() {
        System.out.println("==========================================");
        System.out.println(redisService.getList("listL"));
        System.out.println("==========================================");
    }

    @Test
    void setSet() {
        redisService.setSet("msg", "hello01", "hello02");
    }

    @Test
    void getSet() {
        System.out.println("==========================================");
        System.out.println(redisService.getSet("msg"));
        System.out.println("==========================================");
    }

    @Test
    void setZSet() {
        redisService.setZSet("msg", "hello", 1);
    }

    @Test
    void getZSet() {
        System.out.println("==========================================");
        System.out.println(redisService.getZSet("msg"));
        System.out.println("==========================================");
    }


    @Test
    void publish() {
        ChannelTopic topic = new ChannelTopic("msg");
        System.out.println("==========================================");
        String message = "hello everyone";
        redisService.publish(topic, message);
        System.out.println("==========================================");
    }

}
