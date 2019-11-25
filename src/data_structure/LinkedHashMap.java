package data_structure;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Description ：
 * Created by Wenjing.Tang on 2019-11-25.
 */
public class LinkedHashMap {

    public static void main(String[] args) {

        //访问顺序 accessOrder
        HashMap<String, String> map = new java.util.LinkedHashMap<>(16, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        map.get("1");
        map.get("2");

        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

    }

}
