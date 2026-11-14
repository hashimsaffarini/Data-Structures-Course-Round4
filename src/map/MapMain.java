package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMain {
    public static void main(String[] args) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('a', 20);
        mp.put('a', mp.get('a') + 1);

        System.out.println(mp);

    }
}
