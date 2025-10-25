package oops_3_abstract_Interface.abstractDemo;


public class Son extends Father{
//  As there is a constructor in Father hence it must have one 'super' call matching same
    Son(int age) {
        super(age);
    }

    @Override
    void carrer() {
        System.out.println("I want to become a Engineer.");
    }

    @Override
    void partner() {
        System.out.println("I love Nushrat Bharuchha");
    }

    static void main(String[] args) {
//        Son son = new Father(12); // cannot be instantiated as Father is an abstract class hence its constructor cannot be called directly.
        Father son1 = new Son(21);
        son1.carrer(); // Something we have already completed in inheritance.


        Son son = new Son(23);
//        son.age; // Cannot access directly as age is private.
        son.displayAge(); // Instance method from Father class.
        son.carrer(); // abstract methods implemented within the child class.
        son.partner();
        Father.greet("Bishal"); // Static concrete method from Father
    }
}
