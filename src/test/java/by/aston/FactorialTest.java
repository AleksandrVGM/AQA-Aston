package by.aston;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    @DataProvider
    public Object[][] data(){
            return new Object[][]{
                    {0L, 1L},
                    {1L, 1L},
                    {2L, 2L},
                    {4L, 24L},
                    {5L, 120L},
                    {6L, 720L},
                    {7L, 5040L},
                    {8L, 40320L},
                    {9L, 362880L},
                    {10L, 3628800L},
                    {11L, 39916800L},
                    {12L, 479001600L},
                    {13L, 6227020800L},
                    {14L, 87178291200L},
                    {15L, 1307674368000L},
                    {16L, 20922789888000L},
                    {17L, 355687428096000L},
                    {18L, 6402373705728000L},
                    {19L, 121645100408832000L},
                    {20L, 2432902008176640000L}
            };
    }

    @Test(dataProvider = "data")
    public void testGetFactorial(Long number, Long factorial) {
        assertEquals(Factorial.getFactorial(number),factorial);
    }

    @Test
    public void getFactorial(){
        long number = -5;
        assertThrows(FactorialException.messageException, FactorialException.class, ()->Factorial.getFactorial(number));
    }
}