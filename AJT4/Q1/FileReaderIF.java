import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileReaderIF extends Remote {
    String readFile(String filePath) throws RemoteException;
}
