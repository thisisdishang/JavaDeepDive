import java.io.*;
import java.net.*;

public class ClientSide {
    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream diso;
        DataOutputStream doso;

        s = new Socket("localhost", 5555);
        diso = new DataInputStream(s.getInputStream());
        doso = new DataOutputStream(s.getOutputStream());
        BufferedReader bro = new BufferedReader(new InputStreamReader(System.in));

        int i;
        do {
            i = bro.read();
            doso.write((char) i);
        } while ((char) i != 'q');

        bro.close();
        diso.close();
    }
}
