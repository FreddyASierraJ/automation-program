package Clase1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class QS_About_Test {

    /*@Test
    void verifyAboutPage() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qualitystream-practice.com/");
        driver.manage().window().maximize();

        By aboutLink_Locator = By.xpath("//div[@class='header-nav-item header-nav-item--collection']//a[@href='/about']");
        By aboutImage_Locator = By.xpath("//img[contains(@src,'IMG_0481.JPG')]");
        driver.findElement(By.xpath(
                "//div[@class='header-nav-item header-nav-item--collection']//a[@href='/about']")).click();

        String expectedUrl = "https://www.qualitystream-practice.com/about";
        String currentUrl = driver.getCurrentUrl();

        //salida por consola en forma de log para ver el resultado
        System.out.println("CurrentUrl "+currentUrl+" "+"Actual "+expectedUrl);

        //variable que captura el localizador de la imagen y si esta presente en este caso es  true
        boolean isImagePresent = driver.findElement(aboutImage_Locator).isDisplayed();
        System.out.println("isImagePresent: "+isImagePresent);
        //asercion que valida la url actual con la url esperada si es correcta
        Assertions.assertEquals(expectedUrl,currentUrl,"Failed:Current URL is not the expected one" );
        driver.quit();

    }*/
    @Test
    void verifyBottomsOptions(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qualitystream-practice.com/");
        driver.manage().window().maximize();

        //Test 1 Validar Buttoms

        By aboutBottomsLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'B')]");
        driver.findElement(aboutBottomsLocator).click();

        String expectedUrl = "https://www.qualitystream-practice.com/shop/bottoms";
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Buttoms URL: CurrentUrl "+currentUrl+" "+"Actual "+expectedUrl);
        Assertions.assertEquals(expectedUrl,currentUrl, "Failed: La Url actual no es la esperada");

        //Test 2 Validar link top

        driver.navigate().back();
        By aboutTopsLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'T')]");
        driver.findElement(aboutTopsLocator).click();

        String expectedTopUrl = "https://www.qualitystream-practice.com/shop/tops";
        String currentTopUrl = driver.getCurrentUrl();

        System.out.println("Top URL: CurrentUrl "+currentTopUrl+" "+"Actual "+expectedTopUrl);

        //Test 3 Validar All

        By aboutAllLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'A')]");
        driver.findElement(aboutAllLocator).click();

        String expectedAllUrl = "https://www.qualitystream-practice.com/shop/tops";
        String currentAllUrl = driver.getCurrentUrl();

        System.out.println("All URL: CurrentUrl "+currentAllUrl+" "+"Actual "+expectedAllUrl);
        driver.quit();


    }


}
