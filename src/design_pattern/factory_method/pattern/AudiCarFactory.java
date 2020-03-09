package design_pattern.factory_method.pattern;

/**
 * description ：具体工厂类
 * Created by Wenjing.Tang on 2019/4/18.
 */
public class AudiCarFactory extends AbstractCarFactory {

    /**
     * 返回具体产品
     * @param cls
     * @param <T>
     * @return
     */
    @Override
    public <T extends AudiCar> T createCar(Class<T> cls) {
        AudiCar audiCar = null;
        try {
            audiCar = (AudiCar)Class.forName(cls.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)audiCar;
    }

}
