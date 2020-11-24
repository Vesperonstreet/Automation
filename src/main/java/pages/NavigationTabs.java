package pages;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInGreen;

public class NavigationTabs extends BasePage{

    private final static String TITLE = "Страница со-всеми табами";

    public NavigationTabs(WebDriver driver) {
        super(driver, TITLE);
    }

    protected final By projectLink = By.xpath("//a[@href=\"/Vesperonstreet/Automation\"]");

    protected final By codeTab = By.xpath("//span[contains(text(), 'Code')]");
    protected final By issuesTab = By.xpath("//span[contains(text(), 'Issues')]");
    protected final By pullRequestsTab = By.xpath("//span[contains(text(), 'Pull request')]");
    protected final By actionsTab = By.xpath("//span[@data-content= 'Actions']");
    protected final By projectsTab = By.xpath("//span[contains(text(), 'Projects')]");
    protected final By wikiTab = By.xpath("//span[contains(text(), 'Wiki')]");
    protected final By securityTab = By.xpath("//span[contains(text(), 'Security')]");
    protected final By insightsTab = By.xpath("//span[contains(text(), 'Insights')]");
    protected final By settingsTab = By.xpath("//span[contains(text(), 'Settings')]");

    public NavigationTabs validateTabs(){
        printColorMessage("Проверка отображения всех табов", log, Level.INFO);
        try {
            Assert.assertTrue(driver.findElement(projectLink).isDisplayed());
            driver.findElement(projectLink).click();
            Assert.assertTrue(driver.findElement(codeTab).isDisplayed());
            Assert.assertTrue(driver.findElement(issuesTab).isDisplayed());
            Assert.assertTrue(driver.findElement(pullRequestsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(actionsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(projectsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(wikiTab).isDisplayed());
            Assert.assertTrue(driver.findElement(securityTab).isDisplayed());
            Assert.assertTrue(driver.findElement(insightsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(settingsTab).isDisplayed());
        } catch (NoSuchElementException n){
            Assert.fail("Таб не найден: " + n.getMessage());
        }
        printMessageInGreen("Все табы присутствуют", log);
        return this;
    }
}
