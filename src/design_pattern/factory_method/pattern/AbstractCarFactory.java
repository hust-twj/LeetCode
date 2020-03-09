package design_pattern.factory_method.pattern;

/**
 * description ：抽象工厂类
 * Created by Wenjing.Tang on 2019/4/18.
 */
public abstract class AbstractCarFactory {

    /**
     * 抽象工厂方法，具体生产什么由子类决定
     * @param cls
     * @param <T>
     * @return
     */
    public abstract <T extends AudiCar> T createCar(Class<T> cls);

}
