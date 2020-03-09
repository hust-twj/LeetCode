package design_pattern.observer;

/**
 * Description ：普通用户，订阅公众号
 * Created by Wenjing.Tang on 2020/3/8.
 */
public class User implements IObserver {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void receiveData(String info) {
        System.out.println("我是用户 " + userName + "~~  我收到了公众号主的更新内容：" + info);
    }
}
