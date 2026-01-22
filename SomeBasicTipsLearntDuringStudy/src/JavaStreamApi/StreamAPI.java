package JavaStreamApi; /**
 * ============================================ JAVA STREAM API ===================================================
 *
 * Stream API (introduced in Java 8):
 * Stream API is used to process collections of data in a functional and declarative manner.
 * It allows operations like filtering, mapping, and reducing data without modifying
 * the original data source.
 *
 * IMPORTANT:
 * -> Stream does NOT store data
 * -> Stream does NOT change the original collection
 * -> Stream operations are lazy (executed only after terminal operation)
 *
 *
 * -------------------------------------------- STREAM PIPELINE ---------------------------------------------------
 *
 * Source  -> Intermediate Operations -> Terminal Operation
 *
 * Example:
 * list.stream()
 *     .filter(...)
 *     .map(...)
 *     .reduce(...)
 *
 *
 * -------------------------------------------- INTERMEDIATE OPERATIONS --------------------------------------------
 *
 * -> filter() : used to select elements based on condition
 * -> map()    : used to transform elements
 *
 * These operations return a Stream and are lazy.
 *
 *
 * -------------------------------------------- TERMINAL OPERATIONS ------------------------------------------------
 *
 * -> forEach()
 * -> collect()
 * -> reduce()
 *
 * Terminal operations trigger execution of stream pipeline.
 */

import java.util.*;
import java.util.stream.*;

public class StreamAPI {

    public static void main(String[] args) {

        // Source collection
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        /**
         * -------------------------------------------- FILTER ------------------------------------------------------
         *
         * filter(Predicate):
         * -> Selects elements based on condition
         * -> Predicate returns boolean
         *
         * Use-case:
         * -> Extract even numbers
         */
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Even Numbers: " + evenNumbers);

        /**
         * -------------------------------------------- MAP ---------------------------------------------------------
         *
         * map(Function):
         * -> Transforms each element
         * -> Input type and output type can be different
         *
         * Use-case:
         * -> Square each number
         */
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();

        System.out.println("Squared Numbers: " + squaredNumbers);

        /**
         * -------------------------------------------- FILTER + MAP -------------------------------------------------
         *
         * Use-case:
         * -> Square only even numbers
         */
        List<Integer> squaredEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();

        System.out.println("Squared Even Numbers: " + squaredEvenNumbers);

        /**
         * -------------------------------------------- REDUCE ------------------------------------------------------
         *
         * reduce():
         * -> Combines stream elements into a single result
         * -> Uses accumulator function
         *
         * Use-case:
         * -> Sum of all numbers
         */
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum of Numbers: " + sum);

        /**
         * reduce() WITHOUT identity:
         * -> Returns Optional
         *
         * Use-case:
         * -> Find maximum number
         */
        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);

        max.ifPresent(m -> System.out.println("Max Number: " + m));

        /**
         * -------------------------------------------- REAL-WORLD STYLE EXAMPLE -------------------------------------
         *
         * Employee salary processing
         */
        List<Employee> employees = List.of(
                new Employee("Aman", "IT", 60000),
                new Employee("Ravi", "HR", 45000),
                new Employee("Neha", "IT", 80000),
                new Employee("Pooja", "Finance", 70000)
        );

        /**
         * Use-case:
         * -> Get total salary of IT employees
         */
        int totalItSalary = employees.stream()
                .filter(e -> e.department.equals("IT"))
                .map(e -> e.salary)
                .reduce(0, Integer::sum);

        System.out.println("Total IT Salary: " + totalItSalary);
    }
}

/**
 * Simple POJO used in Stream examples
 */
class Employee {
    String name;
    String department;
    int salary;

    Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
