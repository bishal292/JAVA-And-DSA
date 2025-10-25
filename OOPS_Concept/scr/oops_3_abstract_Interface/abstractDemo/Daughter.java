package oops_3_abstract_Interface.abstractDemo;


public class Daughter extends Father{
    //  As there is a constructor in Father hence it must have one 'super' call matching same
    Daughter(int age) {
        super(age);
    }

    @Override
    void carrer() {
        System.out.println("I want to become an Actor.");
    }

    @Override
    void partner() {
        System.out.println("I love Ayushman Khurrana");
    }

    static void main(String[] args) {
        Daughter daughter = new Daughter(38);
        daughter.carrer();
        daughter.partner();
        daughter.displayAge();
    }
}
