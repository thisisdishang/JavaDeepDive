package AJT4.Q1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientSideQ1 {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",5050);
            FileReaderIF frIf = (FileReaderIF) registry.lookup("FileReaderImp");
            String filePath = "C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT4\\Q1\\hello.txt";
            String content = frIf.readFile(filePath);
            System.out.println("content : \n"+content);

        }catch(Exception ex){
            System.err.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
