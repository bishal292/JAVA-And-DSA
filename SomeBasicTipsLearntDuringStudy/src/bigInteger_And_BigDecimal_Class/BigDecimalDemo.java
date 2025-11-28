package bigInteger_And_BigDecimal_Class;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    static void main(String[] args) {
        double d = 0.4;
        double d2 = 0.3;
        System.out.println(d - d2); /// It is not that accurate as it should be 0.1 because have very less(minor) error. around 10^19.
        BigDecimal bd = BigDecimal.valueOf(0.4);
        BigDecimal bd2 = BigDecimal.valueOf(0.3);
        System.out.println(bd.subtract(bd2)); /// -> It is accurate and used in system where accurate result and calculation are required.


        BigDecimal num = BigDecimal.valueOf(3);
        BigDecimal den = BigDecimal.valueOf(2);
        System.out.println(num.divide(den)); /// -> Cannot divide recurring(Never Ending Number '22/7' ).
    }
}
