package cn.com.exercise;

interface Inter{
    void method();
}

class Test{
    static Inter function(){
//        return new Inter(){
//            public void method(){
//                System.out.println("method show");
//            }
//        };
        return ()->System.out.println("method show");
    }
}


class Show{
    public static void main(String[] args) {
        Test.function().method();
    }

}