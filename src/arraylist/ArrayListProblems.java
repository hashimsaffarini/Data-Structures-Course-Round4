package arraylist;

import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;

public class ArrayListProblems {
    static void rotateFromLeftToRight(ArrayList<Integer> list) {
        list.add(list.remove(0));
    }

    static void rotateFromRightToLeft(ArrayList<Integer> list) {
        list.add(0, list.remove(list.size() - 1));
    }

    static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : list) {
            if (!res.contains(val)) {
                res.add(val);
            }
        }
        return res;
    }

    static void removeDuplicates2(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j--);
                }
            }
        }
    }

    static void removeDuplicates3(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.indexOf(list.get(i)) != i) {
                list.remove(i--);
            }
        }
    }

    static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList<>();
        for (int val : a) {
            if (b.contains(val) && !c.contains(val)) {
                c.add(val);
            }
        }
        return c;
    }

    static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList<>();
        for (int val : a) {
            if (!c.contains(val)) c.add(val);
        }

        for (int val : b) {
            if (!c.contains(val)) c.add(val);
        }
        return c;
    }

    static void sortEvenThenOdd(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.add(list.remove(i));
            }
        }
    }

    static boolean isPalindrome(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) return false;
        }
        return true;
    }

    static void convertEveryStoCapital(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).toLowerCase();
            if (str.charAt(str.length() - 1) == 's') {
                list.set(i, str.toUpperCase());
            }
        }
    }

    static void removeFromStartToEnd(ArrayList<Integer> list, int start, int end) {
        for (int i = end; i >= start; i--) {
            list.remove(i);
        }
    }

    static ArrayList<Integer> decode(ArrayList<int[]> list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int arr[] : list) {
            for (int i = 0; i < arr[0]; i++) {
                res.add(arr[1]);
            }
        }
        return res;
    }

    static ArrayList<ArrayList<Integer>> divideList(ArrayList<Integer> list, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < list.size() / k; j++) {
                a.add(list.get(c++));
            }
            res.add(a);
        }
        return res;
    }

    static ArrayList<ArrayList<Integer>> generate(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a.add(1);
                } else {
                    a.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(a);
        }
        return res;
    }


}
