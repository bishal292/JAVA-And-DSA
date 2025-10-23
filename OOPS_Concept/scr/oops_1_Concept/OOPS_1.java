package oops_1_Concept;

import java.util.Arrays;
// -----------------------------------------------------------------------------------------------------------------------
//          Introduction to OOPS, Objects, Classes, Constructors, this,final Keyword intro
// -----------------------------------------------------------------------------------------------------------------------


/*      In Java, a class is a blueprint for creating objects(instances). It defines a type by
        bundling data(fields) and methods(functions) that operates on the data into a single unit.
        created using keyword class
        class ClassName{}

                WhereAS,
                An Object, on the other hand, is an instance of a class. It is a specific realization of the class.
        with its own set of the fields defined by the class.

        object creation:
        ClassName objectName = new ClassName();
        here, The 'new' keyword dynamically allocates memory (Allocated at Runtime) for an object & returns a reference to it.
        reference is the memory address of the object allocated by new and this reference is stored in the variable

        NOTE: when a property is tried to be fetched for an object and is not available with the object then it is checked in the class to which the object belongs.
*/

class Student {
//    These are the instance variable which every object of this class will have
    String name;
    int roll;


//    Constructor is a special function called when an object is created, and it has the same name as the class.
//    If there is no any constructor then by default java compiler will create a constructor for the class.
    Student() {
//        This is constructor called when new object is created without parameter.
        System.out.println("Constructor is being called");
    }

    Student(String name,int roll){
//        This is constructor called when new object is created with the parameter of same types

//        This keyword refers to the object itself which is being created or accessing the function.So, it will update the value of the object.
        this.name = name;
        this.roll = roll;
    }

    void greet() {
        System.out.println("Hello from " + name);
    }

    void printDetails() {
        System.out.println("My name is " + name + " and roll Number is : " + roll);
    }
}

public class OOPS_1 {
    static void main(String[] args) {
        Student st1 = new Student(); // As the value of this is not initialized so it will have the default value for the data individual types.
        Student st2 = new Student("Bishal",23);

        st1.printDetails();
        st2.printDetails();
        st1.greet();
        st2.greet();

        st1.name = "Shiv";
        st1.roll = 12;
        st1.printDetails();

//        -------------------------------------- FINAL KeyWord -------------------------------------------
        /*Final variable are initialized once and can never be modified
         * As modification is not allowed final variable must be initialized when declared
         * Final keyword guarantees immutability for primitive data types
         *               BUT
         * for a final instance variable the reference at which it is pointing to can never be change but the value at that reference can be changed
         *
         * In a simple language: when a non-primitive is final then it cannot be reassigned
         * */
        final int[] ar = {1, 2, 3, 4};
        System.out.println(Arrays.toString(ar));
        ar[1] = 4;
        System.out.println(Arrays.toString(ar));
        int[] array = {12, 34, 53, 56, 77};
//        ar = array; // As ar is declared with final keyword and ar is a type of object so the reference to which ar is pointing to can never be changed but the value at that reference can be modified.
        System.out.println(Arrays.toString(ar));

    }
}
