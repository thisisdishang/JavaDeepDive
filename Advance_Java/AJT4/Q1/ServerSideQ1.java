package AJT4.Q1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerSideQ1 {
    public static void main(String[] args) {
        try{
            FileReaderImplemetation fri = new FileReaderImplemetation();
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("FileReaderImp",fri);
            System.out.println("Server is ready...");

        } catch (Exception ex){
            System.err.println("Error in Server - "+ ex.getMessage());
            ex.printStackTrace();
        }
    }
}
