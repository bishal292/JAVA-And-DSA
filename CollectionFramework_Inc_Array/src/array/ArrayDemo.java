package array;

/*
 Arrays in Java:
 
 -> An array is a collection of similar data types stored in contiguous memory locations.
 -> It can be a primitive type or an object reference.
 -> Arrays are fixed in size and indexed starting from 0.

 Types of Arrays:
 1. One-Dimensional Array
 2. Multi-Dimensional Array
 3. Anonymous Array
 4. Jagged Array
 5. Object Array
*/
class Student { //Default class used for demonstrating ObjectArray.
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

public class ArrayDemo {
	public static int sum(int[] arr) {
        int total = 0;
        for (int value : arr) {
            total += value;
        }
        return total;
    }
    public static void main(String[] args) {
    	
//------------------------------------------------------------------------------------------------------------------------
    	/*
    	 One-Dimensional Array:
    	 
    	 -> A simple array with a single row of elements.
    	 -> Syntax: dataType[] arrayName = new dataType[size];
    	*/
    	 int[] arr = new int[5];//Array Declaration
         // Initialize array
         for (int i = 0; i < arr.length; i++) {
             arr[i] = i + 1;
         }
         // Print array
         System.out.println("One-Dimensional Array:");
         for (int value : arr) {
             System.out.print(value + " ");
         }
         System.out.println();
         
//------------------------------------------------------------------------------------------------------------------------
         
         /*
         Multi-Dimensional Array:
         
         -> An array with more than one dimension (e.g., 2D, 3D arrays).
         -> Syntax: dataType[][] arrayName = new dataType[rows][columns];
        */
        
         int[][] arr2 = new int[3][3];//2D Array Declaration.
         // Initialize array
         int count = 1;
         for (int i = 0; i < arr2.length; i++) {
             for (int j = 0; j < arr2[i].length; j++) {
                 arr2[i][j] = count++;
             }
         }
         System.out.println("Multi-Dimensional Array:");
         for (int[] row : arr2) {
             for (int value : row) {
                 System.out.print(value + " ");
             }
             System.out.println();
         }
         
         
//------------------------------------------------------------------------------------------------------------------------
         
         /*
         Anonymous Array:
         
         -> An array with no explicit reference variable.
         -> Useful when array is created and passed directly to methods.
        */
         
         System.out.println("Sum of Anonymous Array: " + sum(new int[]{10, 20, 30}));//Array being passed to sum is an anonymous array.

         
//------------------------------------------------------------------------------------------------------------------------

         /*
         Jagged Array:
         
         -> An array of arrays where each sub-array can have different lengths.
         -> The no. of subArrays must be fixed during Initialization.
         -> Syntax: dataType[][] arrayName = new dataType[rows][];
        */
         
         int[][] arr3 = new int[3][];
         arr3[0] = new int[]{1, 2};
         arr3[1] = new int[]{3, 4, 5};
         arr3[2] = new int[]{6};

         System.out.println("Jagged Array:");
         for (int[] row : arr3) {
             for (int value : row) {
                 System.out.print(value + " ");
             }
             System.out.println();
         }
         
//------------------------------------------------------------------------------------------------------------------------
         
         /*
         Object Array:
         
         -> An array that holds objects of a specific type.
         -> Useful for storing user-defined types or class instances.
        */
         Student[] students = new Student[3];//Object array of Type 'Student' of size 3 is declared.
         students[0] = new Student("Alice", 20);
         students[1] = new Student("Bob", 22);
         students[2] = new Student("Charlie", 23);

         // Print student details
         System.out.println("Object Array:");
         for (Student student : students) {
             student.display();
         }
    }
}
