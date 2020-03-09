package design_pattern.proxy.static_proxy;


/**
 * Description ：目标对象实现类
 * Created by Wenjing.Tang on 2020-02-06.
 */
public class RealSubject implements ISubject{

    @Override
    public void buy() {
        System.out.println("我是 A，我要买一台 MacBook pro，请帮忙");

    }

}
