package oops_1_Concept.accessModifier;

/*
* NOTE: The Top-level(Outermost) classes cannot be either protected or private.
* */

public class A {
//    Private Members can be accessed only within the class they are created in including(Inner Class).

    private int num; // Cannot be accessed directly outside this file.(Strict)

//    Default(When no access modifier is mentioned) : They can be accessed within the same package and cannot be accessed outside the package they belongs.
//    Cannot be accessed outside the package as its modifier is default.
    String name; // as class is public it can be accessed through anywhere by creating an object of this class or inheriting this class.


//    Protected cannot be accessed outside the package but if the class accessing it is the subclass of this then it can be accessed
//    Can be accessed from anywhere if the class which is trying to access is a subclass of this one.
    protected int[] arr;

    A(int num,String name){
        this.num = num;
        this.name = name;
    }

//    Getter Method
    public int getNum() {
        return num;
    }

//    Setter Method
    public void setNum(int num) {
        this.num = num;
    }

}