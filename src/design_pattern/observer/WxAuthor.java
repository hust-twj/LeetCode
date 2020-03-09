package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Description ：公众号作者
 * Created by Wenjing.Tang on 2020/3/8.
 */
public class WxAuthor implements IWxSubject {

    private List<IObserver> list = new ArrayList<>();

    private String updateContent;

    @Override
    public void addObserver(IObserver observer) {
        list.add(observer);

    }

    @Override
    public void removeObserver(IObserver observer) {
        if (list.contains(observer)) {
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (IObserver observer : list) {
            observer.receiveData(updateContent);
        }
    }

    /**
     * 博主发布了一篇博文，通知关注了的用户
     * @param updateContent
     */
    public void publish(String updateContent) {
        this.updateContent = updateContent;

        System.out.println("博主 发布了 博文 ~");

        notifyObserver();
    }

    /**
     * 用户是否关注了
     * @param observer
     * @return
     */
    public boolean isFollowed(IObserver observer) {
        return list.contains(observer);
    }

}
