package pages;

import config.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;



    private static final int TIMEOUT = 10;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public WebElement findElement(By locator) {
        waitForElementToBePresent(locator);
        return driver.findElement(locator);

    }
    public List<WebElement> findElements(By locator) {
        waitForElementToBePresent(locator);
        return driver.findElements(locator);
    }

    public void click(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }
    public void scrollIntoViewAndClick(WebElement element){
        waitForElementToBeClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
        js.executeScript("arguments[0].click()",element);
    }

    //este metodo lo que hace es que sigue cargando el scroll al llegar al final
    public void scrollIntoViewAndClick(By locator){
        waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
        js.executeScript("arguments[0].click()",element);
    }
    public void scrollIntoView(By locator){
        waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
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
    public void waitForElementToBeClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForMewWindow(){
        wait.until((ExpectedCondition<Boolean>)
                d-> d!=null && d.getWindowHandles().size() >1);
    }
    public void waitAlertToBePresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void selectByVisibleText(By locator, String text) {
        WebElement element = findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }
    public void selectByValue(By locator, String value) {
        WebElement element = findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void selectByIndex(By locator, int index) {
        WebElement element = findElement(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    //Metodo que espera que haya mas de un handle
    //intera con todos los manejadores y se dice que
    // si el manejador no es igual al original entonces haga switch
    public void switchToNewWindow(String originalHandle){
        waitForMewWindow();
        Set<String> allWindows = driver.getWindowHandles();
        for(String handle: allWindows){
            System.out.println("handle: "+handle);
            if(!handle.equals(originalHandle)){
                driver.switchTo().window(handle);
            }
        }
    }

    //se crea metodo que espera que haya mas de una ventana abierta



    public void acceptAlert(){
        waitAlertToBePresent();
        Alert alert =driver.switchTo().alert();
        alert.accept();
    }
    public void dismissAlert(){
        waitAlertToBePresent();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();

    }
    public void sendKeysToAlert(String msg){
        waitAlertToBePresent();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(msg);
        alert.accept();

    }
    public String getAlertText(){
        waitAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }


}
