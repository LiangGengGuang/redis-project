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
        redisService.setString("string", "str");

    }

    @Test
    void getString() {
        System.out.println("==========================================");
        System.out.println(redisService.getString("string"));
        System.out.println("==========================================");
    }

    @Test
    void setHash() {
        redisService.setHash("hash", "name", "lgg");
    }

    @Test
    void getHash() {
        System.out.println("==========================================");
        System.out.println(redisService.getHash("hash", "name"));
        System.out.println("==========================================");
    }

    @Test
    void setList() {
        //lpush
        redisService.setList("list", "hello");
    }

    @Test
    void getList() {
        System.out.println("==========================================");
        System.out.println(redisService.getList("list"));
        System.out.println("==========================================");
    }

    @Test
    void setSet() {
        redisService.setSet("set", "hello01", "hello02");
    }

    @Test
    void getSet() {
        System.out.println("==========================================");
        System.out.println(redisService.getSet("set"));
        System.out.println("==========================================");
    }

    @Test
    void setZSet() {
        redisService.setZSet("zSet", "hello", 1);
    }

    @Test
    void getZSet() {
        System.out.println("==========================================");
        System.out.println(redisService.getZSet("zSet"));
        System.out.println("==========================================");
    }


    @Test
    void publish() {
        ChannelTopic topic = new ChannelTopic("msgTopic");
        System.out.println("==========================================");
        String message = "hello everyone";
        redisService.publish(topic, message);
        System.out.println("==========================================");
    }

}
