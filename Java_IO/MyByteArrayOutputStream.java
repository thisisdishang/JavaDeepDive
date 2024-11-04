package Java_IO;

import java.io.*;

public class MyByteArrayOutputStream {
    public static void main(String[] args) throws IOException{
        FileOutputStream f1=new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\f1.txt");
        FileOutputStream f2=new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\f2.txt");

        ByteArrayOutputStream b1=new ByteArrayOutputStream();
        
        b1.write(65);
        b1.writeTo(f1);
        b1.writeTo(f2);
        System.out.println("Success...");
        b1.flush();
        b1.close();
    }
}