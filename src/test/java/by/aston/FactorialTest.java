package by.aston;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test()
    @DisplayName("Calculating factorial for 5.")
    void getFactorialTest() {
        long expected = 120;
        long actual = Factorial.getFactorial(5);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calculating factorial for 0.")
    void getFactorialByZeroTest() {
        long expected = 1;
        long actual = Factorial.getFactorial(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calculating factorial for 1.")
    void getFactorialByOneTest() {
        long expected = 1;
        long actual = Factorial.getFactorial(1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test throw FactorialException for negative number = -5.")
    void getFactorialThrowFactorialExceptionWithNegativeArgument() {
        assertThrows(FactorialException.class, () -> Factorial.getFactorial(-5), FactorialException.NEGATIVE_NUMBER);
    }

    @Test
    @DisplayName("Test throw FactorialException for too big number.")
    void getFactorialThrowFactorialExceptionWithTooBigArgument() {
        long number = 21;
        String message = String.format(FactorialException.TOO_BIG_NUMBER, number);
        assertThrows(FactorialException.class, () -> Factorial.getFactorial(number), message);
    }

}