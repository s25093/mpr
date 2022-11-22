package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//button[contains(text(), 'Zaloguj')]")
    private WebElement loginBtn;

    @FindBy(id = "user_login")
    private WebElement loginInput;

    @FindBy(id = "user_pass")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
    }

    public BadLoginPage unsuccessfulLogin(String login, String password){
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new BadLoginPage(driver);
    }

    public MainPage successfulLogin(String login, String password){
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new MainPage(driver);
    }
}
