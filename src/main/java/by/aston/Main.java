package by.aston;

public class Main {
    public static final int SIZE = 4;
    public static final String MESSAGE_ARRAY_SIZE_EXCEPTION = "Size of array[%d][%d] does not match the required size: array[%d][%d].";
    public static final String MESSAGE_ARRAY_DATA_EXCEPTION = "Element array[%d][%d] is not a number. " + "Element array[%d][%d] = %S";

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "8", "7", "6"}, {"1", "2", "3", "4"}};
        String[][] arraySizeException = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "8", "7", "6"}};
        String[][] arrayDataException = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "$", "7", "6"}, {"1", "2", "3", "4"}};

        try {
            System.out.println("sum = " + sum(array));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            sum(arraySizeException);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            sum(arrayDataException);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != SIZE || array[0].length != SIZE) {
            throw new MyArraySizeException(String.format(MESSAGE_ARRAY_SIZE_EXCEPTION, array.length, array[0].length, SIZE, SIZE));
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format(MESSAGE_ARRAY_DATA_EXCEPTION, i, j, i, j, array[i][j]), e);
                }
            }
        }
        return sum;
    }
}