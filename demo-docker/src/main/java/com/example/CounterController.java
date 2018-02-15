package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    @Autowired
    private StringRedisTemplate template;


    @RequestMapping("/counter")
    public String counter() {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";

        return ops.increment(key, 1).toString();
    }
}
