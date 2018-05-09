package cn.com.io;

import java.io.*;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        fileRead2("E:\\Self Study\\Python.py");
    }

    public static void fileWrite() throws IOException{
        File filename = new File("E:\\Self Study\\python.py");
        filename.createNewFile();
        FileWriter writer = new FileWriter(filename, true);
        String str = "";
        while(!("stop\n".equalsIgnoreCase(str))){
            Scanner scanner = new Scanner(System.in);
            writer.write(str);
            str = scanner.next()+"\n";
        }
        writer.close();
    }

    public static void fileWrite2(String filepath){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<5; i++){
            try {
                bw.write("abcdefghijklmnopqrstuvwsyz"+i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileRead() throws IOException{
        FileReader reader = new FileReader("E:\\Self Study\\java.txt");
        char[] buff = new char[1024];
        int ch = 0;
        while((ch=reader.read(buff))!=-1){
            System.out.println(ch);
            System.out.print(new String(buff, 0, ch));
        }
        reader.close();
    }

    public static void fileRead2(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }


}
