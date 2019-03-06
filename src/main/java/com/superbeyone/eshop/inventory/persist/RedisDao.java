package com.superbeyone.eshop.inventory.persist;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className RedisDao
 * @description RedisDao
 * @create 2019-03-04 16:34
 **/

public interface RedisDao {

    void set(String key, String value);

    String get(String key);

    void del(String key);

}
