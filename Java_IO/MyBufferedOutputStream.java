package Java_IO;

import java.io.*;

public class MyBufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout=new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\fileBuf.txt");
        BufferedOutputStream b1=new BufferedOutputStream(fout);
        String s="New BufferedOutputStream";
        byte b[]=s.getBytes();
        b1.write(b);
        System.out.println("Success...");
        b1.close();
        fout.close();
    }
}
