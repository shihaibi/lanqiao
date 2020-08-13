package java基础.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive implements Runnable{
    private DatagramSocket server;
    public Receive (int port) throws SocketException {
        server = new DatagramSocket(port);
    }

    @Override
    public void run() {
        while (true) {
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,
                    0, container.length);
            try {
                server.receive(packet);
                String data = new String(packet.getData());
                System.out.println(data);
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        server.close();
    }


}
