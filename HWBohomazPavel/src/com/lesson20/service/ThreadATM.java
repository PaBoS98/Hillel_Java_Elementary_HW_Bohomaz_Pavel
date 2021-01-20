package com.lesson20.service;

import java.util.Scanner;

public class ThreadATM extends Thread {

    private static int count = 0;
    private ATM atm;
    private int id;

    public ThreadATM(ATM atm) {
        this.atm = atm;
        this.id = count;
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int choose = (int) (Math.random() * 10);

            if (choose % 2 == 0) atm.display("Work Thread #" + id, atm.withdrawal((int) (Math.random() * 1000)));
            else {
                new ThreadPause(this); // ставит ждать все остальные потоки
                try {
                    Thread.sleep(1500); // что бы все останавливаемые потоки успели закончить операцию
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atm.display("Work Thread #" + id, atm.put(scan(id)));
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int scan(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thread #" + id + " wait for top-up amounts");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("wrong number!");
            try {
                Thread.sleep(500 * count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return scan(id);
        }
    }
}
