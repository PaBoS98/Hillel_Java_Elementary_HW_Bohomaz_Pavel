package lesson24;

import lesson24.resorce.Game;
import lesson24.resorce.Logging;
import lesson24.resorce.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystems;

public class Main {

    private static final Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    private static final Logger loggerInfo = LoggerFactory.getLogger("logger.info");
    private static final Logger loggerWarn = LoggerFactory.getLogger("logger.warn");
    private static final Logger loggerError = LoggerFactory.getLogger("logger.error");

    public static final String WORK_DIRECTORY = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath().toString() + "\\HW_BohomazPavel\\HWBohomazPavel\\Maven\\src\\main\\java\\com\\lesson24\\save.txt";

    public static void main(String[] args) {

        for (int i = 0; i < 150; i++) {
            loggerDebug.debug("Start " + i + "...");
            int j = (int) (Math.random()*100);
            if (i % 2 == 0) {
                loggerInfo.info("i % 2");
            } else loggerWarn.warn("!!!!!");
        }

//        Registration.regPlayer();
//        int countGame = Registration.numberOfGame();
//
//        try {
//            while (countGame != 0) {
//                Game game = new Game((int) (Math.random() * 3), "Comp");
//                System.out.println(game);
//                countGame--;
//            }
//        } finally {
//            Logging.loadingGameLog();
//        }
    }
}