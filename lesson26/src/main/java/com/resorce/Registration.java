package com.resorce;

import com.Lesson26;

import java.util.Scanner;

import static com.Lesson26.loggerCon;

public class Registration {

    private final static Scanner scanner = new Scanner(System.in);

    public static void regPlayer() {
        loggerCon.debug(Lesson26.resourceBundle.getString("name"));
        Game.nameFirstPlayer = scanner.nextLine();
    }

    public static int numberOfGame() {
        int countGame;
        loggerCon.debug(Lesson26.resourceBundle.getString("game"));
        while (true) {
            if (scanner.hasNextInt()) {
                countGame = scanner.nextInt();
                break;
            } else {
                loggerCon.debug(Lesson26.resourceBundle.getString("countGame"));
                scanner.next();
            }
        }
        return countGame;
    }
}
