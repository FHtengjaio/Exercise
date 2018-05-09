package cn.com.exercise;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class CollectionDemo {
    public static void main(String[] args) {
//        List<String> books = new ArrayList<>();
//        books.add("轻量级Java EE企业应用实战");
//        books.add("疯狂Java 讲义");
//        books.add("疯狂ios 讲义");
//        books.add("疯狂Ajax 讲义");
//        books.add("疯狂Android 讲义");
//        System.out.println("包含有\"疯狂\"的图书有" +calAll(books, s -> s.contains("疯狂"))+"本");
//        System.out.println("书名长度大于10的图书有"+ calAll(books, s -> s.length()>10)+"本");
//        System.out.println("包含有\"Java\"的图书有" +calAll(books, s -> s.contains("Java"))+"本");
        IntStream is = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();
        // 下面调用聚集方法的代码每次只能执行一个
        //System.out.println("is所有元素的最大值：" + is.max().getAsInt());
        //System.out.println("is所有元素的最小值：" + is.min().getAsInt());
        //System.out.println("is所有元素的总和：" + is.sum());
        //System.out.println("is所有元素的总数：" + is.count());
        //System.out.println("is所有元素的平均值：" + is.average());
        //System.out.println("is所有元素的平方是否都大于20:"
        //        + is.allMatch(ele -> ele * ele > 20));
        //System.out.println("is是否包含任何元素的平方大于20:"
        //        + is.anyMatch(ele -> ele * ele > 20));
        // 将is映射成一个新Stream，新Stream的每个元素是原Stream元素的2倍+1
        DoubleStream newIs = is.mapToDouble(Double::valueOf);
        // 使用方法引用的方式来遍历集合元素
        newIs.forEach(System.out::println); // 输出41 27 -3 37

    }

    public static int calAll(Collection<String> books, Predicate<String> p){
        int count = 0;
        for (String book : books) {
            if(p.test(book)) {
                count++;
            }
        }
        return count;
    }

}
