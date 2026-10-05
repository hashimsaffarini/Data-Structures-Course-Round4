package linkedlist;

public class CircularLinkedListProblems {

    static boolean checkCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    static void printCircularLinkedList(Node head) {
        Node curr = head;
        do {
            System.out.println(curr.val);
            curr = curr.next;
        } while (curr != head);
    }

    static int countNodes(Node n) {
        int c = 1;
        Node temp = n;
        while (temp.next != n) {
            c++;
            temp = temp.next;
        }
        return c;
    }

    static int countNodesInLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return countNodes(slow);
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
