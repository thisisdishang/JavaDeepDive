package Java_IO;

import java.io.*;

public class MyDataInputStream {
    public static void main(String[] args) throws IOException{
        FileInputStream input=new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\myfile.txt");
        DataInputStream dis=new DataInputStream(input);
        int count=input.available();
        byte[] ary=new byte[count];
        dis.read(ary);
        for(byte bt:ary){
            char k=(char)bt;
            System.out.print(k+"-");
        }
    }
}
