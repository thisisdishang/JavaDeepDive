package Java_IO;

import java.io.*;

public class MyFileInputStream {
    public static void main(String[] args) {
        FileInputStream infile=null;
        try {
            infile=new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\file.txt");
            int b;
            while ((b=infile.read())!=-1) {
                System.out.print((char)b);
            }
            infile.close();
            
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
