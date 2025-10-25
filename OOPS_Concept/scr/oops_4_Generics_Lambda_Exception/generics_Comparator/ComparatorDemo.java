package oops_4_Generics_Lambda_Exception.generics_Comparator;

import java.util.Arrays;

public class ComparatorDemo implements Comparable<ComparatorDemo>{
    int rollno;
    double marks;
    public ComparatorDemo(int rollno,double marks){
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public int compareTo(ComparatorDemo o) { ///  Make the comparison based on the marks
//        return (int)(this.marks - o.marks);
        return (int)(this.rollno - o.rollno);
    }

    @Override
    public String toString(){
        return this.rollno + "-"+ this.marks;
    }

    public static void main(String[] args) {
        ComparatorDemo rahul = new ComparatorDemo(12,43.87);
        ComparatorDemo ajay = new ComparatorDemo(11,42.17);
        ComparatorDemo shiv = new ComparatorDemo(15,50);
        ComparatorDemo govind = new ComparatorDemo(112,48.99);
        ComparatorDemo atharva = new ComparatorDemo(43,49.87);
        ComparatorDemo bishal = new ComparatorDemo(19,49.8);

        ComparatorDemo[] arr = {rahul,ajay,shiv,govind,atharva,bishal};

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
//        If comparable interface is not implemented and compare to method is not completed then this below line will not work.


    }
}
