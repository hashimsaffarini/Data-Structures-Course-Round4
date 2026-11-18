package map;

import java.util.*;

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

        for (Character key : mp.keySet()) {
            if (mp.get(key) > max) {
                max = mp.get(key);
                maxCharacter = key;
            }
        }
        return maxCharacter;
    }

    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            if (mp.containsKey(need)) {
                return new int[]{mp.get(need), i};
            }
            mp.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (String val : arr) {
            char[] ch = val.toCharArray();
            Arrays.sort(ch);//[a, e, t]
            String sortedString = new String(ch); /// "aet"
            if (!mp.containsKey(sortedString)) {
                mp.put(sortedString, new ArrayList<>());
            }
            mp.get(sortedString).add(val);
        }
        return new ArrayList<>(mp.values());
    }

    static Integer[] sortByFreqAndIndex(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (!firstIndex.containsKey(arr[i])) {
                firstIndex.put(arr[i], i);
            }
        }

        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                int fi = freq.get(temp[i]); /// 2
                int fj = freq.get(temp[j]); /// 2
                if (fi < fj || (fi == fj && firstIndex.get(temp[i]) > firstIndex.get(temp[j]))) {
                    int swap = temp[i];
                    temp[i] = temp[j];
                    temp[j] = swap;
                }
            }
        }
        return temp;
    }

    static List<List<Integer>> findMatrix(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            int count = mp.getOrDefault(num, 0);
            if (count == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(count).add(num);
            mp.put(num, count + 1);
        }
        return res;
    }

    static List<Integer> getRepeatedSorted(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int element : arr) {
            mp.put(element, mp.getOrDefault(element, 0) + 1);
        }
        HashSet<Integer> used = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int x : arr) {
            if (mp.get(x) > 1 && !used.contains(x)) {
                used.add(x);
                res.add(x);
            }
        }

        for (int i = 0; i < res.size() - 1; i++) {
            for (int j = 0; j < res.size() - 1; j++) {
                int a = res.get(j);
                int b = res.get(j + 1);
                if (mp.get(a) < mp.get(b)) {
                    int temp = res.get(j);
                    res.set(j, res.get(j + 1));
                    res.set(j + 1, temp);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abcddda";
        frequencyArray(new int[]{2, 5, 2, 1, 2, 5, 6, 6, 7});
    }
}
