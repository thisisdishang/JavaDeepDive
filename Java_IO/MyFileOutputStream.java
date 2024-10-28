package Java_IO;

import java.io.*;

public class MyFileOutputStream {
    public static void main(String[] args) {
        FileOutputStream ofile=null;
        
        try{
            ofile=new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\file.txt");
            ofile.write("This is a FileOutputStream".getBytes());
            System.out.println("Write Successfully");
            ofile.close();
        }
        catch (Exception e) {
            // TODO: handle exception
        }

    }
}
