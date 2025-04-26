package tests;

import config.BrowserType;
import config.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        driver.get("https://www.qualitystream-practice.com/");
        driver.manage().window().maximize();

    }
    @AfterEach
    void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }
}
