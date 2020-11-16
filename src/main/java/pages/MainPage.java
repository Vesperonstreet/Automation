package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printMessageInYellow;

public class MainPage extends MainMenu{

    private final static String Title = "Основная авторизация";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By successTitle = By.xpath("//h2[@class = 'shelf-title']");

    private final By userButton = By.xpath("//summary[@class='Header-link' and @aria-label='View profile and more']");
    private final By logOutButton = By.xpath("//button[contains(text(), 'Sign out')]");

    public void validateLogin(){
        printMessageInYellow("Проверка успешной авторизации", log);
        Assert.assertTrue(driver.findElement(successTitle).isDisplayed());
        Assert.assertEquals("Сообщение измененно",
                "Learn Git and GitHub without any code!",
                driver.findElement(successTitle).getText());
        printMessageInYellow("Успешно!", log);
    }

    public ProjectPage openOurProject(){
        driver.get("https://github.com/Vesperonstreet/Automation");
        return new ProjectPage(driver);
    }

}