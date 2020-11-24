package pages;

import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.ColorPrinter.printColorMessage;

public class BasePage {

    protected static WebDriver driver;
    protected Logger log;
    private String title;

    protected WebDriverWait webDriverWait_10, webDriverWait_15, webDriverWait_20;

    public BasePage(WebDriver driver, String title){
        this.driver = driver;
        this.title = title;
        this.log = LogManager.getLogger(this.title);
        printColorMessage("Class: " + this.getClass().getName(), log, Level.DEBUG);
        webDriverWait_10 = new WebDriverWait(driver, 10);
        webDriverWait_15 = new WebDriverWait(driver, 15);
        webDriverWait_20 = new WebDriverWait(driver, 20);
    }
}
