package design_pattern.singleton;

/**
 * Description ：1、饿汉式
 * Created by Wenjing.Tang on 2020/2/28.
 */
public class SingletonA {

    private static SingletonA mInstance = new SingletonA();

    private SingletonA() {}

    public static SingletonA getInstance() {
        return mInstance;
    }

}
