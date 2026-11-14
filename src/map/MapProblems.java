package map;

import java.util.HashMap;

public class MapProblems {
    static void frequencyCharacters(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (mp.get(ch) == null) {
                mp.put(ch, 1);
            } else {
                mp.put(ch, mp.get(ch) + 1);
            }
        }
        System.out.println(mp);
    }

    static void frequencyCharacters2(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        System.out.println(mp);
    }

    static void frequencyArray(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int element : arr) {
            mp.put(element, mp.getOrDefault(element, 0) + 1);
        }
        System.out.println(mp);
    }

    static Character findMaxRepetedCharacter(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int max = 0;
        char maxCharacter = 'a';
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(Character key :mp.keySet()){
            if(mp.get(key) > max){
                max = mp.get(key);
                maxCharacter = key;
            }
        }
        return maxCharacter;
    }

    public static void main(String[] args) {
        String s = "abcddda";
        frequencyArray(new int[]{2, 5, 2, 1, 2, 5, 6, 6, 7});
    }
}
