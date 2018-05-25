package cn.com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*
* Callable总结：
* 实现Callable的对象需以参数的形式传递给FutureTask对象。
* 因为FutureTask实现了Runnable接口和Future接口。
* Thread类只能接受Runnable接口对象的参数，因此FutureTask对象可以传递给Thread;
* Future接口中定义了get()方法，因此FutureTask可以调用get()方法获取Callable接口对象中call()方法的返回值
* */
public class CallableDemo {
    public static void main(String[] args) {
        callableDemo3();
    }

    public static void callableDemo3() {
        FutureTask<Integer> futureTask = new FutureTask<>(new myCallable());
        for (int i = 0; i < 100; i++) {
            if (i == 20)
                new Thread(futureTask, "callable3的线程").start();
            System.out.println(Thread.currentThread().getName() + "的循环变量:" + i);
        }
        try {
            System.out.println("子线程的返回值:"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

        public static void callableDemo2() {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i=0;
                for(;i<100;i++){
                    System.out.println(Thread.currentThread().getName()+"的循环变量:"+i);
                }
                return i;
            }
        });
        for(int i=0; i<100; i++){
            if(i==20)
                new Thread(futureTask, "callable2的线程").start();
            System.out.println(Thread.currentThread().getName()+"的循环变量:"+i);
        }
        try{
            System.out.println("子线程的返回值:"+futureTask.get());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void callableDemo1(){
        FutureTask<Integer> futureTask = new FutureTask<>(()->{
            int i = 0;
            for(;i<100;i++){
                System.out.println(Thread.currentThread().getName()+"的循环变量:"+i);
            }
            return i;
        });
        for(int i=0; i<100; i++){
            if(i==20)
                new Thread(futureTask, "callable1的线程").start();
            System.out.println(Thread.currentThread().getName()+"的循环变量:"+i);
        }
        try{
            System.out.println("子线程的返回值:"+futureTask.get());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class myCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int i=0;
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"的循环变量:"+i);
        }
        return i;
    }
}