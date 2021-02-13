package com;

import com.resorce.Game;
import com.resorce.Logging;
import com.resorce.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystems;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static final Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    public static final Logger loggerInfo = LoggerFactory.getLogger("logger.info");
    public static final Logger resultsInfo = LoggerFactory.getLogger("results.info");
    public static final Logger loggerWarn = LoggerFactory.getLogger("logger.warn");
    public static final Logger loggerError = LoggerFactory.getLogger("logger.error");

    public static int count;
    public static int countGame;
    public static int gameId;

    public static final String WORK_DIRECTORY = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath().toString() + "\\lesson26\\src\\main\\java\\com\\save.txt";

    public static void main(String[] args){

        Locale locale = new Locale("ru");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.resorce.bundle.text");
        System.out.println(resourceBundle.getString("name"));


        Registration.regPlayer();
        countGame = Registration.numberOfGame();
        count = countGame;
        gameId = (int) (Math.random()* 10000);
        loggerDebug.debug("ID: " + gameId + "|" + "Player: " + Game.nameFirstPlayer + " join to game!");
        try {
            while (countGame != 0) {
                Game game = new Game((int) (Math.random() * 3), "Comp");
                loggerInfo.info(String.valueOf(game));
                countGame--;
            }
        } catch (Exception e) {
            loggerError.error("ID: " + gameId + "|" + e);
        } finally {
            Logging.loadingGameLog();
            loggerDebug.debug("ID: " + gameId + "|" + "Player: " + Game.nameFirstPlayer + " left the game!");
        }
    }
}