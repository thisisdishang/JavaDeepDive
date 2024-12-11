package AJT3.Q4;
import java.io.*;
import java.net.*;

public class ClientSide {
    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream diso;
        DataOutputStream doso;

        System.out.println("Start...");

        s = new Socket("localhost", 5555);

        System.out.println("Client is online...");

        diso = new DataInputStream(s.getInputStream());
        doso = new DataOutputStream(s.getOutputStream());
        BufferedReader bro = new BufferedReader(new InputStreamReader(System.in));

        String sendMsg;
        String receivedMsg;

        do {
            System.out.println();

            System.out.print("Send msg : ");
            sendMsg = bro.readLine();
            doso.writeUTF(sendMsg);
            System.out.println("Send successfully: ");

            receivedMsg = diso.readUTF();
            System.out.println("Received msg : " + receivedMsg);

        } while (!sendMsg.equals("stop") || !receivedMsg.equals("stop"));

        bro.close();
        doso.close();
        s.close();
    }
}
