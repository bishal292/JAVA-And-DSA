public class EnumDemo {
    /*
     Enum is like a special type of class which contains a fixed set of predefined objects (constants).
     You cannot create new objects of an enum from outside, and all its objects must be declared inside the enum itself.

     Enums can have fields, methods, and private constructors.
     Means only Variable of particular enum type can be created but not a actual object can be created Outside.

     Why to Use?
        - Because enums are used when the values are limited and constant, e.g.

        - Days (MONDAY–SUNDAY)
        - Order status (PENDING–DELIVERED–CANCELLED)
        - User roles (ADMIN–CUSTOMER–GUEST)
        - Traffic light (RED–YELLOW–GREEN)

     Use-cases:
     - Represent fixed sets (e.g., days, seasons, directions).
     - Use in switch statements or as method parameters to restrict valid values.
     - Associate behavior or data with constants (override methods per constant).
     - Replace int/string constant groups to prevent invalid values.

     Advantages:
     - Compile-time type safety (prevents invalid values).
     - Improved readability and maintainability over primitive constants.
     - Built-in helpers: values(), valueOf().
     - Can implement interfaces, have fields, and per-constant behavior.
     - Reduces duplication and runtime errors from magic numbers/strings.
    */


    public enum Season {
        WINTER, SPRING, SUMMER, FALL;

        Season() {
            System.out.println("Constructor is being called");
        }
    }


    enum OrderStatus {
///     Orders Status's Enum Objects.

        PENDING("Order has been placed"),
        SHIPPED("Order is on the way"),
        DELIVERED("Order has been delivered"),
        CANCELLED("Order was cancelled");

        private final String message;

        // Enum constructor (always private) means no object from outside can be created.
        OrderStatus(String message) {
            this.message = message;
        }

//        enum OrderStatus instance method.
        public String getMessage() {
            return message;
        }
    }


    static void main() {
//        Season ss = new Season(); cannot be instantiated.
        Season season = Season.SPRING;

        System.out.println(season);

        OrderStatus status = OrderStatus.SHIPPED;

        System.out.println("Status: " + status);
        System.out.println("Message: " + status.getMessage());
    }
}
