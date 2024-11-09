package Java_IO;

import java.io.*;

public class MyFilterInputStream {
    public static void main(String[] args) throws IOException{
        File file=new File("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\myfile.txt");
        FileInputStream fi=new FileInputStream(file);
        FilterInputStream filter=new BufferedInputStream(fi);
        int k=0;

        while ((k=filter.read())!=-1) {
            System.out.print((char)k);
        }
        filter.close();
        fi.close();
    }
}
