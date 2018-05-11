package cn.com.collection;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "@"+name+":"+age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 89;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj instanceof Person){
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }

    @Override
    public int compareTo(Person o) {
        int num = this.name.compareTo(o.name);
        if(num==0){
            return Integer.compare(this.age, o.age);
        }
        return num;
    }

}
