package cn.itcast.order.util;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class testredis {

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Test
    public  void set(){
        System.out.println("1111111");
        redisTemplate.opsForValue().set("name","zhangsan");
    }
    @Test
    public void get(){

    }
}
