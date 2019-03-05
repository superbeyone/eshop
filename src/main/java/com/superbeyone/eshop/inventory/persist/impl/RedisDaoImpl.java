package com.superbeyone.eshop.inventory.persist.impl;

import com.superbeyone.eshop.inventory.persist.RedisDao;
import com.superbeyone.eshop.inventory.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className RedisDaoImpl
 * @description
 * @create 2019-03-04 16:43
 **/
@Repository("redisDao")
public class RedisDaoImpl implements RedisDao {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;



    @Override
    public void set(String key, String value) {
        redisUtil.set(key, value);
    }

    @Override
    public String get(String key) {
        return (String) redisUtil.get(key);
    }


}
