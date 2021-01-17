package com.lesson17.resorce;

import java.util.Scanner;

public class Game {

    public static String nameFirstPlayer;
    public static String nameSecondPlayer;
    public static int victoriesP1 = 0;
    public static int victoriesP2 = 0;

    private String[][] drawRes = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
    private String winner;

    public Game(int secondPlayer, String nameP2) {
        nameSecondPlayer = nameP2;
        choose(move(), secondPlayer);
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
                            drawRes[j][k] += Figure.rock()[j][k];
                        }
                    }
                    break;
                case 1:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += Figure.scissors()[j][k];
                        }
                    }
                    break;
                case 2:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += Figure.paper()[j][k];
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

        chooseWinner(firstPlayer, secondPlayer);
        Logging.gameResLog(winner);
    }

    private int move () {
        Scanner scanner = new Scanner(System.in);
        int move;
        System.out.println("Сделайте выбор: \n" +
                "  0 - камень | 1 - ножници | 2 - бумага | 3 - выйти");

        while (true) {
            if (scanner.hasNextInt()) {
                move = scanner.nextInt();
                if (move < 3 && move >= 0) {
                    break;
                } else if (move == 3) {
                    Logging.loadingGameLog();
                    System.exit(0);
                } else {
                    System.out.println("0 - камень | 1 - ножници | 2 - бумага | 3 - выйти");
                }
            } else {
                System.out.println("0 - камень | 1 - ножници | 2 - бумага | 3 - выйти");
                scanner.next();
            }
        }
        return move;
    }

    private void chooseWinner(int firstPlayer, int secondPlayer) {
        int[][] resultsMatrix = {
                {3, 1, 2},
                {2, 3, 1},
                {1, 2, 3}
        };

        int winnerCode = resultsMatrix[firstPlayer][secondPlayer];

        if (winnerCode == 3) {
            winner = "Ничья";
            victoriesP1++;
            victoriesP2++;
        } else if (winnerCode == 1) {
            winner = "Победил: " + nameFirstPlayer;
            victoriesP1++;
        } else {
            winner = "Победил: " + nameSecondPlayer;
            victoriesP2++;
        }
    }
}
