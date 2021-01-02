package com.lesson15_16;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int num = scanner.nextInt();
        char[] numbers = String.valueOf(num).toCharArray();

        String[][] drawNumber = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},{""}};
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
        }
        return null;
    }

    private static String[][] drawZero() {
        String[][] zero = {
                {" ❄❄❄❄❄❄  "},
                {"❄        ❄ "},
                {"❄ ❄❄❄❄ ❄ "},
                {"❄ ❄   ❄ ❄ "},
                {"❄ ❄   ❄ ❄ "},
                {"❄ ❄   ❄ ❄ "},
                {"❄ ❄❄❄❄ ❄ "},
                {"❄        ❄ "},
                {" ❄❄❄❄❄❄  "}};
        return zero;
    }
    private static String[][] drawOne() {
        String el = "\uD83C\uDF84"; // для удобства
        String[][] one = {
                {"ᅠ   " + el + el + " "},
                {"   "+el+el+el+" "},
                {"  "+el+" "+el+el+" "},
                {" "+el+"  "+el+el+" "},
                {el+"   "+el+el+" "},
                {"ᅠ   "+el+el+" "},
                {"ᅠ   "+el+el+" "},
                {"ᅠ   "+el+el+" "},
                {"ᅠ   "+el+el+" "}
        };
        return one;
    }
    private static String[][] drawTwo() {
        String[][] two = {
                {"ᅠ❄❄❄❄ "},
                {"❄ᅠ   ❄ "},
                {"❄ᅠ   ❄ "},
                {"ᅠᅠ   ❄ "},
                {"ᅠᅠ  ❄  "},
                {"ᅠᅠ❄    "},
                {"ᅠ❄   ᅠ "},
                {"❄ᅠ   ᅠ "},
                {"❄❄❄❄❄ "}
        };
        return two;
    }
    private static String[][] drawThree() {
        String el = "\uD83C\uDF84";
        String[][] three = {
                {el+el+el+el+"ᅠᅠ "},
                {"ᅠᅠᅠᅠ"+el+"ᅠ "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {"ᅠᅠᅠᅠ"+el+"ᅠ "},
                {"ᅠ"+el+el+el+"ᅠᅠ "},
                {"ᅠᅠᅠᅠ"+el+"ᅠ "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {"ᅠᅠᅠᅠ"+el+"ᅠ "},
                {el+el+el+el+"ᅠᅠ "}
        };
        return three;
    }
    private static String[][] drawFour() {
        String[][] four = {
                {"ᅠᅠᅠᅠ ❄ "},
                {"ᅠᅠᅠ❄ ❄ "},
                {"ᅠᅠ❄ ᅠ❄ "},
                {"ᅠ❄ᅠ ᅠ❄ "},
                {"❄❄❄❄❄❄ "},
                {"ᅠᅠᅠᅠ ❄ "},
                {"ᅠᅠᅠᅠ ❄ "},
                {"ᅠᅠᅠᅠ ❄ "},
                {"ᅠᅠᅠᅠ ❄ "}
        };
        return four;
    }
    private static String[][] drawFive() {
        String el = "\uD83C\uDF84";
        String[][] five = {
                {el+el+el+el+el+el+" "},
                {el+"ᅠᅠᅠᅠᅠ "},
                {el+el+el+el+el+"ᅠ "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {el+el+el+el+el+"ᅠ "},

        };
        return five;
    }
    private static String[][] drawSix() {
        String el = "\uD83C\uDF84";
        String[][] six = {
                {"ᅠ"+el+el+el+el+el+" "},
                {el+"ᅠᅠᅠᅠᅠ "},
                {el+"ᅠᅠᅠᅠᅠ "},
                {el+el+el+el+el+el+" "},
                {el+"ᅠᅠᅠᅠ"+el+" "},
                {el+"ᅠ"+el+el+"ᅠ"+el+" "},
                {el+"ᅠ"+el+el+"ᅠ"+el+" "},
                {el+"ᅠ"+"ᅠᅠᅠ"+el+" "},
                {el+el+el+el+el+el+" "}
        };
        return six;
    }
    private static String[][] drawSeven() {
        String el = "\uD83C\uDF84";
        String[][] seven = {
                {"ᅠ❄❄❄❄❄❄❄ "},
                {" ᅠ       ❄  "},
                {" ᅠ     ❄    "},
                {" ᅠ   ❄      "},
                {" ᅠ   ❄      "},
                {" ᅠ   ❄      "},
                {" ᅠ   ❄      "},
                {" ᅠ   ❄      "},
                {" ᅠ   ❄      "},
        };
        return seven;
    }
    private static String[][] drawEight() {
        String[][] eight = {
                {"ᅠ❄❄❄❄❄❄ᅠ "},
                {"❄ᅠ      ᅠ❄ "},
                {"❄ᅠ      ᅠ❄ "},
                {"❄ᅠ      ᅠ❄ "},
                {"ᅠ❄❄❄❄❄❄ᅠ "},
                {"❄ᅠ      ᅠ❄ "},
                {"❄ᅠ      ᅠ❄ "},
                {"❄ᅠ      ᅠ❄ "},
                {"ᅠ❄❄❄❄❄❄ᅠ "}
        };
        return eight;
    }
    private static String[][] drawNine() {
        String el = "\uD83C\uDF84";
        String[][] nine = {
                {"ᅠ"+el+el+el+el+"ᅠ "},
                {el+"ᅠᅠᅠᅠ"+el+" "},
                {el+"ᅠ"+el+el+"ᅠ"+el+" "},
                {el+"ᅠ"+el+el+"ᅠ"+el+" "},
                {el+"ᅠ"+"ᅠᅠᅠ"+el+" "},
                {"ᅠ"+el+el+el+el+el+" "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {"ᅠᅠᅠᅠᅠ"+el+" "},
                {el+el+el+el+el+"ᅠ "}
        };
        return nine;
    }
}

