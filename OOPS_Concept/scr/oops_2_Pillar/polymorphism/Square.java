package oops_2_Pillar.polymorphism;

public class Square extends Shapes{
    int num = 12;
    void area(){
        System.out.println("Area of Square is side^2.");
    }

    static void greet(){
        System.out.println("Hello i am from Square class.");
    }
}
