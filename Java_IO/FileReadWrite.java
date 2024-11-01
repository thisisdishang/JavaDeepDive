package Java_IO;

import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        File inFile=new File("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\myfile.txt");
        File outFile=new File("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\OutFile.txt");

        FileReader fr=null;
        FileWriter fw=null;

        try {
            fr=new FileReader(inFile);
            fw=new FileWriter(outFile);
            int ch;
            while ((ch=fr.read())!=-1) {
                System.out.print((char)ch);
                fw.write(ch); 
            }
            System.out.println("\nWritten Successfully...");
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            fr.close();
            fw.close();
        }
    }
}
