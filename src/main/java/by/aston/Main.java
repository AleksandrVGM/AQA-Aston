package by.aston;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        //task1
        System.out.println("Task1");
        printThreeWords();
        System.out.println();
        //task2
        System.out.println("Task2");
        checkSumSign();
        System.out.println();
        //task3
        System.out.println("Task3");
        printColor();
        System.out.println();
        //task4
        System.out.println("Task4");
        compareNumbers();
        System.out.println();
        //task5
        System.out.println("Task5");
        System.out.println(checkSumBetweenTenAndTwenty(5,5));
        System.out.println();

        //task6
        System.out.println("Task6");
        printSignNum(-10);
        System.out.println();

        //task7
        System.out.println("Task7");
        System.out.println(checkSignNum(-1));
        System.out.println();

        //task8
        System.out.println("Task8");
        printRepeatedString("Java", 2);
        System.out.println();

        //task9
        System.out.println("Task9");
        System.out.println("Год высокосный? " + isIntercellularYear(2100));
        System.out.println();

        //task10
        System.out.println("Task10");
        flipBit();
        System.out.println();

        //task11
        System.out.println("Task11");
        task11();
        System.out.println();

        //task12
        System.out.println("Task12");
        task12();
        System.out.println("\n");

        //task13
        System.out.println("Task13");
        task13(5);
        System.out.println();

        System.out.println("Task14");
        int[] array = task14(3, 148);
        Arrays.stream(array).forEach(System.out::print);
    }

    //task1
    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }
    //task2
    public static void checkSumSign(){
        int a = 3;
        int b = -2;
        if (a+b >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
    //task3
    public static void printColor(){
        int value = 101;
        if(value <=0){
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }
    //task4
    public static void compareNumbers(){
        int a = 2;
        int b = 2;
        if(a>=b){
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }
    //task5
    public static boolean checkSumBetweenTenAndTwenty(int number1, int number2){
        int sum = number1 + number2;
        return sum > 10 && sum <= 20;
    }
    //task6
    public static void printSignNum(int number){
        if(number >= 0){
            System.out.println("Положительное число");
        }
        else{
            System.out.println("Отрицательное число");
        }
    }
    //task7
    public static boolean checkSignNum(int number){
        return !(number >= 0);
    }
    //task8
    public static void printRepeatedString(String string, int count){
        if (string != null && !string.isEmpty())
        {
            for (int i = 0; i < count; i++){
                System.out.println(string);
            }
        }
    }

    //task9
    public static boolean isIntercellularYear( int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    //task10
    public static void flipBit(){
        int array[] = {1,1,0,0,1,0,1,1,0,0};
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == 1) {
                array[i] = 0;
            }
            else{
                array[i] = 1;
            }
        }
        System.out.print("[");
        for (int element : array){
            System.out.print(element + " ");
        }
        System.out.print("]");
    }
    public static void task11(){
        int array[] = new int[100];
        for (int i = 0; i < array.length; i++){
            array[i] = i+1;
        }
        System.out.print("[");
        for (int element : array){
            System.out.print(element + " ");
        }
        System.out.print("]");
    }
    public static void task12(){
        int array[] = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < array.length; i++){
            if(array[i] < 6)
                array[i] *= 2;
        }
        System.out.print("[");
        for (int element : array){
            System.out.print(element + " ");
        }
        System.out.print("]");
    }

    public static void task13(int n){
        int square[][] = new int[n][n];
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j < square[i].length; j++){
                if((i == j)||((i == n - j - 1) && (j == n -i - 1)))
                    square[i][j] = 1;
            }
        }
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j < square[i].length; j++){
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }

    public static void task13_2(){
        int n = 5;
        int square[][] = new int[n][n];
        for (int i = 0, j = 0; i < square.length; i++, j++){
            square[i][j] = 1;
        }
        for (int i = 0, j = square.length - 1; i < square.length; i++, j--){
            square[i][j] = 1;
        }
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j < square[i].length; j++){
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] task14(int len, int initialValue){
        if (len <= 0) {
            len = 0;
            System.out.println("Введите длину массива больше ноля.");
        }
        int array[] = new int[len];
        for (int i = 0; i < len; i++){
            array[i] = initialValue;
        }
        return array;
    }

}