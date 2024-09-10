import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {

        System.out.println(getFactorial(5));
    }

    public static BigInteger getFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для целых неотрицательных чисел.");
        }
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; ++i) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

}