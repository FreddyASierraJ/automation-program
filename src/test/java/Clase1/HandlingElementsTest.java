package Clase1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertsPage;
import pages.HomePage;
import pages.WebElementsTestPage;
import tests.BaseTest;

import java.time.Duration;

public class HandlingElementsTest extends BaseTest2 {

    //Se instancia objeto HomePage de la clase padre BaseTest2
    HomePage homePage;
    WebElementsTestPage webElementTestPage;

    AlertsPage alertsPage;

    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        //se inicializa el objeto de la clase padre BaseTest2
        homePage = new HomePage();
        //debo crear este metodo
        homePage.clickOnWebElementTestLink();
        webElementTestPage = new WebElementsTestPage();
        alertsPage=new AlertsPage();

         wait = new WebDriverWait(driver, Duration.ofSeconds(10));



    }

    @Test
    void openNewWindow() {
        String originalHandle = driver.getWindowHandle();
        System.out.println("Original window halde "+originalHandle);

        Assertions.assertNotNull(originalHandle,"original handle was null");

        webElementTestPage.clickOnNewWindow();

        webElementTestPage.switchToNewWindow(originalHandle);

        String currentURL=driver.getCurrentUrl();
        System.out.println("current url "+ currentURL);

        Assertions.assertTrue(currentURL.contains("quality-stream.com/productos"),"Url window is not correct");

        //cerrar la nueva ventana y volver a la original

        driver.close();
        driver.switchTo().window(originalHandle);

        //vamos a capturar la url de la pagina para confirmar que volvio a la original

        String originalURL= driver.getCurrentUrl();
        System.out.println("original url "+originalURL);

        Assertions.assertTrue(originalURL.contains("quality-stream.com/webelements-test"),
                "Original window url is not correct");


    }

    @Test
    void openNewTab() {
        String originalHandle = driver.getWindowHandle();
        System.out.println("Original window halde "+originalHandle);
        Assertions.assertNotNull(originalHandle,"original handle was null");

        webElementTestPage.clickOnNewTab();

        webElementTestPage.switchToNewWindow(originalHandle);

        String currentURL=driver.getCurrentUrl();
        System.out.println("current url "+ currentURL);

        Assertions.assertTrue(currentURL.contains("https://www.youtube.com/c/QualityStream"),
                "Url is not correct");



    }

    @Test
    void alertBoxPage() {

        webElementTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypeAlertBox();

        //capturar el texto de la alerta
        //cual es el txto que esperamos

        String expectedText="Hola! I am an alert box!";
        String alertText = alertsPage.getAlertText();
        System.out.println("expectedText" +expectedText +" alertText " +alertText);

        alertsPage.acceptAlert();

        Assertions.assertTrue(expectedText.equals(alertText),"| Alert text is not correct");
    }

    @Test
    void cancelAlertTest() {
        webElementTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypeConfirm();
        alertsPage.dismissAlert();

        String expectedText ="Cancelaste la Alerta!";
        String currentText = alertsPage.get_ConfirmAlertText();

        System.out.println("expectedText:"+expectedText +"| currentText"+currentText);
        Assertions.assertTrue(expectedText.equals(currentText),
                "current text is not correct");
    }
    @Test
    void confirmAlertTest() {
        webElementTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypeConfirm();
        alertsPage.acceptAlert();

        String expectedText ="Aceptaste la Alerta!";
        String currentText = alertsPage.get_ConfirmAlertText();

        System.out.println("expectedText:"+expectedText +"| currentText"+currentText);
        Assertions.assertTrue(expectedText.equals(currentText),
                "current text is not correct");
    }

    @Test
    void promptAlertTest() {
        webElementTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypePrompt();
        alertsPage.sendKeysToAlert("QualityStream");

        String expectedText ="Hola QualityStream! Cómo estás hoy?";
        String currentText=alertsPage.get_PromptAlertText();

        System.out.println("expectedText "+expectedText +"| currentText: "+ currentText);
        Assertions.assertTrue(expectedText.equals(currentText),
                "Prompt text is not correct");
    }

    //Trabajar con cookies


    @Test
    void handleCookies() {

        for(Cookie cookie : driver.manage().getCookies()){

            System.out.println("---------- Cookie Info ----------");
            System.out.println("Name: "+cookie.getName());
            System.out.println("Value: "+cookie.getValue());
            System.out.println("Domain: "+cookie.getDomain());
            System.out.println("Path: "+cookie.getPath());
            System.out.println("Securfe: "+cookie.isSecure());
            System.out.println("HTTP Only?: "+cookie.isHttpOnly());
            System.out.println("Full Text: "+cookie);


        }
    }
}
