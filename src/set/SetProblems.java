package set;

import java.util.Arrays;
import java.util.HashSet;

public class SetProblems {

    static int[] uniqueValues(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
        }

        int res[] = new int[set.size()];
        int index = 0;
        for (int val : set) {
            res[index++] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 1, 2, 5, 5, 6, 7, 7};

        System.out.println(Arrays.toString(uniqueValues(arr)));
    }
}
