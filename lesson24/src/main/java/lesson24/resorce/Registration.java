package lesson24.resorce;

import lesson24.Main;

import java.util.Scanner;

public class Registration {

    private final static Scanner scanner = new Scanner(System.in);

    public static void regPlayer() {
        Main.loggerCon.info("Укажите ваше Имя");
        Game.nameFirstPlayer = scanner.nextLine();
    }

    public static int numberOfGame() {
        int countGame;
        Main.loggerCon.info("Сколько игр будет?");
        while (true) {
            if (scanner.hasNextInt()) {
                countGame = scanner.nextInt();
                break;
            } else {
                Main.loggerCon.info("Укажите кол-во игр!");
                scanner.next();
            }
        }
        return countGame;
    }
}
