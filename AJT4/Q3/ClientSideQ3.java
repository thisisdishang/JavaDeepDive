import java.rmi.registry.*;

public class ClientSideQ3 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("localhost",2000);
        System.out.println("Client is running...");

        SystemInfo systeminfoIF = (SystemInfo) rg.lookup("systeminfo");
        System.out.println(systeminfoIF.getDiskInfo());
        System.out.println(systeminfoIF.getMemoryInfo());
        System.out.println(systeminfoIF.getOSVersion());
    }
}
