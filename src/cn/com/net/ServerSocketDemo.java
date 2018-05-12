package cn.com.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress());
        InputStream in = s.getInputStream();

        byte[] buff = new byte[1024];
        int len = in.read(buff);

        String str = new String(buff,0,len);
        System.out.println(str);

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("<html><body><h1>注册成功</h1></body></html>");
        s.close();
        ss.close();
    }
}
