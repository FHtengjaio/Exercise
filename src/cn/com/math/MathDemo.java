package cn.com.math;

public class MathDemo {
    public static void main(String[] args) {
        double d = 9.09809088;
        d = saveNeed(d, 2, true);
        System.out.println(d);
    }

    public static double saveNeed(double d, int need, boolean isRound){
        double base = Math.pow(10, need);

        d = isRound? (Math.round(d * base)) / base : ((int)(d * base)) / base;

        return d;
    }
}
