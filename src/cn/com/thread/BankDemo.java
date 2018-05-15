package cn.com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank(3500.0);
        new Thread(new Account("Jack", 799.0, bank)).start();
        new Thread(new Account("Tmo", 500.0, bank)).start();
    }

}

class Bank{
    private double money;
    private Lock lock = new ReentrantLock();
    private Condition con1 = lock.newCondition();
    public Bank(double money){
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money){
        this.money = money;
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getCon1() {
        return con1;
    }

}

class Account implements Runnable{
    private String name;
    private double drawMoney;
    private Bank bank;
    private Lock lock;

    public Account(String name, double drawMoney, Bank bank){
        this.name = name;
        this.drawMoney = drawMoney;
        this.bank = bank;
        this.lock = bank.getLock();
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            lock.lock();
            try {
                if (bank.getMoney() > drawMoney) {
                    System.out.println(this.name + "取出" + drawMoney + "元");
                    bank.setMoney(bank.getMoney() - drawMoney);
                    System.out.println("余额为"+bank.getMoney());
                }
                else
                    System.out.println(this.name+"取钱失败，余额不足！！");
            }
            finally {
                lock.unlock();
            }
        }
    }
}