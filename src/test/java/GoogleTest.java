import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Before
    public void loadGoogle() {
        driver.get("http://www.google.com");
    }

    @Test
    public void testGoogleSearch() {
        WebElement searchInputField = driver.findElement(By.name("q"));
        searchInputField.sendKeys("Selenium");
        searchInputField.submit();
        assertEquals("Selenium - Пошук Google", driver.getTitle());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}