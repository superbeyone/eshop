package com.superbeyone.eshop.inventory.service;

import com.superbeyone.eshop.inventory.model.User;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className UserService
 * @description UserService
 * @date 2019-03-05 16:29
 **/

public interface UserService {
    /**
     * 获取user信息
     * @return
     */
    User findUserInfo();

    /**
     * 从缓存中获取用户信息
     * @return
     */
    User getCachedUserInfo();
}
