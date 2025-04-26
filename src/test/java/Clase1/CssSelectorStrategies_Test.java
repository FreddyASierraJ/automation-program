package Clase1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utility;

public class CssSelectorStrategies_Test extends BaseTest2{

    @Test
    void testTagname() {
        By tagName = By.cssSelector("input");
        WebElement element = driver.findElement(tagName);
        Utility.printElementInfo("Input Name", element);
    }
    //tag name y un atributo
    @Test
    void testTagnamePlusAtribute() {
        By inputName_locator = By.cssSelector("input");
        WebElement element = driver.findElement(inputName_locator);
        Utility.printElementInfo("Input Name Locator", element);
    }
    //tag name por atributo y valor
    @Test
    void testTagnamePlusAtributeValor() {
        By inputEmail_locator = By.cssSelector("input[type='email']");
        WebElement element = driver.findElement(inputEmail_locator);
        Utility.printElementInfo("Input Email Locator", element);
    }
    //tag name por atributo valor id usando #
    @Test
    void testTagnamePlusAtributeById() {
        By inputEmailByid_locator = By.cssSelector("#email");
        WebElement element = driver.findElement(inputEmailByid_locator);
        Utility.printElementInfo("Input Email Locator", element);
    }
    //tag name por atributo valor id usando #
    @Test
    void testTagnamePlusId() {
        By inputEmailByid_locator = By.cssSelector("input#email");
        WebElement element = driver.findElement(inputEmailByid_locator);
        Utility.printElementInfo("Input Email Locator", element);
    }
    //class usando punto (.)
    @Test
    void testClass() {
        By image_locator = By.cssSelector(".thumbnail");
        WebElement element = driver.findElement(image_locator);
        Utility.printElementInfo("Input Email Locator", element);
    }
    //usando punto (.) + la etiqueta img
    @Test
    void testTagClass() {
        By image_locator = By.cssSelector("img.thumbnail");
        WebElement element = driver.findElement(image_locator);
        Utility.printElementInfo("Input Email Locator", element);
    }
    //usando * para encontrar cualquier elemento
    //*[class='label']
    @Test
    void testAnyElement() {
        By asteriskEmail_locator = By.cssSelector("*[type='email']");
        WebElement element = driver.findElement(asteriskEmail_locator);
        Utility.printElementInfo("form Locator", element);
    }
    //Relacion padre e hijo css selector
    @Test
    void testFatherandSOn() {
        By form_locator = By.cssSelector("div>form");
        WebElement element = driver.findElement(form_locator);
        Utility.printElementInfo("form Locator", element);
    }

    //Relacion de hermanos siblings
    @Test
    void testSiblings() {
        By table_locator = By.cssSelector("form+table");
        WebElement element = driver.findElement(table_locator);
        Utility.printElementInfo("Siblings Locator", element);
    }
    //partial match ends with ~$=
    //button[type$='ton']
    @Test
    void testEndsWith() {
        By btnAdicionarCurso_locator = By.cssSelector("button[type$='ton']");
        WebElement element = driver.findElement(btnAdicionarCurso_locator);
        Utility.printElementInfo("btn Adicionar Curso Locator", element);
    }
    //partial match starts with ^

    @Test
    void testStartsWith() {
        By inputName_locator = By.cssSelector("*[name^='nam']");
        WebElement element = driver.findElement(inputName_locator);
        Utility.printElementInfo("input name start Locator", element);
    }
    //hacer match de palabras completas, si se pone partial no funciona
    //Partial match - contains word ~=

    @Test
    void testContainsWord() {
        By checkBoxJava_locator = By.cssSelector("*[value~='Java']");
        WebElement element = driver.findElement(checkBoxJava_locator);
        Utility.printElementInfo("Checkbox java para testers Locator", element);
    }

    //logical OR que es una coma (,)
    @Test
    void testLogicalOr() {
        By logicalOr_locator = By.cssSelector("input,*[type='email']");
        WebElement element = driver.findElement(logicalOr_locator);
        Utility.printElementInfo("Logical OR Locator", element);
    }

    //usando la funcion not()
    //input:not([id='name']) | esto devuelve el last name

    @Test
    void testnotFunction() {
        By inputLastName_locator = By.cssSelector("input:not([id='name'])");
        WebElement element = driver.findElement(inputLastName_locator);
        Utility.printElementInfo("input not Locator", element);
    }

    //multipes atributos con valor
    //input[type='text'][name='lastName']
    @Test
    void testMultipleAtributes() {
        By input_locator = By.cssSelector("input[type='text'][name='lastName'");
        WebElement element = driver.findElement(input_locator);
        Utility.printElementInfo("Multiple Locator", element);
    }




}
