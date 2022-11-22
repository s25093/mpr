package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    @FindBy(id = "retbut_basket_empty")
    private WebElement startShoppingBtn;

    @FindBy(xpath = "//strong")
    private WebElement cartText;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(startShoppingBtn));
    }

    public String getCartEmptyMessage() {
        return cartText.getText();
    }
}
