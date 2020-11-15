package com.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        oddNumbers(99); //1, 3, 4
        System.out.println();
        factorial(5); // 2, 3, 4

        System.out.println("------------------------------------------------------------------------");

        System.out.println(ANSI_RED + "TASK5" + ANSI_RESET);
        int x = (int) (Math.random() * 10); // 5
        int n = (int) (Math.random() * 10);
        int res = (int) Math.pow(x, n);
        System.out.println(x + "^" + n + " = " + res);

        System.out.println("------------------------------------------------------------------------");

        System.out.println(ANSI_RED + "TASK6" + ANSI_RESET);
        int startNumber = 0; // 6
        for (int i = 0; i < 10; i++) {
            System.out.print(startNumber + " ");
            startNumber -= 5;
        }
        System.out.println();

        System.out.println("------------------------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_RED + "TASK7" + ANSI_RESET);
        System.out.println("Я хочу умножить на - ");
        multiplicationTable(scanner.nextByte()); // 7

        System.out.println("------------------------------------------------------------------------");

        System.out.println(ANSI_RED + "TASK8" + ANSI_RESET);
        int[] oddNumbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19}; // 8
        for (int i = 0; i < oddNumbers.length; i++) {
            if (i < oddNumbers.length - 1) {
                System.out.print(oddNumbers[i] + ", ");
            } else System.out.print(oddNumbers[i]);
        }

        System.out.println("\n------------------------------------------------------------------------");

        System.out.println(ANSI_RED + "TASK9|10" + ANSI_RESET);
        smallestOrBiggestValue(15); //9, 10

        System.out.println("------------------------------------------------------------------------");

        System.out.println(ANSI_RED + "TASK11" + ANSI_RESET);
        int[] array = {4, -5, 0, 6, 8};
        changeLessMore(array); //11

        System.out.println("------------------------------------------------------------------------");

        System.out.println(ANSI_RED + "TASK12" + ANSI_RESET);
        System.out.println(average(array)); //12

        System.out.println("------------------------------------------------------------------------");

        System.out.println(ANSI_RED + "TASK13" + ANSI_RESET);
        board(); //13

    }

    public static void oddNumbers(int breakNumber) {
        System.out.println(ANSI_RED + "TASK1|2|3|4" + ANSI_RESET);

        System.out.print("Odd Numbers with 'For'");
        for (int i = 0; i <= breakNumber; i++) {
            if (i % 2 != 0) System.out.printf("%3d", i);
        }

        int count = 0;
        System.out.print("\nOdd Numbers with 'while'");
        while (count <= breakNumber) {
            if (count % 2 != 0) System.out.printf("%3d", count);
            count++;
        }

        count = 0;
        System.out.print("\nOdd Numbers with 'Do While'");
        do {
            if (count % 2 != 0) System.out.printf("%3d", count);
            count++;
        } while (count <= breakNumber);
    }

    public static void factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorial with 'For' " + factorial);

        factorial = 1;
        int count = 1;
        while (count <= n) {
            factorial *= count;
            count++;
        }
        System.out.println("Factorial with 'while' " + factorial);

        factorial = 1;
        count = 1;
        do {
            factorial *= count;
            count++;
        } while (count <= n);
        System.out.println("Factorial with 'do while' " + factorial);
    }

    public static void multiplicationTable(int x) {
        for (int i = 1; i <= 10; i++) System.out.println(i + " x " + x + " = " + (i * x));
    }

    public static void smallestOrBiggestValue(int sizeArray) {

        int[] array = new int[sizeArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10) + 1;
        }

        int lessNum = array[0]; // сохраняем первый элемент как саммый маленький и начинаем проверку со второго
        int countSmallest = 1; // счеткчик для удобства, если больше 1 наименьшего числа
        int biggerNum = array[0];
        int countBiggest = 1;

        for (int i = 1; i < array.length; i++) {
            if (lessNum > array[i]) {
                lessNum = array[i];
                countSmallest = 1;
            } else if (lessNum == array[i]) countSmallest++;
            if (biggerNum < array[i]) {
                biggerNum = array[i];
                countBiggest = 1;
            } else if (biggerNum == array[i]) countBiggest++;
        }

        System.out.print("\nнаименьшее число ");
        for (int i = 0; i < countSmallest; i++) {
            System.out.print(lessNum + " ");
        }
        System.out.print("\nнаибольшее число ");
        for (int i = 0; i < countBiggest; i++) {
            System.out.print(biggerNum + " ");
        }

        System.out.println(" >>>" + Arrays.toString(array) + "<<<");
    }

    public static void changeLessMore(int[] array) { //решил сделать такую реализацию, что бы можно было забросить любй массив

        int lessNum = array[0];
        int moreNum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (lessNum > array[i]) {
                lessNum = array[i];
            } else if (moreNum < array[i]) {
                moreNum = array[i];
            }
        }
        System.out.println("Original >>> " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) { // заменяем все наименьше на наибольшие
            if (array[i] == lessNum) {
                array[i] = moreNum;
            } else if (array[i] == moreNum) array[i] = lessNum;
        }
        System.out.println("Modified >>>> " + Arrays.toString(array));
    }

    public static double average(int[] array) {
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static void board() {
        String white = ANSI_WHITE + "∎" + ANSI_RESET;
        String black = ANSI_BLACK + "∎" + ANSI_RESET;

        String[][] chessBoard = new String[8][8];

        for (int i = 0; i < chessBoard.length; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < chessBoard[0].length; j = j + 2) {
                    chessBoard[i][j] = white;
                    chessBoard[i][j - 1] = black;
                }
            } else {
                for (int j = 1; j < chessBoard[0].length; j = j + 2) {
                    chessBoard[i][j] = black;
                    chessBoard[i][j - 1] = white;
                }
            }
        }

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.print("\n");
        }
    }
}
