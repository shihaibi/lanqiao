package java基础.TCP.聊天室;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.ListResourceBundle;

public class Chat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server------");
        ServerSocket server = new ServerSocket(8888);
        int num = 1;
        while(true) {
            Socket client = server.accept();
            System.out.println("客户端" + num++ +"建立了连接");
            new Thread(() -> {
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                    boolean isRun = true;
                    while (isRun) {
                        String msg = dis.readUTF();
                        dos.writeUTF(msg);
                        dos.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                }


            }).start();
        }


    }
}
