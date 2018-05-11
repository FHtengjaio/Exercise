package cn.com.collection;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        hashmapSort2();
    }

    private static void hashmapSort2() {
        TreeMap<Person,Integer> treeMap = new TreeMap<>((p1,p2)->{
            int num = Integer.compare(p1.getAge(),p2.getAge());
            if(num==0){
                return p1.getName().compareTo(p2.getName());
            }
            return num;
        });
        treeMap.put(new Person("zhang", 10), 789);
        treeMap.put(new Person("wang", 6), 876);
        treeMap.put(new Person("xie", 1), 765);
        treeMap.put(new Person("jiao", 8), 452);
        treeMap.put(new Person("koil", 5), 563);
        treeMap.put(new Person("koil", 8), 563);
        treeMap.forEach((key,value)-> System.out.println(key+"::"+value));
    }

    private static void linkedHashMapDemo() {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("j",10);
        lhm.put("a",9);
        lhm.put("x",8);
        lhm.put("m",2);
        lhm.forEach((key,value)-> System.out.println(key+"--->"+value));
    }

    /* *
     * HashMap进行排序1
     * */
    private static void hashmapSort1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("f",9);
        map.put("a",5);
        map.put("c",2);
        map.put("j",4);
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        treeMap.forEach((key,value)-> System.out.println(key+"--->"+value));
    }

    private static void hashmapSort() {
        Map<String, Integer> map = new HashMap<>();
        map.put("f",9);
        map.put("a",5);
        map.put("c",2);
        map.put("j",4);

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

        TreeSet<Map.Entry<String,Integer>> treeSet = new TreeSet<>(Collections.reverseOrder(Map.Entry.comparingByValue()));
        treeSet.addAll(entrySet);

        treeSet.forEach(entry-> System.out.println(entry.getKey()+":::"+entry.getValue()));

    }



}
