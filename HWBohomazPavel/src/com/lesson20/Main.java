package com.lesson20;

import com.lesson20.service.ATM;
import com.lesson20.service.ThreadATM;

import java.util.ArrayList;

public class Main {

    public static ArrayList<ThreadATM> atmArrayList = new ArrayList<>();

    public static ATM atm = new ATM.ATMBuilder()
            .setFullName("Ktoto Ktotov")
            .setAmount(19_000).build();

    public static void main(String[] args) {
        animation();
        System.out.println(" ^\n"
                + " |\n"
                + "Тыпу банкомат");

        System.out.println("                     Start statistics ");
        atm.display();

        for (int i = 0; i < 6; i++) {
            atmArrayList.add(new ThreadATM(atm));
        }
        atmArrayList.forEach(Thread::start);
        try {
            for (ThreadATM threadATM : atmArrayList) {
                threadATM.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("                     Final statistics ");
        atm.display();
    }

    private static void animation() {
        String[][] pos1 = {
                {"___", " ", " ", " ", " 0"},
                {"|-|", " ", " ", " ", " |"},
                {"| |", " ", " ", " ", " |"}
        };
        String[][] pos2 = {
                {"___", " ", " ", " ", " 0"},
                {"|-|", " ", " ", " ", " |"},
                {"| |", " ", " ", " ", "/|"}
        };
        String[][] pos3 = {
                {"___", " 0"},
                {"|-|", "~|"},
                {"| |", " |"}
        };
        boolean p1 = true;
        boolean p2 = false;

        for (int i = 0; i < 7; i++) {

            if (p1) {
                for (int j = 0; j < pos1.length; j++) {
                    for (int k = 0; k < pos1[j].length; k++) {
                        System.out.print(pos1[j][k]);
                    }
                    System.out.println();
                }
                for (int j = 0; j < pos1.length; j++) {
                    for (int k = 0; k < pos1[j].length; k++) {
                        if (pos1[j][k].equals(" ")) {
                            pos1[j][k] = pos1[j][k] = "";
                            break;
                        }
                    }
                }
                p1 = false;
                p2 = true;
            } else if (p2) {
                for (int j = 0; j < pos2.length; j++) {
                    for (int k = 0; k < pos2[j].length; k++) {
                        System.out.print(pos2[j][k]);
                    }
                    System.out.println();
                }
                for (int j = 0; j < pos2.length; j++) {
                    for (int k = 0; k < pos2[j].length; k++) {
                        if (pos2[j][k].equals(" ")) {
                            pos2[j][k] = pos2[j][k] = "";
                            break;
                        }
                    }
                }
                p2 = false;
                p1 = true;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < pos3.length; j++) {
            for (int k = 0; k < pos3[j].length; k++) {
                System.out.print(pos3[j][k]);
            }
            System.out.println();
        }
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
