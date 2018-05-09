package cn.com.calendar;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        exerciseMethod(c, 2014);
    }

    public static void demoMethod1(Calendar c){
        String[] mons = {"1月","2月","3月","4月",
                "5月","6月","7月","8月",
                "9月","10月","11月","12月"};
        String[] weeks = {"", "周日", "周一", "周二", "周三", "周四", "周五", "周六"};

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DAY_OF_MONTH);
        int inWeek = c.get(Calendar.DAY_OF_WEEK);


        System.out.println("今天是:"+year+"年"+mons[month]+date+"日 "+weeks[inWeek]);
    }

    public static void exerciseMethod(Calendar c, int year){
        c.set(year, Calendar.MARCH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        demoMethod1(c);

    }
}
