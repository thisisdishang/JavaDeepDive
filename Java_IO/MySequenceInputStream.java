package Java_IO;

import java.io.*;

public class MySequenceInputStream {
    public static void main(String[] args) throws IOException{
        FileInputStream f1=new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\file.txt");
        FileInputStream f2=new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\fileBuf.txt");
        SequenceInputStream inst= new SequenceInputStream(f1, f2);

        int k;
        while ((k=inst.read())!=-1) {
            System.out.print((char)k);
        }

        inst.close();
        f2.close();
        f1.close();
    } 
}
