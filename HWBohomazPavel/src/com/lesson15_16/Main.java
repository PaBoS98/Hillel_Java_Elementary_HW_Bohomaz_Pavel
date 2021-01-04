package com.lesson15_16;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        String num = scanner.nextLine();
        char[] numbers = num.toCharArray();
        drawNumber(numbers);

    }

    public static void drawNumber(char[] numbers) {
        String[][] drawNumber = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        for (int i = 0; i < numbers.length; i++) {
            String[][] current = choose(numbers[i]);
            for (int j = 0; j < current.length; j++) {
                for (int k = 0; k < current[i].length; k++) {
                    drawNumber[j][k] += current[j][k];
                }
            }
        }

        for (int i = 0; i < drawNumber.length; i++) {
            for (int j = 0; j < drawNumber[i].length; j++) {
                System.out.print(drawNumber[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] drawNumber(char o) {
        char[] numbers = String.valueOf(Integer.valueOf(o)).toCharArray();
        String[][] drawNumber = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        for (int i = 0; i < numbers.length; i++) {
            String[][] current = choose(numbers[i]);
            for (int j = 0; j < current.length; j++) {
                for (int k = 0; k < current[i].length; k++) {
                    drawNumber[j][k] += current[j][k];
                }
            }
        }
        return drawNumber;
    }

    private static String[][] choose(char o) {
        switch (o) {
            case '0':
                return drawZero();
            case '1':
                return drawOne();
            case '2':
                return drawTwo();
            case '3':
                return drawThree();
            case '4':
                return drawFour();
            case '5':
                return drawFive();
            case '6':
                return drawSix();
            case '7':
                return drawSeven();
            case '8':
                return drawEight();
            case '9':
                return drawNine();
            default:
//                String[][] skip = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
                return drawNumber(o);
        }
    }

    private static String[][] drawZero() {
        String[][] zero = {
                {"        @@@@@@@         "},
                {"     @@@       @@@      "},
                {"   @@@           @@@    "},
                {"  @@               @@   "},
                {"@@       @@@@@       @@ "},
                {"@@     @@     @@     @@ "},
                {"@@    @@       @@    @@ "},
                {"@@     @@     @@     @@ "},
                {"@@       @@@@@       @@ "},
                {"  @@               @@   "},
                {"   @@@           @@@    "},
                {"     @@@       @@@      "},
                {"        @@@@@@@         "}
        };
        return zero;
    }

    private static String[][] drawOne() {
        String el = "\uD83C\uDF84"; // для удобства
        String[][] one = {
                {"      @@@@@       "},
                {"     @@  @@       "},
                {"    @@   @@       "},
                {"   @@    @@       "},
                {"  @@     @@       "},
                {" @@      @@       "},
                {"@@       @@       "},
                {"         @@       "},
                {"         @@       "},
                {"         @@       "},
                {"         @@       "},
                {"       @@@@@@     "},
                {"   @@@@@@@@@@@@@@ "}
        };
        return one;
    }

    private static String[][] drawTwo() {
        String[][] two = {
                {"    @@@@@@@@@@    "},
                {"   @@        @@   "},
                {" @@          @@   "},
                {"@@            @@  "},
                {"            @@    "},
                {"           @@     "},
                {"         @@       "},
                {"        @@        "},
                {"      @@          "},
                {"     @@           "},
                {"   @@             "},
                {" @@@              "},
                {"@@@@@@@@@@@@@@@@@ "}
        };
        return two;
    }

    private static String[][] drawThree() {
        String[][] three = {
                {"@@@@@@@@@@@@     "},
                {"            @@   "},
                {"             @@  "},
                {"              @@ "},
                {"             @@  "},
                {"      @@@@@@@@   "},
                {"    @@@@@@@@     "},
                {"      @@@@@@@@   "},
                {"             @@  "},
                {"              @@ "},
                {"             @@  "},
                {"            @@   "},
                {"@@@@@@@@@@@@     "}
        };
        return three;
    }

    private static String[][] drawFour() {
        String[][] four = {
                {"         @@   @@ "},
                {"        @@    @@ "},
                {"      @@      @@ "},
                {"     @@       @@ "},
                {"   @@         @@ "},
                {"  @@          @@ "},
                {"@@            @@ "},
                {"@@@@@@@@@@@@@@@@ "},
                {"              @@ "},
                {"              @@ "},
                {"              @@ "},
                {"              @@ "},
                {"              @@ "}
        };
        return four;
    }

    private static String[][] drawFive() {
        String[][] five = {
                {"@@@@@@@@@@@@@@@@@@@@ "},
                {"@@                   "},
                {"@@                   "},
                {"@@@@@@@@@@@@         "},
                {"           @@@       "},
                {"              @@     "},
                {"               @@    "},
                {"                 @@  "},
                {"                  @@ "},
                {"                 @@  "},
                {"               @@    "},
                {"            @@@      "},
                {"@@@@@@@@@@@@@        "}

        };
        return five;
    }

    private static String[][] drawSix() {
        String[][] six = {
                {"         @@       "},
                {"       @@         "},
                {"      @@          "},
                {"    @@            "},
                {"   @@             "},
                {" @@@@@@@@@@@@@    "},
                {"@@           @@   "},
                {"@@             @@ "},
                {"@@             @@ "},
                {"@@             @@ "},
                {"  @@         @@   "},
                {"   @@       @@    "},
                {"     @@@@@@@      "}
        };
        return six;
    }

    private static String[][] drawSeven() {
        String[][] seven = {
                {"@@@@@@@@@@@@@@@@@ "},
                {"              @@  "},
                {"             @@   "},
                {"            @@    "},
                {"           @@     "},
                {"          @@      "},
                {"        @@        "},
                {"       @@         "},
                {"       @@         "},
                {"       @@         "},
                {"       @@         "},
                {"       @@         "},
                {"       @@         "}
        };
        return seven;
    }

    private static String[][] drawEight() {
        String[][] eight = {
                {"    @@@@@@@@@@@@@     "},
                {"  @@             @@   "},
                {"@@       @@@       @@ "},
                {"@@      @   @      @@ "},
                {"  @@     @@@     @@   "},
                {"   @@           @@    "},
                {"     @@@@@@@@@@@      "},
                {"   @@           @@    "},
                {"  @@     @@@     @@   "},
                {"@@      @   @      @@ "},
                {"@@       @@@       @@ "},
                {"  @@             @@   "},
                {"    @@@@@@@@@@@@@     "}
        };
        return eight;
    }

    private static String[][] drawNine() {
        String[][] nine = {
                {"      @@@@@@@@@       "},
                {"    @@         @@     "},
                {"  @@     @@@     @@   "},
                {"@@     @@   @@     @@ "},
                {"@@     @@   @@     @@ "},
                {"  @@     @@@     @@   "},
                {"    @@         @@     "},
                {"      @@@@@@@@@       "},
                {"            @@        "},
                {"           @@         "},
                {"          @@          "},
                {"         @@           "},
                {"        @@            "}
        };
        return nine;
    }
}

