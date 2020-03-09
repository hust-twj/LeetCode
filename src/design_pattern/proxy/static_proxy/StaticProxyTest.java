package design_pattern.proxy.static_proxy;


/**
 * Created by hust_twj
 * on 2020/2/5
 */
public class StaticProxyTest {

    public static void main(String[] args) {

        ISubject subject = new ProxySubject(new RealSubject());
        subject.buy();
    }


}
