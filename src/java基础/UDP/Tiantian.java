package java基础.UDP;

import java.net.SocketException;

public class Tiantian {
    public static void main(String[] args) throws SocketException {
        Thread t1 = new Thread(new Send("localhost",8886,8889));
        Thread t2 = new Thread(new Receive(8888));
        t1.start();
        t2.start();
    }
}
