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

        return redisService.string(key, val);
    }

    @GetMapping("/hash")
    public String hash(String map, String key, String val) {

        return redisService.hash(map, key, val);
    }

    @GetMapping("/list")
    public List list(String map, long key, String val) {

        return redisService.list(map, key, val);
    }

    @GetMapping("/set")
    public Set set(String key, String val01, String val02) {

        return redisService.set(key, val01, val02);
    }

    @GetMapping("/zset")
    public Set zSet(String key, String val, long num) {

        return redisService.zSet(key, val, num);
    }

}

