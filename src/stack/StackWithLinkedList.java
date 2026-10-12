package stack;

import linkedlist.MyLinkedList;

public class StackWithLinkedList {

    MyLinkedList list = new MyLinkedList();

    void push(int val) {
        list.add(val);
    }

    int pop() {
        return list.remove(list.size() - 1);
    }

    int peek() {
        return list.get(list.size() - 1);
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
