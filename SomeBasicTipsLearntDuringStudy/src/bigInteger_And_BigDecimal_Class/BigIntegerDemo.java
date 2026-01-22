package bigInteger_And_BigDecimal_Class;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static BigInteger factorial(int n) {
        if (n <= 1) return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    static void main(String[] args) {
        BigInteger bg = BigInteger.valueOf(98543982943584L); /// Expects a long value and internally converts into a BigInteger Object.
        ///  Can be created an bigInteger object with any amount of digits passed in the constructor as a string parameter.
        BigInteger bg2 = new BigInteger("896533579857481739820134353756871683029819587893");

        BigInteger add = bg.add(bg2);
        BigInteger sub = bg2.subtract(bg);
        BigInteger mul = bg.multiply(bg2);
        BigInteger div = bg2.divide(bg);
        BigInteger rem = bg2.remainder(bg);

//        System.out.println(add);
//        System.out.println(sub);
//        System.out.println(mul);
//        System.out.println(div);
//        System.out.println(rem);

        System.out.println(factorial(100));

    }
}
