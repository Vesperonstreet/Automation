package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    private final static String Title = "Stranica avtorisatsii";

    private final By loginField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");

    private final By errorMessage = By.xpath("//div[@id = 'login']/p");

    private final By message = By.xpath("//div[@class = 'container-lg px-23']");


    public LoginPageObject(WebDriver driver) {
        super(driver, Title);
    }


    public LoginPageObject LoginNegative(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new LoginPageObject(driver);
    }

    public MainPage login(String login, String password){
        log.info("Avtorizatsia v prilojenie");
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        log.info("Avtorizatsia uspeshna");
        return new MainPage(driver);
    }


    public LoginPageObject validateErrorMessage(String message, boolean isAdmin){
        Assert.assertEquals(message, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPageObject validateErrorMessage(String message){
        Assert.assertEquals(message, driver.findElement(this.message).getText());
        return this;
    }


    public LoginPageObject returnToLoginPage(){
        driver.navigate().back();
        return new LoginPageObject(driver);
    }


    public LoginPageObject checkAuthFields(){
        log.info("Validatsia");
        Assert.assertTrue("Поле Логин видимо", this.driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("Поле Пароль видимо", this.driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("Кнопка Войти видима", this.driver.findElement(signInButton).isDisplayed());
       log.info("Polia vidnu");
        return this;
    }
}
