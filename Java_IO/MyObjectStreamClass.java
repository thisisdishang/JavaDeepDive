package Java_IO;

import java.io.*;
import java.util.ArrayList;

public class MyObjectStreamClass {
    public static void main(String[] args) {
        // creating object stream class for Number
        ObjectStreamClass geeks_stream = ObjectStreamClass.lookup(Number.class);
        ObjectStreamClass quiz_stream = ObjectStreamClass.lookupAny(ArrayList.class);
         
        // checking class instance 
        System.out.println(geeks_stream.forClass());
        System.out.println(quiz_stream.forClass());

        // checking field
        System.out.println(geeks_stream.getFields());

        // class name 
        System.out.println("class name: " + geeks_stream.getClass());
         
        // checking serial version UID
        System.out.println(geeks_stream.getSerialVersionUID());
         
        System.out.println(geeks_stream.toString());
    }
}
