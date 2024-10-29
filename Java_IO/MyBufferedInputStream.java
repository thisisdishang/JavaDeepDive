package Java_IO;

import java.io.*;

public class MyBufferedInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fin=new FileInputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\fileBuf.txt");
        BufferedInputStream bin=new BufferedInputStream(fin);
        int ch;
        while ((ch=bin.read())!=-1) {
            System.out.print((char)ch);
        }
    }
}
