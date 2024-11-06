package Java_IO;

import java.io.*;

public class MyDataOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream file=new FileOutputStream("C:\\Users\\disha\\Downloads\\JavaDeepDive\\Java_IO\\f1.txt");
        DataOutputStream data=new DataOutputStream(file);
        data.writeInt(68);
        data.flush();
        data.close();
        System.out.println("Success...");
    }
}
