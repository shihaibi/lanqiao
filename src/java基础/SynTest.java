package java基础;

public class SynTest {
    private static class SynMethod {
        private static final Object staticLockObj = new Object();
        Integer a = 0;
        /**
         * 对象锁,代码级别,同一对象争用该锁,this为SynMethod实例,synchronized的锁绑定在this对象上
         */
        public void method1() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
                }
            }
        }

        /**
         * 对象锁，方法级别,同一对象争用该锁,普通（非静态）方法,synchronized的锁绑定在调用该方法的对象上,与上一个写法含义一致
         */
        public synchronized void method2() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }

        /**
         * 对象锁，代码级别,同一类争用该锁,绑定在staticLockObj上,不同SynMethod实例,拥有同一个staticLockObj对象
         */
        public void method3() {
            synchronized (a) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
                }
            }
        }

        /**
         * 类锁,代码级别，同一类争用该锁
         */
        public void method4() {
            synchronized (SynMethod.class) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
                }
            }
        }

        /**
         * 类锁,方法级别，同一类争用该锁,synchronized的锁绑定在SynMethod.class上
         */
        public static synchronized void staticMethod() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }

    public static void main(String[] args) {
        final SynMethod t1 = new SynMethod();
        final SynMethod t2 = new SynMethod();
        Thread ta = new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method2();
            }
        }, "A");
        Thread tb = new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method3();
            }
        }, "B");
        ta.start();
        tb.start();
    }

}
