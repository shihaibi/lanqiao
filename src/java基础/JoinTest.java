package java基础;

/**
 * join成员方法只能等该Thread对象的线程死亡，被阻塞的线程才能继续执行。
 */
public class JoinTest extends Thread {
    @Override
    public void run() {
        System.out.println(124);
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest jt = new JoinTest();
        jt.start();
        jt.join();
        System.out.println(123);
    }
}
