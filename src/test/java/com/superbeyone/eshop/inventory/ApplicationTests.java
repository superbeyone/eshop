package com.superbeyone.eshop.inventory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    ValueOperations<String, String> valueOperations;

    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
    }

    @Test
    public void testString() {
//        valueOperations.set("name", "小冰");
        System.out.println(valueOperations.get("k1"));
        System.out.println("----------------");


    }

}
