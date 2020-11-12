package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class IssuesPage extends BasePage {

    public IssuesPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private By newIssuesButton = By.xpath("//a[@class = 'btn btn-primary']");

    public void pressToCreateNewIssue(){

    }

}
