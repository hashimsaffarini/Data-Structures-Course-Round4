package queue;

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
}
