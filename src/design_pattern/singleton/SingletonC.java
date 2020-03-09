package design_pattern.singleton;

/**
 * Description ：3、懒加载
 * Created by Wenjing.Tang on 2020/2/28.
 */
public class SingletonC {

    private SingletonC() {

    }

    private static class SingletonCHolder {
        private static SingletonC mInstance = new SingletonC();
    }

    public static SingletonC getInstance() {
        return SingletonCHolder.mInstance;
    }

}
