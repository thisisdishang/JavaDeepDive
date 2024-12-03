import java.io.*;
import java.net.*;

public class ServerSide {
    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream diso;
        DataOutputStream doso;

        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Server started...");

        System.out.println("Waiting for a client...");
        s = ss.accept();

        System.out.println("Client accepted");
        diso = new DataInputStream(s.getInputStream());
        doso = new DataOutputStream(s.getOutputStream());
        BufferedReader bro = new BufferedReader(new InputStreamReader(System.in));

        String receivedMsg;
        String sendMsg;
        do {
            System.out.println();
            receivedMsg = diso.readUTF();
            System.out.println("Received msg : " + receivedMsg);

            System.out.print("Send msg : ");
            sendMsg = bro.readLine();
            doso.writeUTF(sendMsg);
            System.out.println("Send msg Successfully : ");
        } while (!sendMsg.equals("stop") || !receivedMsg.equals("stop"));

        System.out.println("Closing connection");
        diso.close();
        s.close();
        ss.close();
    }
}
