package com.lesson2;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double average;

        // 1. Arithmetic mean of two numbers
        double firstNumber;
        double secondNumber;

        while (true) {
            System.out.println("Write first number");

            if (scanner.hasNextDouble()) {
                firstNumber = scanner.nextDouble();

                while (true) {
                    System.out.println("Write second number");

                    if (scanner.hasNextDouble()) {
                        secondNumber = scanner.nextDouble();
                        break;
                    } else {
                        scanner.next();
                        continue;
                    }
                }
                break;
            } else {
                scanner.next();
                continue;
            }
        }
        average = (firstNumber + secondNumber) / 2;
        System.out.println("Arithmetic mean of two numbers - " + firstNumber + " and " + secondNumber + " = " + average);

        // 2. Arithmetic mean of any number of numbers
        average = 0;

        ArrayList<Double> numbers = new ArrayList<>();

        do {
            System.out.println("\n" + "Write number (if want break, write any symbols)");
            if (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            } else {
                break;
            }
        } while (true);

        for (double num : numbers) {
            average += num;
        }
        if (numbers.isEmpty()) {
            System.out.println("You don't write anything");
        } else {
            average = average / numbers.size();
            System.out.println("Arithmetic mean = " + average);
        }

        // 3. Contribution
        System.out.println("Введите сумму денежного вклада");
        long money = scanner.nextLong();
        System.out.println("Вы внесли - " + money + " UAH");
        System.out.println("Введите под какой годовой процент");
        float percent = scanner.nextFloat();
        System.out.println("Ежегодный полцент будет состовлять - " + percent + "%");
        percent = percent / 100;
        System.out.println("Укажите длительность вклада");
        byte years = scanner.nextByte();
        System.out.println("Вы указали - " + years);

        double moneyForYear;
        for (int i = 0; i < years; i++) {
            moneyForYear = money * percent;
            money += moneyForYear;
            System.out.println("\nЗа " + (i + 1) + " год вы получили - " + moneyForYear + " UAH" + "\nна данный момент ваш вклад состовляет - " + money + " UAH");
        }
    }
}
