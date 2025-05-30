package tests;

import clase1.BaseTest2;
import listeners.ExtentReportExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertsPage;
import pages.HomePage;
import pages.WebElementsTestPage;

import java.time.Duration;

@ExtendWith(ExtentReportExtension.class)
public class HandlingElementsTest extends BaseTest2 {

    static HomePage homePage;
    static WebDriverWait wait;

    static WebElementsTestPage webElementsTestPage;

    static AlertsPage alertsPage;

    @BeforeAll
    static void setUp() {
        homePage = new HomePage();
        homePage.clickOnWebElementTestLink();
        webElementsTestPage = new WebElementsTestPage();
        alertsPage = new AlertsPage();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void openNewWindow() {

        String originalHandle = driver.getWindowHandle();
        System.out.println("Original window handle:"+originalHandle);
        Assertions.assertNotNull(originalHandle,"Original handle was null");

        webElementsTestPage.clickOnNewWindow();

        webElementsTestPage.switchToNewWindow(originalHandle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL: "+currentURL);
        Assertions.assertTrue(currentURL.contains("quality-stream.com/productos"),
                "New window URL is not correct");

        //cerrar la nueva ventana y volver a la original
        driver.close();
        driver.switchTo().window(originalHandle);

        String originalURL = driver.getCurrentUrl();
        System.out.println("originalURL: "+originalURL);
        Assertions.assertTrue(originalURL.contains("qualitystream-practice.com/webelements-test"),
                "Original window url is not correct");

    }

    @Test
    void openNewTab() {

        String originalHandle = driver.getWindowHandle();
        System.out.println("Original window handle:"+originalHandle);
        Assertions.assertNotNull(originalHandle,"Original handle was null");

        webElementsTestPage.clickOnNewTab();

        webElementsTestPage.switchToNewWindow(originalHandle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL: "+currentURL);
        Assertions.assertTrue(currentURL.contains("https://www.youtube.com/c/QualityStream"),
                "New Tab URL is not correct");

        //cerrar el nuevo tab y volver a la ventana original
        driver.close();
        driver.switchTo().window(originalHandle);

        String originalURL = driver.getCurrentUrl();
        System.out.println("originalURL: "+originalURL);
        Assertions.assertTrue(originalURL.contains("qualitystream-practice.com/webelements-test"),
                "Original window url is not correct");


    }

    @Test
    void alertBoxTest() {

        webElementsTestPage.clickOnAlertsLink();

        alertsPage.clickOnAlert_TypeAlertBox();

        String expectedText = "Hola! I am an alert box!";
        String alertText = alertsPage.getAlertText();

        System.out.println("expectedText: "+expectedText+" | alertText: "+alertText);

        alertsPage.acceptAlert();

        Assertions.assertTrue(expectedText.equals(alertText),"Alert text is not correct");

    }

    @Test
    void cancelAlertTest() {

        webElementsTestPage.clickOnAlertsLink();

        alertsPage.clickOnAlert_TypeConfirm();
        alertsPage.dismissAlert();

        String expectedText = "Cancelaste la Alerta!";
        String currentText = alertsPage.get_ConfirmAlertText();

        System.out.println("expectedText: "+expectedText+ "| currentText:" +currentText);

        Assertions.assertTrue(expectedText.equals(currentText),
                "Current text is not correct");

    }

    @Test
    void confirmAlertTest() {

        webElementsTestPage.clickOnAlertsLink();

        alertsPage.clickOnAlert_TypeConfirm();
        alertsPage.acceptAlert();

        String expectedText = "Aceptaste la Alerta!";
        String currentText = alertsPage.get_ConfirmAlertText();

        System.out.println("expectedText: "+expectedText+ "| currentText:" +currentText);

        Assertions.assertTrue(expectedText.equals(currentText),
                "Current text is not correct");

    }

    @Test
    void promptAlertTest() {

        webElementsTestPage.clickOnAlertsLink();

        alertsPage.clickOnAlert_TypePrompt();
        alertsPage.sendKeysToAlert("QualityStream");

        String expectedText = "Hola QualityStream! Cómo estás hoy?";
        String currentText = alertsPage.get_PromptAlertText();

        System.out.println("expectedText: "+expectedText+" |currentText:"+currentText);

        Assertions.assertTrue(expectedText.equals(currentText),
                "Prompt text is not correct");

    }

    @Test
    void handleCookies() {

        for (Cookie cookie : driver.manage().getCookies())
        {
            System.out.println("--------------- Cookie Info ---------------");
            System.out.println("Name:" + cookie.getName());
            System.out.println("Value:" + cookie.getValue());
            System.out.println("Domain:" + cookie.getDomain());
            System.out.println("Path:" + cookie.getPath());
            System.out.println("Secure?:" + cookie.isSecure());
            System.out.println("HTTP only?:" + cookie.isHttpOnly());
            System.out.println("Full text:" + cookie);
        }
    }
}
