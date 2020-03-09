package design_pattern.singleton;

/**
 * Description ：2、懒汉式：double-check
 * Created by Wenjing.Tang on 2020/2/28.
 */
public class SingletonB {

    private static SingletonB mInstance;

    private SingletonB() {

    }

    public static SingletonB getInstance() {
        if (mInstance == null) {
            synchronized (SingletonB.class) {
                if (mInstance == null) {
                    mInstance = new SingletonB();
                }
            }
        }
        return mInstance;
    }

}
