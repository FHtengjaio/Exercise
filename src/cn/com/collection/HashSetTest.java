package cn.com.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;


public class HashSetTest {
    public static void main(String[] args) throws IOException {
        demo3();
    }

    /*
     * 需求：生成10个1到20之间不重复的随机整数。
     * 思路：利用Random类中nextInt()方法产生随机整数，将该生成的整数放入Set集合中。
     * 可以利用Set集合的不同实现类来实现需要的功能，如排序可以使用TreeSet；元素需要按加入集合的顺序打印的话可以用LinkedHashSet
     * */
    public static void demo1() {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Random random = new Random();
        int element = 0;
        for (; set.size() <= 10; ) {
            element = random.nextInt(20) + 1;
            if(!set.contains(element))
                System.out.print(element+" ");
            set.add(element);
        }
        System.out.println();
        for (Integer i : set)
            System.out.print(i+" ");
    }
    /*
    * 需求：键盘录入一串字符串，出去重复的字符后，打印在控制台
    * 思路：利用Scanner类获取输入的字符串，然后将字符串转化成char字符数组，遍历数组放进LinkedHashSet集合中，遍历LinkedHashSet集合
    * */
    public static void demo2(){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        System.out.print("请输入字符串:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        for (char c: chars){
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: set){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    public static void demo3() throws IOException {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        System.out.print("请输入字符串:");

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String str = bufr.readLine();
        bufr.close();

        char[] chars = str.toCharArray();
        for (char c: chars){
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: set){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

}