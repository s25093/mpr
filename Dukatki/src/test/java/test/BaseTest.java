package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import po.NavigationBar;

public class BaseTest {

    protected WebDriver webDriver;

    @Before
    public void loginToShop() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.dukatki.pl");

        NavigationBar navigationBar = new NavigationBar(webDriver);
        navigationBar.openLoginPage()
                .successfulLogin("ayklortitwsycxfamq@tmmcv.com",
                        "123abc");
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
