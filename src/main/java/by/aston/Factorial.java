package by.aston;

public class Factorial {
    public static long getFactorial(long number) {
        if (number < 0)
            throw new FactorialException(FactorialException.messageException);
        if (number == 0 || number == 1)
            return 1;
        long result = 1;
        for (int i = 1; i <= number; i++) {
            long old = result;
            result *= i;
            if(old > result)
                throw new RuntimeException("It is impossible to calculate for the number = " + number);
        }
        return result;
    }
}