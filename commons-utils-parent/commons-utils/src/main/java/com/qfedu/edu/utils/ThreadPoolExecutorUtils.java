package com.qfedu.edu.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author：当归
 * @description: 线程池的这个工具类
 * @Date：2024/6/22 下午8:37
 */
public class ThreadPoolExecutorUtils {
    //这个是清理任务的线程池
    private static final ThreadPoolExecutor clearJobThreadPoolExecutor = new ThreadPoolExecutor(
            10,
            100,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(8192)
    );
    public static ThreadPoolExecutor getClearJobThreadPoolExecutor(){
        return clearJobThreadPoolExecutor;
    }
}
