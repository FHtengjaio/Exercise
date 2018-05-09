package cn.com.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("y-MM-d E H:m:s");
        System.out.println(sdf.format(date));

        long l = System.currentTimeMillis();
        System.out.println(l);
        Date date1 = new Date(1524893875300L);
        System.out.println(sdf.format(date1));
    }
}
