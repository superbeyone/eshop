package com.superbeyone.eshop.inventory.request;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className Request
 * @description 请求接口
 * @create 2019-03-05 10:32
 **/

public interface Request {
    /**
     * 处理请求
     */
    void process();

    Integer getProductId();

    boolean isForceRefresh();
}
