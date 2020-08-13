package java基础.UDP;

import java.net.SocketException;

public class Me {
    public static void main(String[] args) throws SocketException {
        Thread t1 = new Thread(new Send("localhost",8887,8888));
        Thread t2 = new Thread(new Receive(8889));
        t1.start();
        t2.start();
    }
}
