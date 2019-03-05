package com.superbeyone.eshop.inventory.controller;

import com.superbeyone.eshop.inventory.model.User;
import com.superbeyone.eshop.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className UserController
 * @description UserController
 * @date 2019-03-05 16:36
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUserInfo")
    public User getUserInfo(){
        return userService.findUserInfo();
    }

    @RequestMapping("/getCachedUserInfo")
    public User getCachedUserInfo(){
        return userService.getCachedUserInfo();
    }

}
