import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiracleSaladTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.miraclesalad.com/webtools/timesheet.php");
    }

    @Before
    public void clear(){
        driver.findElement(By.xpath("//p[contains(.,'Consent')]")).click();
        driver.findElement(By.id("calc-hours-clear")).click();
    }

    @Test
    public void timeDifferenceTest() throws InterruptedException {
        String actual = calculateTimeDifference("12:37", "14:13");
        String expected = "1:36";
        Assert.assertEquals(expected, actual);
    }

    private String calculateTimeDifference(String start, String end) throws InterruptedException {
        driver.findElement(By.id("c-s-1")).sendKeys(start);
        driver.findElement(By.id("c-e-1")).sendKeys(end);
        driver.findElement(By.id("calc-hours")).click();
        Thread.sleep(1000);
        return driver.findElement(By.id("calc-hours-total")).getText();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
