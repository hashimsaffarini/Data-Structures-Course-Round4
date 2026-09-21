package linkedlist;

import java.util.LinkedList;

public class LinkedListMain {
    static int sum(Node head) {
        int sum = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            sum += curr.val;
        }
        return sum;
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(50);
        System.out.println(sum(list.head));

        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.size());

    }
}
