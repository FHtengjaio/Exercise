package cn.com.thread;

public class ThreadDemo {

    public static void main(String[] args) {
        Goods goods = new Goods();
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        Thread thread3 = new Thread(producer);
        Thread thread4 = new Thread(consumer);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
