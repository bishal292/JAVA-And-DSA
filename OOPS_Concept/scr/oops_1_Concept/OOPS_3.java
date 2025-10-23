package oops_1_Concept;

//  ---------------------------------------------------------------------------------------------------------------------------------------------
//                      Inner Class
//  ---------------------------------------------------------------------------------------------------------------------------------------------

/* as we know only inner class can be static let's understand why
    because for now we know that static member are not dependent on any object and states that the particular static element belongs to the enclosing class.
    and outer class is already on top and no other classes are enclosing them.

    Inner class VS Static Inner Class
    Static inner class does not require an outer class object to use them or create their own object but Normal(Instance) Inner class do require.

    Syntax for creating an object of non-static inner class.
    OuterClass.InnerClass objectName = OuterClass. new InnerClass();
* */
public class OOPS_3 {
    class A {
        void greetA() {
            System.out.println("Hello from inner class A");
        }
    }

    static class B {
        void greetB() {
            System.out.println("Hello from inner class A");
        }
    }

    static void main(String[] args) {
        B b = new B(); // Direct object can be created as B is a static class.
        b.greetB();
//        A = new A(); // Cannot be created as a is not a static member and do require an object of the class to which it belongs.
        OOPS_3 outerObj = new OOPS_3();

        OOPS_3.A a = outerObj. new A();
        a.greetA();
    }
}
