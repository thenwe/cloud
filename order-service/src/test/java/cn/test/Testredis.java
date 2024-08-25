package cn.test;

import cn.itcast.order.OrderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= OrderApplication.class)
public class Testredis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public  void set(){

        System.out.println("1111111");
        redisTemplate.opsForValue().set("name","zhangsan");
    }
    @Test
    public void get(){

    }
}
