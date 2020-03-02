package thread;

/**
 * Description ：
 * 两个线程，交替打印1、2、3...1000
 * 即线程A打印1，线程B打印2，线程A打印3，线程B打印4....
 * Created by Wenjing.Tang on 2020/3/3.
 */
public class ThreadDemo {

    public static final int RANGE = 10; //打印数字的的范围
    public static final int THREAD_COUNT = 2; //执行打印任务的线程数

    //t.join()方法会使所有线程都暂停并等待t的执行完毕
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("A");
        ThreadB threadB = new ThreadB("B");

        threadA.start();
        threadB.start();
    }

}

class ThreadA extends Thread {

    private String name;

    public ThreadA(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        //线程A 打印 1-100 内的齐数
        for (int i = 1; i <= ThreadDemo.RANGE; i++) {
            if (i % ThreadDemo.THREAD_COUNT == 1) {
                System.out.println(name + "  --  " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ThreadB extends Thread {

    private String name;

    public ThreadB(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        //线程B 打印 1-100 内的偶数
        for (int i = 1; i <= ThreadDemo.RANGE; i++) {
            if (i % ThreadDemo.THREAD_COUNT == 0) {
                System.out.println(name + "  --  " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}