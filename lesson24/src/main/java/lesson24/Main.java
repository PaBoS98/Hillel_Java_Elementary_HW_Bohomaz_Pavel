package lesson24;

import lesson24.resorce.Game;
import lesson24.resorce.Logging;
import lesson24.resorce.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystems;

public class Main {

    public static final Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    public static final Logger loggerInfo = LoggerFactory.getLogger("logger.info");
    public static final Logger resultsInfo = LoggerFactory.getLogger("results.info");
    public static final Logger loggerWarn = LoggerFactory.getLogger("logger.warn");
    public static final Logger loggerError = LoggerFactory.getLogger("logger.error");
    public static final Logger loggerCon = LoggerFactory.getLogger("logger.stdout");

    public static int count;
    public static int countGame;
    public static int gameId;

    public static final String WORK_DIRECTORY = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath().toString() + "\\lesson24\\src\\main\\java\\lesson24\\save.txt";

    public static void main(String[] args){
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