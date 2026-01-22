package oops_4_Generics_Lambda_Exception.exceptionHandling;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ExceptionHandling {

    String name;

    /**
     * Errors: Errors represent serious problems that occur in a program and are generally not recoverable.
     * They are caused by the runtime environment and should not be handled by application code.
     * Errors usually lead to abnormal termination of the program.
     * Example: StackOverflowError, OutOfMemoryError.
     * <p>
     * Exceptions: Exceptions are events that occur during program execution which disrupt the normal flow of the program.
     * They can occur due to invalid input,bad logic, or external conditions (like I/O failure), and are generally recoverable using proper exception handling.
     * <p>
     * In simple words:
     * -> Errors are problems that applications should not try to handle,
     * -> whereas Exceptions are problems that applications can handle and recover from.
     * <p>
     * Types of Exceptions:
     * <p>
     * 1. Checked Exceptions: These exceptions are checked by the compiler for proper handling.
     * -> They must be either caught or declared using throws.
     * -> Example: IOException, SQLException.
     * <p>
     * 2. Unchecked Exceptions (Runtime Exceptions): These exceptions are not checked by the compiler. They occur during runtime due to programming errors.
     * -> Handling them is not mandatory but recommended to avoid abnormal termination.
     * -> Example: ArithmeticException, NullPointerException.
     *
     *
     * --------------------------------------------KEYWORDS FINALLY THROW & THROWS---------------------------------------------------------
     * 0. finally keyword: used along with try-catch block where the finally block is written after all the catch block,
     *      and it ensures the code inside it will always execute irrespective of the Exceptions
     *
     * 1. throw keyword: The throw keyword is used to explicitly throw an exception object from a method or a block of code.
     * It is mainly used to create custom exceptions or to propagate an exception manually based on program logic.
     * Characteristics:
     * -> Used inside a method or block
     * -> Throws a single exception object at a time
     * -> Can throw both checked and unchecked exceptions
     *
     * Example: throw new IllegalArgumentException("Invalid input"); => Will throw a IllegalArgumentException manually.
     *
     * throws keyword: The throws keyword is used in the method signature to declare that a method may pass one or more exceptions to the calling method.
     * It does not throw the exception but informs the caller about possible exceptions and callers must handle the Exceptions being thrown by the function.
     *
     * Characteristics:
     * -> Used in method declaration
     * -> Can declare multiple exceptions separated by commas
     * -> Mainly used for checked exceptions
     *
     * Example:
     * void readFile() throws IOException, SQLException {
     *     // risky code
     * }
     *
     * Key Difference (In Simple Words):
     * throw is used to actually throw an exception,
     * whereas throws is used to declare exceptions that may occur.
     *
     * NOTE: The throws keyword CAN be used with the main method.
     * If an exception is declared using throws in main() and is not handled, the exception is propagated to the JVM.
     *
     * Since the JVM does not handle exceptions, it will terminate the program and print the stack trace.
     *
     * Using throws in main() is acceptable for quick testing or small programs,
     * but in production applications, exceptions should be properly handled to ensure graceful termination.
     * */

    public static void main() {
        int a = 19;
        int b = 0;
        ExceptionHandling e = null;
        ///  Unhandled Exceptions or exceptions prone code.

        ///  -----------------------Unchecked Exceptions ------------------------
/**
        System.out.println(a / b); /// -> Will leads in arithmetic exception (/ by zero) and will terminate the flow.

        System.out.println(e.name); /// -> Will leads in nullPointer Exception as e itself is null, and we're trying to even get its name.

        System.out.println("Last Line after the Exception prone code."); /// This will never be executed as above code will cause exception.
*/
        /// ------------------------Checked Exceptions---------------------------
        File f = new File("file.txt");
//        FileReader fr = new FileReader(f); /// The Red Mark on the editor is showing that there is a checked Exception which are required to be handled.


        ///  Different Way of handling Exceptions.
        /// ---------------------------------------------------------------------------
        ///  Try Catch Block.
        ///        Syntax :->  try{ //Exception Prone Codes }catch(<ExceptionObject>){Working with Exception}
        ///        There can be multiple Exceptions in a try block and can have multiple catch block individually for each type of exceptions.
        ///         While having multiple catch block the parent Exception class must be handled below it's child class if both are there.
        try {
            System.out.println(divide(a, b)); /// as divide method is throwing the arithmetic exception and not handling it in itself.It must be handled in the function calling it.
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }




        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first Number");
            a = scanner.nextInt();
            System.out.println("Enter the second Number");
            b = scanner.nextInt();
            System.out.println(a / b); /// -> Will leads in arithmetic exception (/ by zero) and will terminate the flow if b is 0.

            e = null;
            System.out.println("Are you trying to create a null pointer Exception? ");
            boolean b1 = scanner.nextBoolean();
            if (!b1)
                e = new ExceptionHandling(); /// If user don't want to create a null pointer exception then simple create a new object.

            System.out.println(e.name); /// -> Will leads in nullPointer Exception as e itself is null, and we're trying to even get its name.

            System.out.println("Are you trying to create any other Exceptions ?");
            boolean b2 = scanner.nextBoolean();
            if (b2){
                System.out.println("Enter the message of the Exception");
                scanner.nextLine();
                String msg = scanner.nextLine();
                throw new Exception(msg);
            }
            System.out.println("Last Line after the Exception prone code."); /// This will never be executed as above code will cause exception.
        } catch (ArithmeticException ae) {
            System.err.println("There was an Arithmetic Exception: / by zero");
        } catch (NullPointerException ne) {
            System.err.println("There was a NullPointer Exception.");
        }catch (Exception ee) {
            System.err.println("Something went wrong: "+ee.getMessage());
        }finally {
            System.out.println("This is a finally block and Will always executes irrespective of exceptions");
        }
    }

    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Throwing Exception from Divide Function manually: please do no divide by zero.");
        }
        return a / b;
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
