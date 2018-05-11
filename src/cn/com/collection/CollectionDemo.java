package cn.com.collection;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        hashmapSort1();
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
//        for(Map.Entry<String,Integer> set: treeSet){
//            System.out.println(set.getKey()+"::"+set.getValue());
//        }
        treeSet.forEach(entry-> System.out.println(entry.getKey()+":::"+entry.getValue()));

    }

}
