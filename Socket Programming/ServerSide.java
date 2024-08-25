import java.io.*;
import java.net.*;

public class ServerSide {
    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream diso;
        DataOutputStream doso;

        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Server started");

        System.out.println("Waiting for a client...");
        s = ss.accept();

        System.out.println("Client accepted");
        diso = new DataInputStream(s.getInputStream());
        doso = new DataOutputStream(s.getOutputStream());

        int i;
        do {
            i = diso.read();
            System.out.println((char) i + " " + i);
        } while ((char) i != 'q');

        System.out.println("Closing connection");
        ss.close();
    }
}
