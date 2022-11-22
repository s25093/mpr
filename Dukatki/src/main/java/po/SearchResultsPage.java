package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[@class='btn show_filters visible-tablet']")
    private WebElement filterBtn;

    @FindBy(xpath = "//div[contains(@class, 'product-wrapper')]")
    private List<WebElement> pageObjects;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(filterBtn));
    }

    public List<WebElement> getPageObjects() {
        return pageObjects;
    }


}
