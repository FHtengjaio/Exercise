package cn.com.exercise;

class DeadLock {
    public void method1(){
        synchronized (String.class){
            System.out.println(Thread.currentThread().getName()+" method1: String class is locked");
            synchronized (Integer.class){
                System.out.println(Thread.currentThread().getName()+" method1: Integer class is locked");
            }
        }
    }
    public void method2(){
        synchronized (String.class){
            System.out.println(Thread.currentThread().getName()+" method2: String class is locked");
            synchronized (Integer.class){
                System.out.println(Thread.currentThread().getName()+" method2: Integer class is locked");
            }
        }
    }

}

class DeadLockDemo implements Runnable{

    private DeadLock dl = new DeadLock();

    @Override
    public void run() {
       while(true){
          dl.method1();
          dl.method2();
       }
    }

    public static void main(String[] args) {
        DeadLockDemo dld1 = new DeadLockDemo();
        Thread t1 = new Thread(dld1);
        Thread t2 = new Thread(dld1);
        t1.start();
        t2.start();
    }
}