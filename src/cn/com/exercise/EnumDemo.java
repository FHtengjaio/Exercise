package cn.com.exercise;

public enum EnumDemo {

    SPRING("春天"), SUMMER("夏天"), FALL("秋天"), WINTER("冬天");

    private String name;

    EnumDemo(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }



}

class EnumDemoTest{
    public void judge(EnumDemo e){
        switch (e){
            case SPRING:
                System.out.println("春天花会开");
                break;
            case SUMMER:
                System.out.println("夏天蝉会鸣");
                break;
            case FALL:
                System.out.println("秋天稻会熟");
                break;
            case WINTER:
                System.out.println("冬天雪会下");
                break;
        }
    }

    public static void main(String[] args) {
        for(EnumDemo e: EnumDemo.values()){
            System.out.println(e);
        }
        new EnumDemoTest().judge(EnumDemo.SPRING);
        System.out.println(Enum.valueOf(EnumDemo.class, "SPRING"));
    }
}