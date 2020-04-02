package com.example.redisDemo.action;

import com.example.redisDemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author LiangGengguang
 * @create 2020-03-07 23:36
 */
@RestController
@RequestMapping("/action")
public class RedisAction {

    @Autowired
    RedisService redisService;

    @GetMapping("/string")
    public String string(String key, String val) {
        redisService.setString(key, val);
        return redisService.getString(key);
    }

    @GetMapping("/hash")
    public String hash(String map, String key, String val) {
        redisService.setHash(map, key, val);
        return redisService.getHash(map, key);
    }

    @GetMapping("/list")
    public List list(String key, String val) {
        redisService.setList(key, val);
        return redisService.getList(key);
    }

    @GetMapping("/set")
    public Set set(String key, String val01, String val02) {
        redisService.setSet(key, val01, val02);
        return redisService.getSet(key);
    }

    @GetMapping("/zset")
    public Set zSet(String key, String val, long num) {
        redisService.setZSet(key, val, num);
        return redisService.getZSet(key);
    }

}

