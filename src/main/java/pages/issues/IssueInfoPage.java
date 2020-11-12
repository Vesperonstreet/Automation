package pages.issues;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class IssueInfoPage extends BasePage {

    private static final String TITLE = "Страница информации о задаче проекта";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }
}
