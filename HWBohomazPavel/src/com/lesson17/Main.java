package com.lesson17;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static final String SAVE_DIRECTORY = "D:\\Паша\\Junior\\JavaElementary\\HW_BohomazPavel\\HWBohomazPavel\\src\\com\\lesson17\\save.txt";

    public static int victoriesP1 = 0;
    public static int victoriesP2 = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите ваше Имя");
        String name = scanner.nextLine();
        System.out.println("Сколько игр будет?");
        int countGame;
        while (true) {
            if (scanner.hasNextInt()) {
                countGame = scanner.nextInt();
                break;
            } else {
                System.out.println("Укажите кол-во игр!");
                scanner.next();
            }
        }

        try {
            while (countGame != 0) {
                System.out.println("Сделайте выбор: \n" +
                        "  0 - камень | 1 - ножници | 2 - бумага | 3 - выйти");
                int move;
                while (true) {
                    if (scanner.hasNextInt()) {
                        move = scanner.nextInt();
                        if (move < 3 && move >= 0) {
                            break;
                        } else if (move == 3) {
                            try (FileWriter save = new FileWriter(SAVE_DIRECTORY, true)) { // т.к если прибить приложение, то не сохраняет результат сессии
                                save.write(getResultSession(name, "Comp"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.exit(0);
                        } else {
                            System.out.println("0 - камень | 1 - ножници | 2 - бумага | 3 - выйти");
                        }
                    } else {
                        System.out.println("0 - камень | 1 - ножници | 2 - бумага | 3 - выйти");
                        scanner.next();
                    }
                }
                Game game = new Game(move, (int) (Math.random() * 3), name, "Comp");
                System.out.println(game);
                countGame--;
            }
        } finally {
            try (FileWriter save = new FileWriter(SAVE_DIRECTORY, true)) {
                save.write(getResultSession(name, "Comp"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getResultSession(String nameFirstPlayer, String nameSecondPlayer) {
        if (victoriesP1 != 0 || victoriesP2 != 0) {
            return "                        END OF SESSION\n            " +
                    nameFirstPlayer + " - " + victoriesP1 + " victories | " + nameSecondPlayer + " - " + victoriesP2 + " victories\n"
                    + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
        } else return "";
    }
}

class Game {

    private String[][] drawRes = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
    private String winner;

    private String nameFirstPlayer;
    private String nameSecondPlayer;

    public Game(int firstPlayer, int secondPlayer, String nameF1, String nameF2) {
        this.nameFirstPlayer = nameF1;
        this.nameSecondPlayer = nameF2;
        choose(firstPlayer, secondPlayer);
    }

    @Override
    public String toString() {
        for (int i = 0; i < drawRes.length; i++) {
            for (int j = 0; j < drawRes[i].length; j++) {
                System.out.print(drawRes[i][j]);
            }
            System.out.println();
        }
        return "                       " + nameFirstPlayer + "                                                 " + nameSecondPlayer +
                "\n " + winner;
    }

    private void choose(int firstPlayer, int secondPlayer) {
        int[] array = {firstPlayer, 999, secondPlayer}; // 999 что, бы попал в дэфолт
        for (int a : array) {
            switch (a) {
                case 0:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += rock()[j][k];
                        }
                    }
                    break;
                case 1:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += scissors()[j][k];
                        }
                    }
                    break;
                case 2:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += paper()[j][k];
                        }
                    }
                    break;
                default:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += "___|___";
                        }
                    }
            }
        }

        if (firstPlayer == secondPlayer) {
            winner = "Ничья";
            Main.victoriesP1++;
            Main.victoriesP2++;
        } else if (firstPlayer == 0 && secondPlayer == 1 || firstPlayer == 1 && secondPlayer == 2 || firstPlayer == 2 && secondPlayer == 0) {
            winner = "Победил: " + nameFirstPlayer;
            Main.victoriesP1++;
        } else {
            winner = "Победил: " + nameSecondPlayer;
            Main.victoriesP2++;
        }

        Date today = new Date();
        try (FileWriter save = new FileWriter(Main.SAVE_DIRECTORY, true)) {
            save.write("--------------------------------------------------------------\n"
                    + "               " + today + "\n"
                    + "                       " + nameFirstPlayer + " VS " + nameSecondPlayer + "\n"
                    + "                       " + winner + "\n"
                    + "--------------------------------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[][] rock() {
        String[][] rock = {
                {"__________________________________________________"},
                {"__________________________11111___________________"},
                {"________________________0001_11001________________"},
                {"_________________11111101________100______________"},
                {"_______________1001_111____________10_____________"},
                {"______________10_____________________0____________"},
                {"__________11110_______________________01__________"},
                {"________001______________1_____________01_________"},
                {"_______01________________11____________001________"},
                {"____1001__________________01___________0010_______"},
                {"__101____________1_________00__________101_0______"},
                {"__0______________11_________00_________100_10_____"},
                {"__0______1________11_________001______1000__01____"},
                {"__0_______1________11________1000011000000__00____"},
                {"__10______11________10_______100000000000___00____"},
                {"___01______11________001_____0000000001____101____"},
                {"____0_______00________00001000000_________001_____"},
                {"____10_______00_______00000000000_______0001______"},
                {"_____101_____1000011000000000000001___1000________"},
                {"_______101__100000000001___11100000000001_________"},
                {"_________10000001_______________1000001___________"},
                {"__________________________________________________"}
        };
        return rock;
    }

    private String[][] paper() {
        String[][] paper = {
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"____0000000000000000000000000000000000000_________"},
                {"____0000000000000000000000000000000000000_________"},
                {"_____0000000000000000000000000000000000000________"},
                {"_____0000000000000000000000000000000000000________"},
                {"______0000000000000000000000000000000000000_______"},
                {"______0000000000000000000000000000000000000_______"},
                {"_______0000000000000000000000000000000000000______"},
                {"_______0000000000000000000000000000000000000______"},
                {"________0000000000000000000000000000000000000_____"},
                {"________0000000000000000000000000000000000000_____"},
                {"_________0000000000000000000000000000000000000____"},
                {"_________0000000000000000000000000000000000000____"},
                {"__________0000000000000000000000000000000000000___"},
                {"__________0000000000000000000000000000000000000___"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"}
        };
        return paper;
    }

    private String[][] scissors() {
        String[][] scissors = {
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"_________________________________111000000000001__"},
                {"________________100000000000010111____________101_"},
                {"00001________0001_______________________00000001__"},
                {"00000001110001___________________1000000__________"},
                {"00001__000__________________10111_______00000001__"},
                {"00001__00___________101_______1000111_________101_"},
                {"00001__00____________10000001____111000000000001__"},
                {"00001__00_____________001___1000000_0011111111____"},
                {"00001__00_____________101_________00______________"},
                {"00001__00____________01_10011_____101_____________"},
                {"00001__00___________10011__10000001_______________"},
                {"00001__00__________00__1000111111_________________"},
                {"00001__0001________11011__111100__________________"},
                {"000000011100000______1110000011___________________"},
                {"00001_________1000000000__________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"},
                {"__________________________________________________"}
        };
        return scissors;
    }
}