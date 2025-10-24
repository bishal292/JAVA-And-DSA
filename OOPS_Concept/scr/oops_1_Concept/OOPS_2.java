package oops_1_Concept;

import javax.sound.midi.Soundbank;
import java.util.SortedMap;

// --------------------------------------------------------------------------------------------------------------------------------------------
//                  Packages , static keyword, Blocks, in-built method
// --------------------------------------------------------------------------------------------------------------------------------------------
class Employee {
    		/*
		 	A package is a collection of classes and interfaces
		 	and there are mainly two types of package , they are :-

		 	1. User-defined packages :->
		 			Packages which are declared by programmers while constructing an application
		 			or a program is known as user defined package.

		 			It is declared by using keyword 'package'.
		 			Syntax : -
		 					package Package_Name ;

					As in this case the package name is p1 which is user defined.

		 	2. predefined package :->
		 			The package which already declared and can be used by importing the package.
		 			-> In this case the predefined package is "util" package which Consists up of
		 				different classes such as Scanner,Arrays,etc....


            # In-Built Methods:-> The method which are already created in a class and we can directly use it.Some most used are:
                   println(),main(),add(),and many more....
		 */

// --------------------------------------------------------------------------------------------------------------------------------------------
//                                  Static
// --------------------------------------------------------------------------------------------------------------------------------------------

    /* Static
     * the members of a class which are declared along with the keyword static are the static members.
     * these members are also known sa class members and can be used,call irrespective of objects.
     * whereas non-static members(Which are not declared using static keyword) requires an object of the class to which they belong to execute or to be accessed.
     * And the value of a static member is same for all the objects(instances).
     *
     * these member can be accessed without creating an object of the class.
     * This is the reason why the main method is static as main method is the first thing which runs in a java program then it should not be dependable on any other stuff.
     *
     * A Static method can only access other static data directly.
     * But instance members can access static data also.
     *
     * blocks (Code Written inside '{}' are known as block.) and block with static keyword is known as Static block and block without any keyword is known as instance blocks.
     * Static Blocks are executed once when the class is loaded for first time with the highest priority.
     * While Instance Blocks executed each time a new object is created with the highest priority after static block.
     *
     * NO OUTER class can be static but inner class can be.
     * */

    /*Here for every object of an employee class the count of total employee should be same.
     * but name and salary can be different.*/
    static int count;
    String name;
    int salary;
    static {
        System.out.println("I am Static block of Employee class.");
    }
    {
        System.out.println("I am Instance Block of Employee class.");
    }


    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        count += 1; // Each time a new object is being created increase the count.
    }

    void printDetails() {
        System.out.println(STR."Name is : \{name} and salary is : \{salary}");
        System.out.println(STR."Total number of Employee is : \{count}");
    }

    static void greet() {
        System.out.println("Hello");
//        prinDetails(); // Cannot access as printDetails is object dependent.
    }
}

public class OOPS_2 {

    static void main(String[] args) {
        Employee e1 = new Employee("Rohan", 10000);
        Employee e2 = new Employee("Shiv", 140000);

        System.out.println(Employee.count); // can be accessed using objects also but that is not a good practice.
        e2.printDetails();
    }
}