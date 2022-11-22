package test;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import po.NavigationBar;

import java.util.List;

public class LoginTest{

    private static final String USER_NAME = "JAN KOWALSKI";
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dukatki.pl");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void unsuccessfulLoginTest(){
        NavigationBar navigationBar = new NavigationBar(driver);
        List<String> errors = navigationBar.openLoginPage()
                .unsuccessfulLogin("invalidName", "invalidPassword")
                .getErrors();
        List<String> expectedErrors = List.of("Podany login lub hasło nie jest poprawne.");
        Assert.assertEquals(errors, expectedErrors);
    }

    @Test
    public void successfulLoginTest(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.openLoginPage()
                .successfulLogin("zlylbnwmbevksfnmhm@kvhrw.com", "Testujemy2022!");
        String message = navigationBar.openUserAccountPage()
                .getWelcomeMessage();
        Assert.assertTrue(String.format("Expected '%s' to be in '%s'",
                USER_NAME, message), message.contains(USER_NAME));
    }

}
