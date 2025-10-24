package oops_1_Concept.accessModifier;

public class Main {

    static void main(String[] args) {
        A obj = new A(10,"Bishal");
//        obj.num; // Cannot be accessed directly as num is private. but it can be used or manipulated by using getter and setter method.
        obj.setNum(25); // updating tha value of num from 10 -> 25
        int num = obj.getNum();
        System.out.println(num+" " +obj.name);
        obj.arr[0] = 43; // Is Accessible even though it is protected.
    }
}
