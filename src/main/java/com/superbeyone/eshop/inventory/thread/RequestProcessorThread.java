package com.superbeyone.eshop.inventory.thread;

import com.superbeyone.eshop.inventory.request.Request;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className RequestProcessorThread
 * @description 执行请求的工作线程
 * @create 2019-03-05 10:29
 **/

public class RequestProcessorThread implements Callable<Boolean> {

    private ArrayBlockingQueue<Request> queue;

    public RequestProcessorThread(ArrayBlockingQueue<Request> queue) {
        this.queue = queue;
    }

    @Override
    public Boolean call() throws Exception {
        while (true){
            break;
        }
        return true;
    }
}
