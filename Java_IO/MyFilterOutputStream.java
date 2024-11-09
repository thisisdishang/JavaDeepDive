package Java_IO;

import java.io.*;

public class MyFilterOutputStream{
    public static void main(String[] args) throws IOException{
        File file=new File("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\myfile.txt");
        FileOutputStream fo=new FileOutputStream(file);
        FilterOutputStream filter=new FilterOutputStream(fo);
        String s="Never Settle";
        byte[] b=s.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        fo.close();
        System.out.println("Success...");
    }
}
