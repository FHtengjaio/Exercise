package cn.com.netdown;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtil {
    //下载资源的路径
    private String urlPath;
    //下载后资源存放的路径
    private String targetFile;
    //资源的大小
    private int fileSize;
    //下载线程的个数
    private int threadNum;
    //下载线程的对象数组
    private DownThread[] threads;

    public DownUtil(String urlPath, String targetFile, int threadNum) {
        this.urlPath = urlPath;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        threads = new DownThread[threadNum];
    }

    public void download() throws Exception {
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(5 * 1000);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("Accept-Language", "zh-CN");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("Connection","Keep-Alive");
        //得到文件大小
        fileSize = connection.getContentLength();
        connection.disconnect();
        //计算每个线程需要下载的大小
        int currentFileSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        file.setLength(fileSize);
        file.close();
        for (int i=0; i<threadNum; i++){
            //计算下载的起始点
            int startPos = i * currentFileSize;
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            currentPart.seek(startPos);
            threads[i] = new DownThread(startPos, currentFileSize, currentPart);
            new Thread(threads[i]).start();
        }
    }

    public double getCompleteRate(){
        int sumLength = 0;
        for (int i=0; i< threadNum; i++){
            sumLength += threads[i].getLength();
        }
        return sumLength * 1.0 / fileSize;
    }

    private class DownThread implements Runnable{
        private int startPos;
        private int currentFileSize;
        private RandomAccessFile currentPart;
        private int length;

        public DownThread(int startPos, int currentFileSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPart = currentPart;
            this.currentFileSize = currentFileSize;
        }

        public int getLength(){
            return length;
        }

        @Override
        public void run() {
            try{
                URL url = new URL(urlPath);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5 * 1000);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "*/*");
                connection.setRequestProperty("Accept-Language", "zh-CN");
                connection.setRequestProperty("Charset", "UTF-8");
                connection.setRequestProperty("Connection","Keep-Alive");
                InputStream in = connection.getInputStream();
                in.skip(this.startPos);
                byte[] buff = new byte[1024];
                int len = 0;
                while(length < currentFileSize && (len=in.read(buff)) != -1){
                    currentPart.write(buff,0,len);
                    length = length + len;
                }
                currentPart.close();
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
