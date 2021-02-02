package lesson24.resorce;

import java.util.Scanner;

public class Registration {

    private final static Scanner scanner = new Scanner(System.in);

    public static void regPlayer() {
        System.out.println("Укажите ваше Имя");
        Game.nameFirstPlayer = scanner.nextLine();
    }

    public static int numberOfGame() {
        int countGame;
        System.out.println("Сколько игр будет?");
        while (true) {
            if (scanner.hasNextInt()) {
                countGame = scanner.nextInt();
                break;
            } else {
                System.out.println("Укажите кол-во игр!");
                scanner.next();
            }
        }
        return countGame;
    }
}
