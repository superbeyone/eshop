package com.superbeyone.eshop.inventory.service;

import com.superbeyone.eshop.inventory.request.Request;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className RequestAsyncProcessService
 * @description 请求异步处理
 * @date 2019-03-06 09:16
 **/

public interface RequestAsyncProcessService {

    void process(Request request);
}
