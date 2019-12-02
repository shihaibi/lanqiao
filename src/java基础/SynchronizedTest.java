package java基础;

public class SynchronizedTest {
    private static class Account {
        int money;
        int name;
        public Account(int money, int name) {
            this.money = money;
            this.name = name;
        }
    }
    private static class Yinhang extends Thread{
        Account curAccount;
        int money;
        final static Integer count = 3;
        Yinhang (Account a, int b) {
            this.curAccount = a;
            this.money =b;
        }
        @Override
        public void run() {
            this.test();
        }

        public void test() {
            synchronized (Yinhang.count) {
                try {
                    System.out.println("他开始了");
                    this.money = 50000;
                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void setMoney(int money) {
            this.money = money;
        }

        public void getCount() {
            System.out.println(Yinhang.count);
        }
    }

    public static void main(String[] args) {
        Account a = new Account(1000,1);
        Account b = new Account(2000,2);
        Yinhang xiaoyinhang = new Yinhang(a, 20);

        xiaoyinhang.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //xiaoyinhang.setMoney(3000);
        xiaoyinhang.money = (3000);
        synchronized (Yinhang.count) {
            xiaoyinhang.getCount();
        }

        System.out.println("chenggong");


    }

}
