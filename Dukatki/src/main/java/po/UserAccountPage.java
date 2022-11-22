package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAccountPage extends BasePage{
    @FindBy(xpath = "//div[@class='login_welcome_sub']//span[contains(text(), 'Wyloguj')]/..")
    private WebElement logoutBtn;

    @FindBy(id = "login_welcome")
    private WebElement welcomeMessageLabel;

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
    }

    public String getWelcomeMessage(){
        return welcomeMessageLabel.getText();
    }
}
