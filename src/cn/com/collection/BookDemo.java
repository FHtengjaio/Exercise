package cn.com.collection;

import java.util.ArrayList;

public class BookDemo {
    public static void main(String[] args) {
        ArrayList<Book> al = new ArrayList<>();
        al.add(new Book("操作系统",34.89));
        al.add(new Book("JAVA基础教程",29.90));
        al.add(new Book("C++基础教程", 29.90));
        al.add(new Book("数据库技术", 29.90));
        final Book newBook = new Book("模式识别", 29.90);
        System.out.println("与新书:“"+newBook.getName()+"”价格相同的书有以下几本:");
        al.forEach(book -> {
            if(newBook.compareTo(book)==0){
                System.out.println(book.toString());
            }
        });
    }

}

class Book implements Comparable<Book>{
    private String name;
    private double price;

    public Book(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Book o) {
        return Double.compare(this.price, o.price);
    }

    @Override
    public String toString() {
        return this.name+":"+this.price;
    }
}
