package design_pattern.observer;

/**
 * Description ：抽象被观察者接口(公众号作者)
 * Created by Wenjing.Tang on 2020/3/8.
 */
public interface IWxSubject {

    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObserver();

}
