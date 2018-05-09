package cn.com.exercise;

public class SomeQusetions {

    public static void main(String[] args) {
        //getNumOfRabbits();
        //getShushu();
    }
/*
    public static void getNumOfRabbits() {
        System.out.print("请输入你想查询的月份:");
        int num;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
                scanner.close();
                break;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数!!!!");
                System.out.print("请输入你想查询的月份:");
            }
        }
        long rabbitsNum = returnNum(num);
        System.out.println("第"+num+"月有"+rabbitsNum+"对兔子");
    }

    private static long returnNum(int num){
        long rabbitsNum;
        switch(num){
            case 1:
            case 2:
                rabbitsNum = 1;
                break;
            default:
                rabbitsNum = returnNum(num-1) + returnNum(num-2);
        }
        return rabbitsNum;
    }

    public static void getShushu(){
        int squart;
        HashSet<Integer> hs = new HashSet<>();
        for (int i=101; i<=200; i++){
            hs.clear();
            squart = (int) Math.sqrt(i);
            for (int j=2; j<=squart; j++){
                if(i%j==0)
                    hs.add(i);
            }
            if(hs.isEmpty())
                System.out.print(i+" ");
        }
    }
*/











}
