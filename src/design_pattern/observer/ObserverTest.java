package design_pattern.observer;

/**
 * Description ：观察者模式
 *
 * https://blog.csdn.net/qq_35270692/article/details/78681671
 *
 * Created by Wenjing.Tang on 2020/3/8.
 */
public class ObserverTest {

    public static void main(String[] args) {
        WxAuthor wxAuthor = new WxAuthor();
        User userA = new User("小A");
        User userB = new User("小B");
        User userC = new User("小C");
        wxAuthor.addObserver(userA);
        wxAuthor.addObserver(userB);

        wxAuthor.publish("我的第一篇公众号发布啦~~，请各位大大查阅==");

        boolean isFollowed = wxAuthor.isFollowed(userC);
        if (!isFollowed) {
            System.out.println("你好！你还没有关注 TigerChain ，请关注先，谢谢");
        }
    }
}
