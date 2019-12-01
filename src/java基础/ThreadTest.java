package java基础;

import java.util.concurrent.*;

/**
 * 推荐使用接口，避免单继承的局限性，方便共享资源
 */
public class ThreadTest{
    static class ExtendThread extends Thread{
        int index;
        static int count= 0;
        ExtendThread(int index){
            this.index = index;
        }
        @Override
        public void run() {
            count += index;
            System.out.println(count + " = " + index + " + "+(int)(count - index) );
        }
    }
    static class ImplementRunnable implements Runnable {
        @Override
        public void run() {

        }
    }
    static class ImplementCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "坏蛋" + Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for(int i = 1; i < 5; i++) {
            ExtendThread et = new ExtendThread(i);
            et.start();
        }

        ImplementRunnable ir = new ImplementRunnable();
        Thread t = new Thread(ir,"001");
        t.start();

        ImplementCallable ic1 = new ImplementCallable();
        ExecutorService ser = Executors.newFixedThreadPool(2);
        Future<String> result1 = ser.submit(ic1);
        Future<String> result2 = ser.submit(ic1);
        System.out.println(result1.get());
        System.out.println(result2.get());
        ser.shutdownNow();
    }




}
