package cn.com.regex;

public class RegexDemo {
    public static void main(String[] args) {
        //splitString("c:\\me\\abc.txt", "\\\\");
        splitString("annnnmnnnnnjskkue,,kj  hyjjjdssdfa..iyre", "(.)\\1+");
    }

    public static void splitString(String str, String regex){
        String[] arr = str.split(regex);
        for (String s: arr){
            System.out.println(s);
        }
    }
}
