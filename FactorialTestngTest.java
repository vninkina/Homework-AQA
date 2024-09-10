import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.math.BigInteger;

public class FactorialTestngTest extends Assert {
    @Test(description = "1. Проверка вычесления факториала")

    public void testFactorialCalculations() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(Factorial.getFactorial(0), BigInteger.ONE, "Факториал числа 0 должен быть: 1");
        softAssert.assertEquals(Factorial.getFactorial(1), BigInteger.ONE, "Факториал числа 1 должен быть: 1");
        softAssert.assertEquals(Factorial.getFactorial(2), BigInteger.valueOf(2), "Факториал числа 2 должен быть: 2");
        softAssert.assertEquals(Factorial.getFactorial(3), BigInteger.valueOf(6), "Факториал числа 3 должен быть: 6");
        softAssert.assertEquals(Factorial.getFactorial(4), BigInteger.valueOf(24), "Факториал числа 4 должен быть: 24");
        softAssert.assertEquals(Factorial.getFactorial(5), BigInteger.valueOf(120), "Факториал числа 5 должен быть: 120");


        try {
            Factorial.getFactorial(-1);
            softAssert.fail("IllegalArgumentException expected for negative numbers");
        } catch (IllegalArgumentException e) {
        }

        softAssert.assertAll();
    }
}