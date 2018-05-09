package cn.com.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bubbling {
    public static void main(String[] args) {
        int[] sourceArr = {1, 2, 3, 4, 5, 6};
        int[] desArr = new int[8];
        System.arraycopy(sourceArr, 2, desArr, 3, 4);
        System.out.println(Arrays.toString(desArr));
    }

    public static String saveOnly(String str){
        String regex = "(.)\\1+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        String target;
        while(m.find()){
            target = m.group();
            str = str.replace(target, String.valueOf(target.charAt(0)));
        }
        return str;
    }

    public static String deleteMore(String str){
        char[] charArr = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c: charArr){
            if(!list.contains(c)){
                list.add(c);
            }
        }
        String resultStr = list.toString();
        String regex = "[, ]";
        resultStr = resultStr.replaceAll(regex,"");
        resultStr = resultStr.substring(1, resultStr.length()-2);
        return resultStr;
    }

    public static void resverString(String str){
        char[] charArr = str.toCharArray();
        for(int i = charArr.length-1; i>=0; i--){
            System.out.print(charArr[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void bubblingSort(int[] arr){
        int temp;
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectSort(int[] arr){
        int temp;
        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int biarnySearch(int[] arr, int target){
        int min = 0;
        int max = arr.length - 1;
        int mid = (min + max) / 2;
        int index = -1;
        while(min<=max){
            if(arr[mid]>target){
                max = mid - 1;
            }
            else if(arr[mid]<target){
                min = mid + 1;
            }
            else{
                index = mid;
                break;
            }
            mid = (min + max) / 2;
        }
        return index;
    }
}
