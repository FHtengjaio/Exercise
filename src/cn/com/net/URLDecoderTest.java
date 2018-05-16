package cn.com.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
    public static void main(String[] args) {
        try {
            String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82java","utf-8");
            System.out.println(keyWord);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String urlStr = URLEncoder.encode("疯狂Android讲义", "GBK");
            System.out.println(urlStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
