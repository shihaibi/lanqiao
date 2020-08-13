package java基础.TCP.聊天室;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----client------");
        Socket client = new Socket("localhost",8888);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRun = true;
        while (isRun) {
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();

            String reMsg = dis.readUTF();
            System.out.println(reMsg);
        }


        dos.close();
        dis.close();
        client.close();
    }
}
