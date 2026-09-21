package linkedlist;

public class MyLinkedList {
    Node head, tail;
    private int size;

    MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    int removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        int oldValue = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return oldValue;
    }

    boolean isEmpty() {
        return head == null;
    }

    int getFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        return head.val;
    }

    int getLast() {
        if (tail == null) {
            throw new NullPointerException();
        }
        return tail.val;
    }

    int indexOf(int val) {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.val == val) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    boolean contains(int val) {
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.val == val) return true;
        }
        return false;
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "[";
        Node curr = head;
        while (curr != null) {
            s += curr.val;
            if (curr.next != null) {
                s += ", ";
            }
            curr = curr.next;
        }
        return s + "]";
    }
}
