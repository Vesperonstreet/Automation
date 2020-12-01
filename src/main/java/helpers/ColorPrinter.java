package helpers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public static void printTabsNamesWithDifferentColors(List<WebElement> tabList) {
        List<String> colorList = new ArrayList<>();
        colorList.add(RED);
        colorList.add(GREEN);
        colorList.add(YELLOW);
        colorList.add(BLUE);
        colorList.add(PURPLE);
        colorList.add(CYAN);
        colorList.add(RED);
        colorList.add(GREEN);
        colorList.add(YELLOW);

        for (int i = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i) + tabList.get(i).getText());

        }
    }

}
