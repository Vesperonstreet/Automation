package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final static String TITLE = "Домашняя страница";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }
}
