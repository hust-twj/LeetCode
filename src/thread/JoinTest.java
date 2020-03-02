package thread;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/3/3.
 *
 * join用法
 * https://blog.csdn.net/u013425438/article/details/80205693
 */
public class JoinTest {

    //t.join()方法会使所有线程都暂停并等待t的执行完毕
    public static void main(String[] args) throws InterruptedException {

        MyThread threadA = new MyThread("A");
        MyThread threadB = new MyThread("B");

        threadA.start();

        //暂停线程B，直到线程A执行完
        //t1.join是在main主线程上调用的，所以只会让main主线程暂时挂起，不会影响到t2线程。
        // 这里只要记住，哪个线程挂起，取决于在哪个线程上调用x.join方法，而不是影响到所有的线程
        //join方法其实就是阻塞当前调用它的线程，等待join执行完毕，当前线程继续执行。
        //结果：先打印完A，再打印B
        threadA.join();

        threadB.start();

        //如果 threadA.join() 放在  threadB.start();后面执行，与不添加的结果是一样的
        //结果：交替打印
       // threadA.join();
    }

}

class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "  --  " + i);
        }
    }
}
