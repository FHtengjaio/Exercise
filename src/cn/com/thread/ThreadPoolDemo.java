package cn.com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(6);
        Runnable runnable = () -> {
            for (int i=0; i<100; i++){
                System.out.println(Thread.currentThread().getName()+"::"+i);
            }
        };
        es.submit(runnable);
        es.submit(runnable);
        es.shutdown();
    }
}
