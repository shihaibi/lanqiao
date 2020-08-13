package java基础.TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("你是傻子");
        dos.flush();
        dos.close();
        client.close();
    }
}
