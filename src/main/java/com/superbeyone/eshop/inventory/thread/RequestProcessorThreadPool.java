package com.superbeyone.eshop.inventory.thread;

import com.superbeyone.eshop.inventory.request.Request;
import com.superbeyone.eshop.inventory.request.RequestQueue;
import org.apache.tomcat.util.threads.TaskThreadFactory;

import java.util.concurrent.*;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className RequestProcessorThreadPool
 * @description 请求处理线程池，单例实现
 * @date 2019-03-05 10:52
 **/

public class RequestProcessorThreadPool {
    /**
     * 线程池
     */
    private ExecutorService threadPool = new ThreadPoolExecutor(10, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
            new TaskThreadFactory("thread-pool", false, 1));

    public RequestProcessorThreadPool() {
        RequestQueue requestQueue = RequestQueue.getInstance();
        for (int i = 0; i < 10; i++) {
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<>(100);
            requestQueue.addQueue(queue);
            threadPool.submit(new RequestProcessorThread(queue));

        }
    }

    private static class Singleton{
        private static RequestProcessorThreadPool instance;

        static {
            instance = new RequestProcessorThreadPool();
        }

        public static RequestProcessorThreadPool getInstance(){
            return instance;
        }
    }

    public static RequestProcessorThreadPool getInstance(){
        return Singleton.getInstance();
    }

    public static void init(){
        getInstance();
    }

}
