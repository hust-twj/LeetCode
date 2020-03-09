package design_pattern.factory_method;


import design_pattern.factory_method.pattern.AudiCarFactory;
import design_pattern.factory_method.pattern.Q3CarProduct;
import design_pattern.factory_method.pattern.Q5CarProduct;
import design_pattern.factory_method.pattern.Q7CarProduct;

/**
 * 工厂方法模式
 * Created by hust_twj
 * on 2019/2/26
 */
public class FactoryMethodTest {

    public static void main(String[] args) {

        AudiCarFactory carFactory = new AudiCarFactory();
        Q3CarProduct Q3 = carFactory.createCar(Q3CarProduct.class);
        Q3.desc();

        Q5CarProduct Q5 = carFactory.createCar(Q5CarProduct.class);
        Q5.desc();

        Q7CarProduct Q7 = carFactory.createCar(Q7CarProduct.class);
        Q7.desc();
    }


}
