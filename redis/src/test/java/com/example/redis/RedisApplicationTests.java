package com.example.redis;

import com.example.redis.dao.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate1;
    @Autowired
    User user;
    @Test
    void contextLoads() {
        System.out.println("1111111");
        redisTemplate1.boundValueOps("name1").set("lisi");
    }

    @Test
    void get (){
        String name = (String) redisTemplate1.opsForValue().get("name1");
        System.out.println(name);
    }
}
