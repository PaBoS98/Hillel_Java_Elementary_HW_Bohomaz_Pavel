package com.resorce;

import java.util.Scanner;

import static com.Main.*;

public class Game {

    public static String nameFirstPlayer;
    public static String nameSecondPlayer;
    public static int victoriesP1 = 0;
    public static int victoriesP2 = 0;

    private String[][] drawRes = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
    private String winner;

    public Game(int secondPlayer, String nameP2) throws Exception {
        nameSecondPlayer = nameP2;
        choose(move(), secondPlayer);
    }

    @Override
    public String toString() {
        String res = "\n";
        for (int i = 0; i < drawRes.length; i++) {
            for (int j = 0; j < drawRes[i].length; j++) {
                res += drawRes[i][j];
            }
            res += "\n";
        }
        res += "                       " + nameFirstPlayer + "                                                 " + nameSecondPlayer +
                "\n " + winner;
        return res;
    }

    private void choose(int firstPlayer, int secondPlayer) {
        String moveFirstPlayer = null;
        String moveSecondPlayer = null;
        int[] array = {firstPlayer, 999, secondPlayer};
        for (int a : array) {
            switch (a) {
                case 0:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += Figure.rock()[j][k];
                        }
                    }
                    if (firstPlayer == 0) moveFirstPlayer = "rock";
                    if (secondPlayer == 0) moveSecondPlayer = "rock";
                    break;
                case 1:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += Figure.scissors()[j][k];
                        }
                    }
                    if (firstPlayer == 1) moveFirstPlayer = "scissors";
                    if (secondPlayer == 1) moveSecondPlayer = "scissors";
                    break;
                case 2:
                    for (int j = 0; j < drawRes.length; j++) {
                        for (int k = 0; k < drawRes[firstPlayer].length; k++) {
                            drawRes[j][k] += Figure.paper()[j][k];
                        }
                    }
                    if (firstPlayer == 2) moveFirstPlayer = "paper";
                    if (secondPlayer == 2) moveSecondPlayer = "paper";
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
        loggerInfo.info("ID: " + gameId + "|" + nameFirstPlayer + " choose - " + count + " games, played - "
                + (count - countGame) + " games, left to play - " + countGame);
        loggerInfo.info("ID: " + gameId + "|" + "First player choose - " + moveFirstPlayer + " | second player choose - " + moveSecondPlayer);
        resultsInfo.info("ID: " + gameId + "|" + "Winner - " + winner);

    }

    private int move () throws Exception {
        Scanner scanner = new Scanner(System.in);
        int move = 0;
        System.out.println("Сделайте выбор: \n" +
                "  0 - камень | 1 - ножници | 2 - бумага | 3 - выйти | 4 - throw exception))");

        while (true) {
            if (scanner.hasNextInt()) {
                move = scanner.nextInt();
                if (move < 3 && move >= 0) {
                    break;
                } else if (move == 3) {
                    Logging.loadingGameLog();
                    loggerDebug.debug("ID: " + gameId + "|" + "Player: " + Game.nameFirstPlayer + " left the game!");
                    System.exit(0);
                } else if (move == 4) {
                    int random = (int) (Math.random() * 5);
                    if (random == 1) throw new NullPointerException();
                    else if (random == 2) throw new NumberFormatException();
                    else if (random == 3) throw new RuntimeException();
                    else throw new Exception();
                } else {
                    loggerWarn.warn("ID: " + gameId + "|" + "incorrect input (" + move + ")");
                    System.out.println("0 - камень | 1 - ножници | 2 - бумага | 3 - выйти");
                }
            } else {
                loggerWarn.warn("ID: " + gameId + "|" + "incorrect input (" + scanner + ")");
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