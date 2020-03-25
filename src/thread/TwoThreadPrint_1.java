package thread;

/**
 * Description ：两个线程交替打印--1
 * https://segmentfault.com/a/1190000019658399?utm_source=tag-newest
 * wait-notify
 * Created by Wenjing.Tang on 2020/3/3.
 */
public class TwoThreadPrint_1 {

    private volatile static int RANGE = 10;
    private static int i = 1;

    final static Object obj = new Object();

    public static void main(String[] args) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    while (i <= RANGE) {
                        System.out.println(Thread.currentThread().getName() + "  " + i);
                        i++;
                        try {
                            //操作notifyAll() 和 wait()必须是同一个锁
                            //A线程执行完后，等待；然后B执行，B唤醒A，然后等待；然后A执行，A唤醒B，然后等待...
                            obj.notify();
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //最终让线程notify结束，否则会一直wait下去
                    obj.notify();
                }
            }
        };

        Thread threadA = new Thread(runnable); //打印奇数
        Thread threadB = new Thread(runnable); //打印偶数
        threadA.start();
        threadB.start();
    }


    static class Runnable1 implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                synchronized (obj) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "  " + i);
                        // wait();
                        i++;
                        obj.notify();
                    }else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Runnable2 implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                synchronized (obj) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "  " + i);
                        i++;
                        obj.notify();

                    }else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
