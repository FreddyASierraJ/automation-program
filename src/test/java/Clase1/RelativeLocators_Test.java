package Clase1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utils.Utility;

public class RelativeLocators_Test extends BaseTest2{
    /*
    Cómo usar los Relative Locators:
        1. Primero localizas un elemento que tenga un localizador conocido
         (por ejemplo, un ID o nombre de clase).
        2. Luego usas los métodos de los localizadores relativos para encontrarn
         el elemento objetivo (target) en relación con ese primer elemento.
         Por ejemplo, puedes encontrar un elemento que esté "debajo"(below)
         de un elemento conocido o "a la derecha de" (toRightOf).
     */
    @BeforeEach
    void init() {
        By webElementTestLink_Locator = By.xpath("//a[normalize-space()='WebElements Test']");
        driver.findElement(webElementTestLink_Locator).click();
    }
    @Test
    void relativeLocator_Above() {
        By textAboveClickMeBtn_Locator = RelativeLocator.with(By.tagName("p")).above(By.id("mainButton"));
        WebElement element = driver.findElement(textAboveClickMeBtn_Locator);
        Utility.printElementInfo("textAboveClickMeBtn", element);
    }
    /*    @Test
    void relativeLocator_Below2() {
        By textBelowClickMeBtn_Locator = RelativeLocator.with(By.tagName("p")).straightBelow(By.id("mainButton"));
        WebElement element = driver.findElement(textBelowClickMeBtn_Locator);

        Utility.printElementInfo("textBelowClickMeBtn_Locator", element);
    }*/
    @Test
    void relativeLocator_Below() {
        By btnBelowClickMeBtn_Locator = RelativeLocator.with(By.tagName("button")).below(By.id("mainButton"));
        WebElement element = driver.findElement(btnBelowClickMeBtn_Locator);
        Utility.printElementInfo("btnBelowClickMeBtn_Locator", element);
    }
    @Test
    void relativeLocator_RightOf() {
        WebElement leftBtn = driver.findElement(By.id("leftBtn"));
        By btnRightOfLeftBtn_Locator = RelativeLocator.with(By.tagName("button")).toRightOf(leftBtn);
        WebElement element = driver.findElement(btnRightOfLeftBtn_Locator);
        Utility.printElementInfo("btnRightOfLeftBtn_Locator", element);
    }
    @Test
    void relativeLocator_LeftOf() {
        By textLeftOfRightBtn_Locator = RelativeLocator.with(By.tagName("p")).toLeftOf(By.id("rightBtn"));
        WebElement element = driver.findElement(textLeftOfRightBtn_Locator);
        Utility.printElementInfo("textLeftOfRightBtn_Locator", element);
    }
    @Test
    void relativeLocator_NearOf() {
        By texbox_Locator = RelativeLocator.with(By.tagName("input")).near(By.id("nearLabel"));
        WebElement element = driver.findElement(texbox_Locator);
        Utility.printElementInfo("texbox_Locator", element);
    }
    //Me devuelve el Texto "Center" en vez de ":mag: Text near the input textbox"
    @Test
    void relativeLocator_NearOf2() {
        By textNearOfTextbox_Locator = RelativeLocator.with(By.tagName("p")).near(By.tagName("input"));
        WebElement element = driver.findElement(textNearOfTextbox_Locator);
        Utility.printElementInfo("textNearOfTextbox_Locator", element);
    }
}
