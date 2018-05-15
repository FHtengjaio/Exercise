package cn.com.regex;

import java.util.Arrays;

public class RegexDemo {
    public static void main(String[] args) {
        //splitString("c:\\me\\abc.txt", "\\\\");
        //replaceString("annnnmnnnnnjskkue,,kj  hyjjjdssdfa..iyre", "(.)\\1+", "$1");
        sortIP();
    }
    public static void splitString(String str, String regex){
        String[] arr = str.split(regex);
        for (String s: arr){
            System.out.println(s);
        }
    }

    public static void replaceString(String str, String regex, String newStr){
        str = str.replaceAll(regex, newStr);
        System.out.println(str);
    }

    /*
     * 将我...我我..我..我要要.....要要..要..要要...要学..学学...学学.学编.编..编...编....编.....编程...程.程程..程程..转化成我要学编程
     * */
    public static void test1(){
        String str = "我...我我..我..我要要.....要要..要..要要...要学..学学...学学." +
                "学编.编..编...编....编.....编程...程.程程..程程..";
        str = str.replaceAll("(\\.)+", "");
        str = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str);

    }

    /*
    * 192.168.1.254 102.49.23.13 10.10.10.10 2.2.2.2 8.109.90.30
    * */
    public static void sortIP(){
        String ipstr = "192.168.1.254 102.49.23.13 10.10.10.10 2.2.2.2 8.109.90.30";
        System.out.println(ipstr);

        ipstr = ipstr.replaceAll("(\\d+)", "00$1");

        ipstr = ipstr.replaceAll("0*(\\d{3})","$1");

        String[] ips = ipstr.split(" ");

        Arrays.sort(ips);

        ipstr = Arrays.toString(ips);

        ipstr = ipstr.replaceAll("[\\[\\],]", "");

        ipstr = ipstr.replaceAll("0*(\\d+)", "$1");
        System.out.println(ipstr);


    }
}
