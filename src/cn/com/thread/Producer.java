package cn.com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable{
    private int number = 0;
    private Goods goods;
    private Lock lock;
    private Condition conCon;
    private Condition conPro;

    public Producer(Goods goods){
        this.goods = goods;
        this.lock = goods.getLock();
        this.conCon = goods.getConCon();
        this.conPro = goods.getConPro();
    }

    public void produceGoods(){
        goods.setNumber(++number);
        goods.setFlag(true);
        System.out.println("--生产商品--："+number);
    }

    @Override
    public void run() {
        while(true) {
            lock.lock();
            try {
                while (goods.isFlag())
                    conPro.await();
                produceGoods();
                conCon.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
