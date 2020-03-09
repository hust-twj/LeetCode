package design_pattern.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Description ：5、CAS
 * 参考： https://mp.weixin.qq.com/s/ZmjKVu4hmWuEB-cofCbJSQ
 * Created by Wenjing.Tang on 2020/2/28.
 *
 * 用CAS的好处在于不需要使用传统的锁机制来保证线程安全,CAS是一种基于忙等待的算法,依赖底层硬件的实现
 * 相对于锁它没有线程切换和阻塞的额外消耗,可以支持较大的并行度。
 *
 * CAS的一个重要缺点在于如果忙等待一直执行不成功(一直在死循环中),会对CPU造成较大的执行开销。
 */
public class SingletonE {

    private static final AtomicReference<SingletonE> INSTANCE = new AtomicReference<SingletonE>();

    private SingletonE() {

    }

    public static SingletonE getInstance() {
        for (; ; ) {
            SingletonE singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new SingletonE();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }

}
