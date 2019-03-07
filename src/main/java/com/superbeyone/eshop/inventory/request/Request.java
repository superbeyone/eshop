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

    /**
     * 获取ProductId
     * @return
     */
    Integer getProductId();

    /**
     * 是否需要强制刷新的标识位
     * @return
     */
    boolean isForceRefresh();
}
