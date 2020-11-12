package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private final static String Title = "Osnovnay avtorisatsii";

    public MainPage(WebDriver driver) {
        super(driver, Title);
    }

    private By successTitle = By.xpath("//h2[@class = 'shelf-title']");

    public void validateLogin(){
        log.info("Proverka uspeshnoi avtorizatsii");
        Assert.assertTrue(driver.findElement(successTitle).isDisplayed());
        Assert.assertEquals("Soobshchenie izmenino",
                "Learn Git and GitHub without any code!",
                driver.findElement(successTitle).getText());
        log.info("Yspeshno!");
    }

}
