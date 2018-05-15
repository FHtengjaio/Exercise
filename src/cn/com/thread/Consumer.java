package cn.com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{
    private Goods goods;
    private Lock lock;
    private Condition conCon;
    private Condition conPro;

    public Consumer(Goods goods){
       this.goods = goods;
       this.lock = goods.getLock();
       this.conCon = goods.getConCon();
       this.conPro = goods.getConPro();
    }

    public void consumeGoods(){
        goods.setFlag(false);
        System.out.println("消费商品："+goods.getNumber());
    }

    @Override
    public void run() {
        while(true){
            lock.lock();
            try{
                while(!goods.isFlag())
                    conCon.await();
                consumeGoods();
                conPro.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
