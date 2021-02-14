package com.resorce;

import com.Lesson26;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logging {

    private static String gameLog = "";

    public static void gameResLog(String winner) {
        Date today = new Date();
        gameLog += "--------------------------------------------------------------\n"
                + "               " + today + "\n"
                + "                       " + Game.nameFirstPlayer + " VS " + Game.nameSecondPlayer + "\n"
                + "                       " + winner + "\n"
                + "--------------------------------------------------------------\n";

    }

    public static void loadingGameLog() {
        if (Game.victoriesP1 != 0 ||Game. victoriesP2 != 0) {
            gameLog +=  "                        END OF SESSION\n            " +
                    Game.nameFirstPlayer + " - " + Game.victoriesP1 + " victories | " + Game.nameSecondPlayer + " - " + Game.victoriesP2 + " victories\n"
                    + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
        }
        try (FileWriter save = new FileWriter(Lesson26.WORK_DIRECTORY, true)) {
            save.write(gameLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}