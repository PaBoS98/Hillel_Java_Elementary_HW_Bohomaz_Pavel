package com.lesson17;

import com.lesson17.resorce.Game;
import com.lesson17.resorce.Logging;
import com.lesson17.resorce.Registration;

import java.nio.file.FileSystems;

public class Main {

    public static final String WORK_DIRECTORY = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath().toString() + "\\HW_BohomazPavel\\HWBohomazPavel\\src\\com\\lesson17\\save.txt";

    public static void main(String[] args) {

        Registration.regPlayer();
        int countGame = Registration.numberOfGame();

        try {
            while (countGame != 0) {
                Game game = new Game((int) (Math.random() * 3), "Comp");
                System.out.println(game);
                countGame--;
            }
        } finally {
            Logging.loadingGameLog();
        }
    }
}