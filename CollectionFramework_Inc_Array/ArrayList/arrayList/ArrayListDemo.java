package arrayList;

import java.util.ArrayList;

/*
 ArrayLists in Java:
 
 -> ArrayList is a resizable array from the Java Collections Framework.
 -> It allows dynamic resizing and provides methods for manipulating the size and content.
 -> Elements can be added or removed, and duplicates are allowed.

 Key Features:
 1. Dynamic resizing.
 2. Allows duplicates.
 3. Provides various utility methods (add, remove, size, contains, etc.).
 4. Maintains insertion order.

 Types of ArrayLists:
 1. Generic ArrayList
 2. ArrayList with Custom Objects
 3. Multi-Dimensional ArrayList
*/
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class ArrayListDemo {

    public static void main(String[] args) {

//------------------------------------------------------------------------------------------------------------------------
        /*
         Generic ArrayList:
         
         -> A type-safe ArrayList that holds elements of a specific data type.
         -> Syntax: ArrayList<dataType> listName = new ArrayList<>();
        */
        ArrayList<Integer> list = new ArrayList<>(); // Generic ArrayList Declaration
        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        // Print elements
        System.out.println("Generic ArrayList:");
        for (Integer value : list) {
            System.out.print(value + " ");
        }
        System.out.println();

//------------------------------------------------------------------------------------------------------------------------

        /*
         ArrayList with Custom Objects:
         
         -> An ArrayList that stores user-defined objects.
         -> Useful for managing collections of complex data types.
        */
        ArrayList<Student> students = new ArrayList<>(); // ArrayList of Student Objects
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 23));
        
        System.out.println("ArrayList with Custom Objects:");
        for (Student student : students) {
            student.display();
        }

//------------------------------------------------------------------------------------------------------------------------

        /*
         Multi-Dimensional ArrayList:
         
         -> An ArrayList where each element is another ArrayList.
         -> Used to represent grids, tables, or complex structures.
        */
        ArrayList<ArrayList<Integer>> multiList = new ArrayList<>();
        
        // Initialize multi-dimensional ArrayList
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                subList.add(j + 1);
            }
            multiList.add(subList);
        }
        
        System.out.println("Multi-Dimensional ArrayList:");
        for (ArrayList<Integer> subList : multiList) {
            System.out.println(subList);
        }

//------------------------------------------------------------------------------------------------------------------------

        /*
         ArrayList Utility Methods:
         
         -> ArrayLists provide several utility methods such as add, remove, size, contains, and indexOf.
        */
        ArrayList<String> utilityList = new ArrayList<>();
        utilityList.add("Java");
        utilityList.add("Python");
        utilityList.add("C++");

        System.out.println("ArrayList Utility Methods:");
        System.out.println("Initial List: " + utilityList);
        utilityList.remove("Python");
        System.out.println("After Removal: " + utilityList);
        System.out.println("List Contains 'C++': " + utilityList.contains("C++"));
        System.out.println("Size of List: " + utilityList.size());
    }
}
