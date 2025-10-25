package oops_4_Generics_Lambda_Exception.exceptionHandling;

public class ExceptionHandling {
    /*
    * Error are irreversible state of program from where we cannot reverse or stay back and cannot be recovered.
    *       In simple words: Things you cannot fix in your program
    *
    * But Exception are the problems in the application code, Bad-logic, Invalid input.
    *       In simple words: Things/Problems you can fix in your program
    *
    * */
    public static void main() {
///        Try-catch-finally block demo for handling Exception prone code

        int a = 5;
        int b = 0;
        try {
//            divide(a,b);
            String name = "Bishal";
            if (name.equals("Bishal")) {
                throw new MyException("name is Bishal which it cannot be.");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("normal exception");
        } finally {
            System.out.println("this will always execute");
        }

    }

    static int divide(int a, int b) throws ArithmeticException{
        if (b == 0) {
            throw new ArithmeticException("please do no divide by zero");
        }

        return  a / b;
    }
}

class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
