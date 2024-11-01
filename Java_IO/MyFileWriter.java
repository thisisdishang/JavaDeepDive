package Java_IO;

import java.io.*;

public class MyFileWriter {
    public static void main(String[] args) throws IOException {
        File outFile=new File("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\myfile.txt");
        FileWriter fout=null;
        try {
            fout=new FileWriter(outFile);
            String s="Beyond the belief";
            fout.write(s);
            System.out.println("Success...");
        } catch (IOException e) {
            System.out.println(e);
        }finally{
            fout.close();
        }
    }
}
