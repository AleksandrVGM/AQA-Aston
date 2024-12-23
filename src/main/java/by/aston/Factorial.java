package by.aston;

public class Factorial {
    public static long getFactorial(long number) {
        if (number < 0)
            throw new FactorialException(FactorialException.NEGATIVE_NUMBER);
        if (number == 0 || number == 1)
            return 1;
        long result = 1;
        for (int i = 1; i <= number; i++) {
            try {
                result = Math.multiplyExact(result, i);
            } catch (ArithmeticException e) {
                throw new FactorialException(String.format(FactorialException.TOO_BIG_NUMBER, i), e);
            }
        }
        return result;
    }
}