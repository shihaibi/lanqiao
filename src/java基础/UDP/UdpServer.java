package java基础.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动");
        DatagramSocket server = new DatagramSocket(9999);
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,
                0, container.length);
        server.receive(packet);
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas, 0, datas.length));
        server.close();
    }
}
