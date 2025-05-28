package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ActionPage;
import pages.HomePage;
import pages.WebElementsTestPage;

import java.time.Duration;

public class FramesTest extends BaseTest{

    HomePage homePage;

    WebElementsTestPage webElementsTestPage;

    @BeforeEach
    void init() {
        homePage = new HomePage();
        webElementsTestPage = new WebElementsTestPage();
        homePage.clickOnWebElementTestLink();
        webElementsTestPage.clickOnFramesLink();
    }
    //Frames anidados

    @Test
    void testMultiFrame() {

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        //switchTo

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        WebElement righText = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String text = righText.getText().trim();
        System.out.println("text: "+text);

        Assertions.assertEquals("QUALITYSTREAM\nRIGHT-FRAME",text,"Right frame text is not correct");

        //BaCK TO MAIN WINDOW

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftText = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String text_LeftText = leftText.getText().trim();
        System.out.println("text: "+text_LeftText);

        Assertions.assertEquals("QUALITYSTREAM\nLEFT-FRAME",text_LeftText,"Left frame text is not correct");

        driver.switchTo().defaultContent();

        Assertions.assertEquals("Nested Frames Example",driver.getTitle(),"We are not in the main frame");
    }
}
