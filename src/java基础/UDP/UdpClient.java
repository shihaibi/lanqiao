package java基础.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动");
        DatagramSocket client = new DatagramSocket(8888);
        byte[] datas = "nihao".getBytes();
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost",9999));
        client.send(packet);
    }
}
