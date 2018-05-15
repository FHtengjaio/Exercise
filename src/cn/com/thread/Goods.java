package cn.com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Goods {
    private int number;
    private boolean flag = false;

    private Lock lock = new ReentrantLock();
    private Condition conPro = lock.newCondition();
    private Condition conCon = lock.newCondition();

    public int getNumber() {
        return number;
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getConPro() {
        return conPro;
    }

    public Condition getConCon() {
        return conCon;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
