package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v135.audits.model.SRIMessageSignatureError;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

import static config.Configuration.DOWNLOAD_PATH;

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
                Map<String,Object> prefs = new HashMap<>();
                //
                prefs.put("download.default_directory", DOWNLOAD_PATH);
                prefs.put("download.prompt_for_download", false);
                prefs.put("safebrowsing.enabled", true);
                //
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--Start-maximized");
                driver = new ChromeDriver(options);
                break;
        }
        DriverManager.setDriver(driver);
        return driver;
    }
}
