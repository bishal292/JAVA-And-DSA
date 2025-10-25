package oops_4_Generics_Lambda_Exception.generics_Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        CustomArrayList<Number> list = new CustomArrayList<>(20);
        list.add(12);
//        list.add(1.32); /// This will works as double is subclass of Number.
        list.add(14);
        list.add(13);
        list.add(12);
        list.add(165);
        for (int i = 1; i < 20; i++) {
            list.add(i * 2);
        }
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.remove(1));
//        System.out.println(list);
//        System.out.println(list.size());

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add((int)(list.get(i)));
        }
        System.out.println(list1);

//        Lambda Expression
        list1.forEach((a)-> System.out.print(a + " "));
    }
}
