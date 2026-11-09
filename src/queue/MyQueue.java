package queue;

public class MyQueue<T> {
    private T[] arr;
    private int front, rear, size;

    public MyQueue() {
        arr = (T[]) new Object[5];
        size = front = 0;
        rear = -1;
    }

    void offer(T item) {
        if (size == arr.length) {
            //resize();
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = item;
        size++;
    }

    T peek() {
        if (size == 0) {
            return null;
        }
        return arr[front];
    }

    T poll() {
        if (size == 0) {
            return null;
        }
        T item = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return item;
    }

    void resize() {
        T[] newArray = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[(front + i) % arr.length];
        }
        arr = newArray;
        front = 0;
        rear = size - 1;
    }
}
