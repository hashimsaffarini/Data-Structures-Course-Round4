package arraylist;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListMain {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(10, 20)));
        list.add(new ArrayList<>(Arrays.asList(30, 40)));
        list.get(0).add(50);
        System.out.println(list);
    }
}
