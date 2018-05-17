package cn.com.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ListDemo {
    public static void main(String[] args) {
        demo2();
    }
    /*
    * 在一个集合中存储了无序并且重复的字符串，定义一个方法，让其有序（字典排序）还不能去除重复的元素输出。
    * */
    public static void demo1(){
        List<String> list = new ArrayList<>();
        list.add("ba");
        list.add("nba1");
        list.add("cba");
        list.add("java");
        list.add("android");
        list.add("cbadsafsd");
        list.add("javaScript");
        list.add("c++");
        list.add("html");
        list.add("css");
        list.add("nba");
        list.add("android");
        list.sort(Comparator.comparingInt(String::length).reversed());
        list.forEach(System.out::println);
    }
    /*
    * 程序启动之后，可以从键盘输入接收多个整数，直到输入quit的时结束输入，把输入过的整数倒序排序输出。
    * */
    public static void demo2(){
        System.out.println("请输入你需要排序的整数，输入“quit”结束：");
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        BufferedReader bufr = null;
        try {
            bufr = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while((line=bufr.readLine())!=null){
                if("quit".equals(line))
                    break;
                try{
                    Integer i = Integer.valueOf(line);
                    treeSet.add(i);
                }catch (Exception e1){
                    System.out.println("输入的不是整数，请正常输入");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufr!=null){
                try{
                    bufr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        treeSet.forEach(System.out::println);
    }
}
