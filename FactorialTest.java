import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    @DisplayName("1. Проверка вычисления факториала")
    void testFactorialCalculations() {
        assertAll("Проверка вычисления факториала",
                () -> assertEquals(BigInteger.ONE, Factorial.getFactorial(0), "Факториал числа 0 должен быть: 1"),
                () -> assertEquals(BigInteger.ONE, Factorial.getFactorial(1), "Факториал числа 1 должен быть: 1"),
                () -> assertEquals(BigInteger.valueOf(2), Factorial.getFactorial(2), "Факториал числа 2 должен быть: 2"),
                () -> assertEquals(BigInteger.valueOf(6), Factorial.getFactorial(3), "Факториал числа 3 должен быть: 6"),
                () -> assertEquals(BigInteger.valueOf(24), Factorial.getFactorial(4), "Факториал числа 4 должен быть: 24"),
                () -> assertEquals(BigInteger.valueOf(120), Factorial.getFactorial(5), "Факториал числа 5 должен быть: 120"),
                () -> assertEquals(BigInteger.valueOf(720), Factorial.getFactorial(6), "Факториал числа 6 должен быть: 720"),
                () -> assertEquals(BigInteger.valueOf(5040), Factorial.getFactorial(7), "Факториал числа 7 должен быть: 5040"),
                () -> assertEquals(BigInteger.valueOf(40320), Factorial.getFactorial(8), "Факториал числа 8 должен быть: 40320"),
                () -> assertThrows(IllegalArgumentException.class, () -> Factorial.getFactorial(-1), "Должно быть выброшено исключение IllegalArgumentException для отрицательных чисел"));
    }
}