package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TicketPriceApp_Starter {
    static ArrayList<Integer> data(Integer... values) {
        return new ArrayList<>(Arrays.asList(values));
    }

    static void print(String title, Object value) {
        System.out.println(title + ": " + value);
    }

    public static void main(String[] args) {
        // These tests are ready. Implement the methods below and run this file.
        ArrayList<Integer> q1 = data(10, 20, 10, 30, 20, 40, 10);
        removeDuplicates(q1);
        print("Q1", q1);
        print("Q2", secondLargestDistinct(data(12, 35, 10, 35, 28, 40)));
        ArrayList<Integer> q3 = data(0, 10, 0, 20, 30, 0, 40);
        moveZerosToEnd(q3);
        print("Q3", q3);
        //  print("Q4", uniquePairsWithSum(data(2, 7, 4, 5, 3, 8, 1), 9));
        print("Q5", longestIncreasingSegment(data(5, 10, 20, 3, 6, 9, 12, 2)));
        print("Q6", subarrayWithSum(data(1, 4, 20, 3, 10, 5), 33));
        print("Q7", maxSumWindow(data(2, 1, 5, 1, 3, 2), 3));
        ArrayList<Integer> q8 = data(10, 20, 10, 30, 20, 40, 10);
        keepLastOccurrences(q8);
        print("Q8", q8);
        ArrayList<Integer> q9 = data(8, 3, 9, 3, 5);
        swapMinMax(q9);
        print("Q9", q9);
        ArrayList<Integer> q10 = data(8, 6, 3, 9, 5);
        rotateMinToFront(q10);
        print("Q10", q10);
        print("Q11", topNDistinct(data(320, 780, 450, 950, 780, 280, 520), 3));
    }

    // Fill in ONLY the custom methods:
    static void removeDuplicates(ArrayList<Integer> list) {
        throw new UnsupportedOperationException("TODO: implement method");
    }

    static Integer secondLargestDistinct(ArrayList<Integer> list) {
        Integer largest = null, second = null;
        for (int num : list) {
            if (largest == null || num > largest) {
                second = largest;
                largest = num;
            } else if (num < largest && (second == null || num > second)) {
                second = num;
            }
        }
        return second;
    }

    static void moveZerosToEnd(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 0) {
                list.add(list.remove(i));
            }
        }
    }

    static void uniquePairsWithSum(ArrayList<Integer> list, int target) {
        ///  2,7,4,5,3,8,1
        /// 1,1,1,2,3,4,5,7,8
        Collections.sort(list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int a = list.get(left);
            int b = list.get(right);
            if (a + b == target) {
                System.out.println(a + " " + b);
                while (left < right && list.get(left) == a) {
                    left++;
                }
                while (left < right && list.get(right) == b) {
                    right++;
                }
            } else if (a + b < target) {
                left++;
            } else {
                right--;
            }
        }

    }

    static ArrayList<Integer> longestIncreasingSegment(ArrayList<Integer> list) {
        /// 2,10,20,3,6,9,12,2
        ArrayList<Integer> res = new ArrayList<>();
        int currentStart = 0, bestStart = 0, bestLength = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                currentStart = i;
            }
            int currentLength = i - currentStart + 1; /// 3
            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestStart = currentStart;
            }
        }

        for (int i = bestStart; i < bestLength + bestStart; i++) {
            res.add(list.get(i));
        }
        return res;

    }

    static ArrayList<Integer> subarrayWithSum(ArrayList<Integer> list, int target) {
        /// 1,4,20,3,10,5 target = 33
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                if (sum == target) {
                    for (int k = i; k <= j; k++) {
                        res.add(list.get(k));
                    }
                    return res;
                }
            }
        }
        return res;
    }

    static ArrayList<Integer> maxSumWindow(ArrayList<Integer> list, int k) {
        /// 2,1,5,1,3,2 k = 3
        ArrayList<Integer> res = new ArrayList<>();
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += list.get(i);
        }
        int maxSum = windowSum;
        int bestStart = 0;
        for (int i = k; i < list.size(); i++) {
            windowSum += list.get(i);
            windowSum -= list.get(i - k);

            if (windowSum > maxSum) {
                maxSum = windowSum;
                bestStart = i - k + 1;
            }
        }

        for (int i = bestStart; i < bestStart + k; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    static void keepLastOccurrences(ArrayList<Integer> list) {
        throw new UnsupportedOperationException("TODO: implement method");
    }

    static void swapMinMax(ArrayList<Integer> list) {
        throw new UnsupportedOperationException("TODO: implement method");
    }

    static void rotateMinToFront(ArrayList<Integer> list) {
        throw new UnsupportedOperationException("TODO: implement method");
    }

    static ArrayList<Integer> topNDistinct(ArrayList<Integer> list, int n) {
        throw new UnsupportedOperationException("TODO Q11");
    }
}
