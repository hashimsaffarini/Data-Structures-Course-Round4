package linkedlist;

public class LinkedListProblems {
    static int maxNumber(Node head) {
        if (head == null) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.val > max) {
                max = curr.val;
            }
        }
        return max;
    }

    static Node middle(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static boolean isSortedLinkedList(Node head) {
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (curr.val > curr.next.val) return false;
        }
        return true;
    }

    static boolean isSortedAnyWay(Node head) {
        boolean f1 = true, f2 = true;
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (!f1 && !f2) return false;
            if (curr.val > curr.next.val) {
                f1 = false;
            } else if (curr.val < curr.next.val) {
                f2 = false;
            }
        }
        return f1 || f2;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(77, 10, 20, 30, 40, 50);
        System.out.println(list);
        System.out.println(maxNumber(list.head));
    }
}
