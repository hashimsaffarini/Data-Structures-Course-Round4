package queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProblems {

    static void rotateFromLeftToRight(Queue<Integer> q, int n) {
        int size = q.size();
        for (int i = 0; i < n % size; i++) {
            q.offer(q.poll());
        }
    }

    static void rotateFromRightToLeft(Queue<Integer> q, int n) {
        int size = q.size();
        for (int i = 0; i < size - n % size; i++) {
            q.offer(q.poll());
        }
    }

    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.poll());
        }

        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
    }

    static void swapBetweenEveryTwoElements(Queue<Integer> q) {
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            int x = q.poll();
            int y = q.poll();
            q.offer(y);
            q.offer(x);
        }
        if (size % 2 != 0) {
            q.offer(q.poll());
        }
    }

    static void reverseFirstHalf(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            s.push(q.poll());
        }

        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
        for (int i = 0; i < size / 2; i++) {
            q.offer(q.poll());
        }
    }

    static void swapMinMax(Queue<Integer> q) {
        int max = q.peek(), min = q.peek();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int val = q.poll();
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
            q.offer(val);
        }
        for (int i = 0; i < size; i++) {
            int val = q.poll();
            if (val == min) {
                q.offer(max);
            } else if (val == max) {
                q.offer(min);
            } else {
                q.offer(val);
            }
        }
    }

    static void binaryGenerator(int n) {
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            String val = q.poll();
            System.out.print(val + " ");
            q.offer(val + "0");
            q.offer(val + "1");
        }
    }

    static int minValueFrom90(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(9);
        while (true) {
            int val = q.poll();
            if (val % n == 0) return val;
            q.offer(val * 10);
            q.offer(val * 10 + 9);
        }
    }

    static void reRange(Queue<Integer> q) {
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            int current = q.poll();
            for (int j = 0; j < n - 1; j++) {
                int next = q.poll();
                if (current % 2 != 0 && next % 2 == 0) {
                    q.offer(next);
                } else {
                    q.offer(current);
                    current = next;
                }
            }
            q.offer(current);
        }
    }

    static void sort(Queue<Integer> q) {
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            int current = q.poll();
            for (int j = 0; j < n - 1; j++) {
                int next = q.poll();
                if (current > next) {
                    q.offer(next);
                } else {
                    q.offer(current);
                    current = next;
                }
            }
            q.offer(current);
        }
        q = new ArrayDeque<>();
    }


    static void mini(Queue<Integer> a) {
        int sizo = a.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sizo; i++) {
            int x = a.poll();
            if (x < min) {
                if (x != Integer.MAX_VALUE) {
                    a.add(min);
                }
                min = x;
            } else {
                a.add(x);
            }
        }
        a.add(min);
        a.poll();
        System.out.println(a);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(6);
        q.add(2);
        q.add(1);
        q.offer(9);
        mini(q);
    }

}
