package linkedlist;

import java.util.ArrayList;

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

    static Node removeDuplicates(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            if (!list.contains(curr.val)) {
                list.add(curr.val);
            }
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        for (int val : list) {
            tail.next = new Node(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    static Node removeDuplicatesWithoutDS(Node head) {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i; j.next != null; ) {
                if (i.val == j.next.val) {
                    j.next = j.next.next;
                } else {
                    j = j.next;
                }
            }
        }
        return head;
    }

    static Node removeDuplicatesOneIteration(Node head) {
        for (Node curr = head; curr.next != null; ) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isSame(Node a, Node b) {
        Node headA = a, headB = b;
        while (headA != null && headB != null) {
            if (headA.val != headB.val) return false;
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null && headB == null;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = middle(head);
        Node secondHalf = reverse(mid);
        Node firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    static Node insertSort(Node head, int val) {
        Node newNode = new Node(val);
        Node curr = head;
        if (head == null || head.val >= val) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        while (curr.next != null) {
            if (curr.next.val > newNode.val) {
                break;
            }
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    static Node swapPairs(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = head.next;
        Node prev = null, curr = head;
        while (curr != null && curr.next != null) {
            Node next = curr.next;
            curr.next = next.next;
            next.next = curr;
            if (prev != null) {
                prev.next = next;
            }
            prev = curr;
            curr = curr.next;
        }
        return newHead;
    }

    static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        for (Node curr1 = head1; curr1 != null; curr1 = curr1.next) {
            for (Node curr2 = head2; curr2 != null; curr2 = curr2.next) {
                if (curr1.val == curr2.val && !exists(dummy.next, curr1.val)) {
                    tail.next = new Node(curr1.val);
                    tail = tail.next;
                    break;
                }
            }
        }
        return dummy.next;
    }

    static boolean exists(Node head, int val) {
        for (Node curr1 = head; curr1 != null; curr1 = curr1.next) {
            if (curr1.val == val) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1, 1, 1, 2, 2, 2, 3, 3, 4);
        System.out.println(list);

    }
}
