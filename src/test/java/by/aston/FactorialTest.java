package by.aston;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    void getFactorial() {
        long expected = 120;
        long actual = Factorial.getFactorial(5);
        assertEquals(expected, actual);
    }

    @Test
    void getFactorialByZero() {
        long expected = 1;
        long actual = Factorial.getFactorial(0);
        assertEquals(expected, actual);
    }

    @Test
    void getFactorialByOne() {
        long expected = 1;
        long actual = Factorial.getFactorial(1);
        assertEquals(expected, actual);
    }

    @Test
    void getFactorialThrowFactorialExceptionWithNegativeArgument() {
        assertThrows(FactorialException.class, () -> Factorial.getFactorial(-5), FactorialException.messageException);
    }
}