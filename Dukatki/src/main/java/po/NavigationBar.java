package po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NavigationBar extends BasePage{
    @FindBy(xpath = "//button[contains(text(), 'Szukaj')]")
    private WebElement searchBtn;

    @FindBy(partialLinkText = "Zaloguj")
    private WebElement loginBtn;

    @FindBy(partialLinkText = "Twoje konto")
    private WebElement userAccBtn;

    @FindBy(id = "menu_search_text")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@href=" + '"' + "https://dukatki.pl/basketedit.php?mode=1" + '"' + ']')
    private WebElement cartBtn;

    @FindBy(xpath = "//a[@href=" + '"' + "https://dukatki.pl/login.php?operation=logout" + '"' + ']')
    private WebElement logoutBtn;

    @FindBy(id = "menu_search")
    private WebElement searchIconBtn;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }

    public LoginPage openLoginPage(){
        loginBtn.click();
        return new LoginPage(driver);
    }

    public UserAccountPage openUserAccountPage(){
        userAccBtn.click();
        return new UserAccountPage(driver);
    }

    public LoginPage logout() {
        logoutBtn.click();
        return new LoginPage(driver);
    }

    public String getCartStatus() {
        cartBtn.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage.getCartEmptyMessage();
    }

    public List<PageObject> search(String query) {
        searchIconBtn.click();
        searchIconBtn.sendKeys(query);
        searchIconBtn.sendKeys(Keys.ENTER);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<WebElement> elements = searchResultsPage.getPageObjects();
        return searchResultsPage;
    }
}
