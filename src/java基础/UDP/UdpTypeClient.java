package java基础.UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动");
        DatagramSocket client = new DatagramSocket(8888);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("xinsuan");
        dos.writeInt(222);
        dos.flush();

        byte[] datas = baos.toByteArray();
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost",9999));
        client.send(packet);
    }


}
