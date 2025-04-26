package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;



    private static final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement findElement(By locator) {
        waitForElementToBePresent(locator);
        return driver.findElement(locator);

    }

    public void click(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void submit(By locator)
    {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys("text");
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
    public void navigate(String url)
    {
        driver.get(url);
    }
    public void waitForElementToBeClickable(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
