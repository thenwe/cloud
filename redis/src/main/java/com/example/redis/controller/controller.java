package com.example.redis.controller;

import com.example.redis.aotation.Mylog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @GetMapping("rwl/{order}")
    @Mylog(value = "zhansan")
    public String testAop(@PathVariable("order") int order){
        System.out.println(order);
        return "print log";
    }
}
