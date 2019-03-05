package com.superbeyone.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.superbeyone.eshop.inventory.mapper.UserMapper;
import com.superbeyone.eshop.inventory.model.User;
import com.superbeyone.eshop.inventory.persist.RedisDao;
import com.superbeyone.eshop.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className UserServiceImpl
 * @description
 * @date 2019-03-05 16:30
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Autowired
    RedisDao redisDao;

    @Override
    public User findUserInfo() {
        return userMapper.findUserInfo();
    }

    @Override
    public User getCachedUserInfo() {
        //redisDao.set("cached_name", "{'name':'zhangsan','age':20}");
        String cached_name = redisDao.get("cached_name");
        User user = new User();
        if(null != cached_name){

            JSONObject jsonObject = JSONObject.parseObject(cached_name);
            user.setName(jsonObject.getString("name"));
            user.setAge(jsonObject.getInteger("age"));
        }

        return user;
    }
}
