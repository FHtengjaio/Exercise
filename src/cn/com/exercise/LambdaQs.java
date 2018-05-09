package cn.com.exercise;

interface Eatable{
    void taste();
}

interface Flyable{
    void fly(String weather);
}

interface Addable{
    int add(int a, int b);
}

public class LambdaQs {

    private void eat(Eatable eat){
        System.out.println(eat);
        eat.taste();
    }

    private void drive(Flyable drive){
        System.out.println("我正在驾驶:"+drive);
        drive.fly("天气不错");
    }

    private void add(Addable add){
        System.out.println("4和5的和是："+add.add(4,5));
    }

    public static void main(String[] args) {
        LambdaQs la = new LambdaQs();
        la.add((a, b)-> a + b);
        la.drive(System.out::println
//            System.out.println("直升机驾驶平稳");
        );
        la.eat(()-> System.out.println("橘子味道不错"));
    }
}
