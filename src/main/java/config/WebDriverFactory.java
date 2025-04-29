package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver createDriver(BrowserType type)
    {
        WebDriver driver;

        switch (type)
        {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;

            case CHROME:
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--Start-maximized");
                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }
}
