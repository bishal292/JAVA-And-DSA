package FeaturesAfterJava8;
/**
 * =============================== JAVA FEATURES AFTER JAVA 8 ===============================
 *
 * This file explains important Java features introduced after Java 8,
 * including their purpose, rules, and real-world use cases.
 *
 * Covered Versions:
 * -> Java 9
 * -> Java 10
 * -> Java 14+
 * -> Java 16+
 * -> Java 17 (LTS)
 *
 * NOTE:
 * These features improve readability, immutability, safety, and developer productivity.
 */

import java.util.List;
import java.util.Map;

public class JavaPost8Features {
    public static void main(String[] args) {

        /**
         * -------------------------------------------- JAVA 10 : var KEYWORD ----------------------------------------
         *
         * var:
         * -> Enables local variable type inference
         * -> Compiler infers the type at compile time
         *
         * IMPORTANT RULES:
         * -> Can be used ONLY for local variables
         * -> NOT allowed for fields, method params, return types
         * -> Type is still strongly typed (NOT dynamic typing)
         */

        var number = 10;              // int
        var name = "Bishal";          // String
        var list = List.of(1, 2, 3);  // List<Integer>

        // var x; NOT allowed (must be initialized)

        System.out.println(number);
        System.out.println(name);
        System.out.println(list);

        /**
         * Why var?
         * -> Reduces boilerplate
         * -> Improves readability (especially with generics)
         */


        /**
         * -------------------------------------------- JAVA 9 : FACTORY METHODS -------------------------------------
         *
         * List.of(), Set.of(), Map.of():
         * -> Create immutable collections
         * -> Null elements NOT allowed
         */

        List<String> skills = List.of("Java", "Spring", "SQL");
        Map<String, Integer> marks = Map.of(
                "Math", 90,
                "Java", 95
        );

        // skills.add("React"); ❌ UnsupportedOperationException

        System.out.println(skills);
        System.out.println(marks);

        /**
         * Use-case:
         * -> Constants
         * -> Configuration data
         */


        /**
         * -------------------------------------------- JAVA 14+ : SWITCH EXPRESSION ---------------------------------
         *
         * Switch as an expression (returns value)
         * -> No fall-through
         * -> More readable
         */

        int day = 3;

        String dayType = switch (day) {
            case 1, 7 -> "Weekend";
            case 2, 3, 4, 5, 6 -> "Weekday";
            default -> "Invalid day";
        };

        System.out.println(dayType);


        /**
         * -------------------------------------------- JAVA 14+ : RECORDS -------------------------------------------
         *
         * record:
         * -> Special immutable data carrier class
         * -> Automatically generates:
         *    - constructor
         *    - getters
         *    - equals()
         *    - hashCode()
         *    - toString()
         *
         * RULES:
         * -> Fields are final
         * -> Cannot extend other classes
         */

        Person p = new Person("Aman", 22);
        System.out.println(p.name());
        System.out.println(p);


        /**
         * Why records?
         * -> Replace boilerplate POJOs
         * -> Best for DTOs, API responses
         */


        /**
         * -------------------------------------------- JAVA 15+ : TEXT BLOCKS ----------------------------------------
         *
         * Text Blocks:
         * -> Multi-line string literals
         * -> Cleaner than concatenation
         */

        String json = """
                {
                    "name": "Bishal",
                    "role": "Developer",
                    "experience": 1
                }
                """;

        System.out.println(json);


        /**
         * -------------------------------------------- JAVA 17 (LTS) : SEALED CLASSES --------------------------------
         *
         * sealed classes:
         * -> Restrict which classes can extend a class
         * -> Improves security & design control
         *
         * Requires:
         * -> sealed
         * -> permits
         * -> final / sealed / non-sealed subclasses
         */

        Shape shape = new Circle(10);
        System.out.println(shape.area());
    }
}


/**
 * -------------------------------------------- RECORD EXAMPLE ----------------------------------------------------
 */
record Person(String name, int age) {}


/**
 * -------------------------------------------- SEALED CLASS EXAMPLE ----------------------------------------------
 */
sealed abstract class Shape permits Circle, Rectangle {
    abstract double area();
}

final class Circle extends Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle extends Shape {
    int length = 10;
    int width = 5;

    @Override
    double area() {
        return length * width;
    }
}
