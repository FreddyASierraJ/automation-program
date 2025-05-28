package Clase1;

import com.sun.jdi.request.DuplicateRequestException;
import config.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;

import java.io.File;
import java.time.Duration;

public class WaitJavaScriptExecutor extends BaseTest2{

    By downLoadLink_Locator= By.cssSelector("a[href*='/s/This-is-a-file-to-test-Downloads.txt']");

    By upload_locator = By.id("photo");


    @Test
    void testImplicitWait() {

        //nose recomienda usar Implicit en automatizacion

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean results =driver.findElement(downLoadLink_Locator).isDisplayed();
        Assertions.assertTrue(results,"Download link was note present");

    }

    @Test
    void testExplicitWait() {

        //Este tipo de espera es la que se debe usar
        //es mas optima

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(downLoadLink_Locator));

        Assertions.assertTrue(link.isDisplayed(),"link was not present");
    }

    @Test
    void testFluentWait() {

        Wait<WebDriver> wait= new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofSeconds(5)).
                ignoring(NoSuchElementException.class);

        WebElement link = wait.until(
                driver -> driver.findElement(downLoadLink_Locator)
        );
        Assertions.assertTrue(link.isDisplayed(),"link was not present");
    }

    @Test
    void testLoginWithJExecutor() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.querySelector('a[href=\"/loginpage\"]').click();");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        jse.executeScript("arguments[0].scrollIntoView()",username);
        jse.executeScript("arguments[0].click()",username);

        jse.executeScript("document.getElementsByName('username')[0].value = 'qualitystream'");
        jse.executeScript("document.getElementsByName('password')[0].value = 'testing123'");
        jse.executeScript("document.getElementsByName('login')[0].click();");
        //document.getElementsByName('login')[0].click();

        wait.until(driver -> driver.getCurrentUrl().contains("/formpage"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("/formpage"),"Wrong page");


    }

    @Test
    void testDownload() {

        Utility.clearDownloadFolder(Configuration.DOWNLOAD_PATH);

        File downloadDir = new File(Configuration.DOWNLOAD_PATH);
        File[] previousFiles = downloadDir.listFiles();

        int count;
        if(previousFiles!=null){
            count = previousFiles.length;
        }else {
            count = 0;
        }
        System.out.println("previous count:"+count);
        driver.findElement(downLoadLink_Locator).click();

        boolean fileDownloaded = Utility.waitForNewFile(downloadDir, 60, count); // wait up to 10 seconds

        Assertions.assertTrue(fileDownloaded, "File was not downloaded within the timeout");

    }

    @Test
    void testUploadFile() {
        String picturePath =(System.getProperty("user.dir")+"/src/main/resources/files/Profile Placeholder.png");

        File file = new File(picturePath);

        driver.findElement(upload_locator).sendKeys(file.getAbsolutePath());

        boolean imageUpLoad = false;

        try {
            String src = driver.findElement(By.id("thumbnail")).getDomAttribute("src");
            imageUpLoad = !src.isEmpty();
        }catch (Exception e){
            System.out.println("Images was not uploaded correctly");
            e.printStackTrace();
        }

        Assertions.assertTrue(imageUpLoad,"Image was not uploaded correctly");
    }
}
