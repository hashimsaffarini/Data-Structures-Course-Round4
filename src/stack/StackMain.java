package stack;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);

        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s);
        System.out.println(s.size());

    }
}
