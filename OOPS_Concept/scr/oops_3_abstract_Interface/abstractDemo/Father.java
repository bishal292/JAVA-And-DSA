package oops_3_abstract_Interface.abstractDemo;
/*      The methods which are declared using 'abstract' keyword are known as abstract Method. And Abstract method cannot have its body.
*        And the class which are defined using abstract keyword are known as abstract class.
*        An abstract method can only be present in the abstract class none other than abstract class can create an abstract method.
*
*       All the abstract method from an abstract class must be implemented(Body construction of methods) by its child class.
*       -> Can there be an Abstract static Method ? => No, as Static method cannot be overridden hence no abstract static method can be created.
*       -> No object for abstract class can be created as abstract class may contain abstract methods(Incomplete methods).
*       -> No abstract constructor can be there as constructor belongs to the same class and is not overridden
*               Instead it is channed through constructor channing so, there can be non-abstract constructor.
*       -> No Abstract class can be final as abstract classes are meant to be inherited and final does not allow inheritance.
*       -> Abstract classes can contain concrete Methods also(Method with body).
*
*       -> Also we cannot achieve multiple inheritance using abstract classes.
*
* */
abstract public class Father {
    private int age;
//  abstract Father(){} // Not- Allowed
    Father(int age){
        this.age = age;
    }
    void displayAge(){
        System.out.println("Age is : "+age);
    }
    static void greet(String name){
        System.out.println("Hello "+name);
    }


//    These  abstract methods must be implemented by each child classes.
    abstract void carrer();
    abstract void partner();
}
