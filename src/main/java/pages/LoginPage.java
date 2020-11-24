package pages;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.ColorPrinter.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends BasePage {

    private final static String Title = "Страница авторизации";

    private final By loginField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");

    private final By errorMessage = By.xpath("//div[@id = 'login']/p");

    private final By message = By.xpath("//div[contains(@class, 'container-lg px-')]");


    public LoginPage(WebDriver driver) {
        super(driver, Title);
    }


    public LoginPage LoginNegative(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public MainPage login(String login, String password){
        log.info("Авторизация в приложение");

        webDriverWait_10.until(elementToBeClickable(loginField)); //wait until element will be clickable
/*       Второй варинат использования ниже
        webDriverWait_10.until(ExpectedConditions.elementToBeClickable(loginField)); //
*/
        driver.findElement(loginField).sendKeys(login);
        printMessageInYellow("login введен", log);
        driver.findElement(passwordField).sendKeys(password);
        printMessageInYellow("password введен", log);
        driver.findElement(signInButton).click();
        printMessageInYellow("Кнопка Sign in нажата", log);
        printMessageInGreen("Авторизация успешна", log);
        return new MainPage(driver);
    }


    public LoginPage validateErrorMessage(String message, boolean isAdmin){
        Assert.assertEquals(message, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPage validateErrorMessage(String message){
        Assert.assertEquals(message, driver.findElement(this.message).getText());
        return this;
    }


    public LoginPage returnToLoginPage(){
        driver.navigate().back();
        return new LoginPage(driver);
    }


    public LoginPage checkAuthFields(){
        printColorMessage("Валидация", log, Level.INFO);
        Assert.assertTrue("Поле Логин видимо", driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("Поле Пароль видимо", driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("Кнопка Войти видима", driver.findElement(signInButton).isDisplayed());
        printColorMessage("Поля видны", log, Level.INFO);
        return this;
    }
}