package helpers;

import org.apache.logging.log4j.Logger;

import static helpers.ConsoleColors.*;

public class ColorPrinter {

    public static void printMessageInYellow(String message){
        System.out.println(BLUE_BACKGROUND + YELLOW + message + RESET);
    }

    public static void printMessageInYellow(String message, Logger logger){
        logger.info(BLUE_BACKGROUND + YELLOW + message + RESET);
    }

    public static void printMessageInGreen(String message){
        System.out.println(BLUE_BACKGROUND + GREEN + message + RESET);
    }

    public static void printMessageInGreen(String message, Logger logger){
        logger.info(BLUE_BACKGROUND + GREEN + message + RESET);
    }

    public static void printColorMessage(String message, Logger logger, Level level){
        switch (level){
            case INFO:
                logger.info(PURPLE + message + RESET);
                break;
            case DEBUG:
                logger.info(BLUE + message + RESET);
                break;
            case ERROR:
                logger.info(RED + message + RESET);
                break;
        }
    }

}
