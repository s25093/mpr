package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BadLoginPage extends BasePage{
    @FindBy(partialLinkText = "Strona logowania")
    private WebElement backToLoginPageBtn;

    @FindBy(xpath = "//div[@id='return_error']//h3")
    private List<WebElement> errorMessageLabels;

    public BadLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(backToLoginPageBtn));
    }

    public List<String> getErrors(){
        List<String> errors = new ArrayList<>();
        for (WebElement errorMessageLabel: errorMessageLabels){
            errors.add(errorMessageLabel.getText());
        }
        return errors;
    }
}
