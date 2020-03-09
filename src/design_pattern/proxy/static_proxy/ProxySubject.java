package design_pattern.proxy.static_proxy;


/**
 * Description ：静态代理的代理类
 * Created by Wenjing.Tang on 2020-02-06.
 */
public class ProxySubject implements ISubject {

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {

        this.realSubject = realSubject;
    }

    /**
     * 代理类调用了 被代理类的方法，并且可以在方法前后进行其他操作
     */
    @Override
    public void buy() {

        System.out.println("代购买Mac前");

        realSubject.buy();

        System.out.println("代购买Mac后");


    }

}
