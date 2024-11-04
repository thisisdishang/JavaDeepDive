package Java_IO;

import java.io.*;

public class MyByteArrayInputStream {
    public static void main(String[] args) throws IOException {
        byte[] b={65,66,67,68,97,98,99,100};
        ByteArrayInputStream bi=new ByteArrayInputStream(b);

        int i;

        while ((i=bi.read())!=-1) {
            char ch=(char)i;
            System.out.println("Character: "+ch+" Value: "+i);
        }

        bi.close();
    }
}
