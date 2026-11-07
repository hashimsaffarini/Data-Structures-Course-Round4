package stack;

import java.util.Stack;

public class StackProblems {

    static int sum(Stack<Integer> s) {
        int sum = 0;
        Stack<Integer> s2 = new Stack<>();
        while (!s.isEmpty()) {
            int val = s.pop();
            sum += val;
            s2.push(val);
        }

        while (!s2.isEmpty()) {
            s.push(s2.pop());
        }
        return sum;
    }

    static boolean isContains(Stack<Integer> s, int val) {
        while (!s.isEmpty()) {
            if (s.pop() == val) return true;
        }
        return false;
    }

    static void swapBetweenTopAndBottom(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        int x = a.pop();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        int y = b.pop();
        a.push(x);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
        a.push(y);
    }

    static void rotateFromTopToBottom(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        int x = a.pop();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(x);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    static void rotateFromBottomToTop(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        int y = b.pop();
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
        a.push(y);
    }

    static void addBottom(Stack<Integer> a, int val) {
        Stack<Integer> b = new Stack<>();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(val);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    static Stack<Integer> copyStack(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        while (!b.isEmpty()) {
            int val = b.pop();
            a.push(val);
            c.push(val);
        }
        return c;
    }

    static int size(Stack<Integer> a) {
        int c = 0;
        while (!a.isEmpty()) {
            c++;
            a.pop();
        }
        return c;
    }

    static boolean isPalindrome(Stack<Integer> s) {
        Stack<Integer> b = new Stack<>();
        int size = size(copyStack(s));
        for (int i = 0; i < size / 2; i++) {
            b.push(s.pop());
        }
        if (size % 2 != 0) {
            s.pop();
        }
        while (!s.isEmpty()) {
            if (s.pop() != b.pop()) return false;
        }
        return true;
    }

    static boolean checkParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (s.isEmpty()) return false;
                char last = s.pop();
                if (ch == ')' && last != '(' || ch == '}' && last != '{' || ch == ']' && last != '[') {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    static void sortStack(Stack<Integer> s) {
        Stack<Integer> t = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!t.isEmpty() && temp > t.peek()) {
                s.push(t.pop());
            }
            t.push(temp);
        }

        while (!t.isEmpty()) {
            s.push(t.pop());
        }

    }

    static String removeAdj(String str) {
        Stack<Character> s = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (!s.isEmpty() && ch == s.peek()) {
                s.pop();
            } else {
                s.push(ch);
            }
        }
        String res = "";
        while (!s.isEmpty()) {
            res = s.pop() + res;
        }
        return res;
    }

    static String decodeString(String s) {
        Stack<String> strings = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        String current = "";
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numbers.push(num);
                strings.push(current);
                num = 0;
                current = "";
            } else if (ch == ']') {
                int repeat = numbers.pop();
                String prev = strings.pop();

                String temp = "";
                for (int i = 0; i < repeat; i++) {
                    temp += current;
                }
                current = prev + temp;

            } else {
                current += ch;
            }
        }
        return current;
    }

    static boolean divByAll(Stack<Integer> s) {
        int max = s.peek();
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            int val = s.pop();
            if (val > max) max = val;
            temp.push(val);
        }

        while (!temp.isEmpty()) {
            int val = temp.pop();
            if (max % val != 0) return false;
            s.push(val);
        }
        return true;
    }

    /// main method
    static int removeForPalindrome(Stack<Integer> s) {
        int n = s.size();
        if (n == 0) return -1;
        Stack<Integer> temp = new Stack<>();
        int left = 1, right = n;
        while (left < right) {
            int a = valueAt(s, temp, left);
            int b = valueAt(s, temp, right);
            if (a != b) {
                if (checkPalindrome(s, temp, n, left)) {
                    return left;
                }
                if (checkPalindrome(s, temp, n, right)) {
                    return right;
                }
                return -1;
            }
            left++;
            right--;
        }
        return (n + 1) / 2;
    }

    static int valueAt(Stack<Integer> s, Stack<Integer> temp, int pos) {
        for (int i = 1; i < pos; i++) {
            temp.push(s.pop());
        }
        int val = s.peek();
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
        return val;
    }

    static boolean checkPalindrome(Stack<Integer> s, Stack<Integer> temp, int n, int skip) {
        int left = 1;
        int right = n - 1;
        while (left < right) {
            int a = left >= skip ? left + 1 : left;
            int b = right >= skip ? right + 1 : right;
            if (valueAt(s, temp, a) != valueAt(s, temp, b)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
