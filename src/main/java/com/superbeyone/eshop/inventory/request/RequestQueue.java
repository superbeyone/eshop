package com.superbeyone.eshop.inventory.request;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className RequestQueue
 * @description 请求内存队列
 * @date 2019-03-05 10:40
 **/

public class RequestQueue {
    /**
     * 内存队列
     */
    private ArrayList<ArrayBlockingQueue<Request>> queues = new ArrayList<ArrayBlockingQueue<Request>>();

    /**
     * 采用内部类的方式，初始化单例，线程安全
     */
    private static class Singleton{
        private static RequestQueue instance;
        static {
            instance = new RequestQueue();
        }

        public static RequestQueue getInstance(){
            return instance;
        }
    }

    /**
     * 利用jvm的机制保证多线程并发安全
     * 内部类的初始化，不管多少个线程并发去初始化，一定只会发生一次
     * @return
     */
    public static RequestQueue getInstance(){
        return Singleton.getInstance();
    }

    /**
     * 添加一个内存队列
     * @param queue
     */
    public void addQueue(ArrayBlockingQueue<Request> queue){
        this.queues.add(queue);
    }

    /**
     * 获取内存队列的数量
     * @return
     */
    public int queueSize(){
        return this.queues.size();
    }

    /**
     * 获取内存队列
     * @param index
     * @return
     */
    public ArrayBlockingQueue<Request> getQueue(int index){
        return queues.get(index);
    }
}
