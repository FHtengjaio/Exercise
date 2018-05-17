package cn.com.netdown;

public class DownLoader {
    public static void main(String[] args) {
        DownUtil downUtil = new DownUtil("http://p15.qhimg.com/bdr/__85/t0160c2a0a5f8dd2420.jpg","E:\\self study\\javacode\\ios.png",4);
        try {
            downUtil.download();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(()->{
           while(downUtil.getCompleteRate()<1) {
               System.out.println("当前下载进度为："+downUtil.getCompleteRate());
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();
    }
}
