package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement singInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void checkAuthFields(){
        Assert.assertTrue("Поле Логин видимо", loginField.isDisplayed());
        Assert.assertTrue("Поле Пароль видимо", passwordField.isDisplayed());
        Assert.assertTrue("Кнопка Войти видима", singInButton.isDisplayed());

    }

}
