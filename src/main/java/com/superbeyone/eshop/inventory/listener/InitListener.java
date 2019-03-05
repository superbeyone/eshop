package com.superbeyone.eshop.inventory.listener;

import com.superbeyone.eshop.inventory.thread.RequestProcessorThreadPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className InitListener
 * @description 系统初始化监听器
 * @date 2019-03-05 11:11
 **/

public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化工作线程池和内存队列
        RequestProcessorThreadPool.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
