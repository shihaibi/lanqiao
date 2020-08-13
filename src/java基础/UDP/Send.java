package java基础.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Send implements Runnable{
    private DatagramSocket client;
    private BufferedReader br;
    private String IP;
    private int port;
    public Send(String IP, int port1, int port2) throws SocketException {
         client = new DatagramSocket(port1);
         this.IP = IP;
         br = new BufferedReader(new InputStreamReader(System.in));
         port = port2;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String data = br.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(IP, port));
                client.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
