package design_pattern.proxy.dynamic_proxy;


import design_pattern.proxy.static_proxy.ISubject;
import design_pattern.proxy.static_proxy.RealSubject;
import design_pattern.proxy.static_proxy.RealSubjectB;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by hust_twj
 * on 2020/2/5
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        RealSubject realSubjectA = new RealSubject();
        InvocationHandler invocationHandler = new DynamicProxySubject(realSubjectA);
        ISubject subject = (ISubject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), invocationHandler);
        subject.buy();

        RealSubjectB realSubjectB = new RealSubjectB();
        InvocationHandler invocationHandlerB = new DynamicProxySubject(realSubjectB);
        ISubject subjectB = (ISubject) Proxy.newProxyInstance(RealSubjectB.class.getClassLoader(),
                RealSubjectB.class.getInterfaces(), invocationHandlerB);
        subjectB.buy();
    }

}
