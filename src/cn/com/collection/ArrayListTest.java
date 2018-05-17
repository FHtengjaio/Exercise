package cn.com.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {
    public static void main(String[] args) {
        test1();
    }


    private static void test1(){
        List<String> al = new ArrayList<>();
        al.add("nihao");
        al.add("wohao");
        al.add("dajiahao");
        al.add("nihao");
        al.add(1,"tahao");
        ListIterator<String> li = al.listIterator();
        while(li.hasNext()){
            String s = li.next();
            if ("nihao".equals(s)){
                li.set("nibuhao");
            }
        }
        al.forEach(System.out::println);
    }
}
