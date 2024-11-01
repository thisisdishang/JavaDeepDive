package Java_IO;

import java.io.*;

public class MyFileReader {
    public static void main(String[] args) throws IOException{
        File inFile=new File("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\myfile.txt");
        FileReader fr=null;
        try{
            fr=new FileReader(inFile);
            int ch;
            while ((ch=fr.read())!=-1) {
                System.out.print((char)ch);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        finally{
            fr.close();
        }
    }
}
