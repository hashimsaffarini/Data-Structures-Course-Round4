package stack;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T arr[];
    private int size;

    MyStack() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    public void push(T val) {
        if (isFull()) {
            resize(arr.length * 2);
        }
        arr[size++] = val;
    }

    int size() {
        return size;
    }

    T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[size - 1];
    }

    T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[--size];
    }

    boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == arr.length;
    }

    private void resize(int size) {
        T temp[] = (T[]) new Object[size];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += arr[i];
            if (i != size - 1) {
                s += ", ";
            }
        }
        return s + "]";
    }
}
