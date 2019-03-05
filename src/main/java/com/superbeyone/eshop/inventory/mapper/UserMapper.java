package com.superbeyone.eshop.inventory.mapper;

import com.superbeyone.eshop.inventory.model.User;
import org.springframework.stereotype.Component;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className UserMapper
 * @description UserMapper
 * @date 2019-03-05 16:24
 **/
@Component
public interface UserMapper {
    /**
     * find UserInfo
     * @return
     */
    User findUserInfo();

}
