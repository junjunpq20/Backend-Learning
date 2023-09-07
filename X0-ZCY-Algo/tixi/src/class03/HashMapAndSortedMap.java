package class03;

import java.util.HashMap;

public class HashMapAndSortedMap {

    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        Integer i1 = 19;
        Integer i2 = 19;
        System.out.println(i1 == i2);

        Integer i3 = 1900000;
        Integer i4 = 1900000;
        map1.put(i3, "i3");
        System.out.println(map1.containsKey(i4));
    }
}
