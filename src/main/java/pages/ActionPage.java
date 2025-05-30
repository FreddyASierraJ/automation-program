package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionPage extends BasePage{


    By textArea1_Locator= By.id("inputText");
    By textArea2_Locator=By.id("inputText2");

    By menu1Button_Locator=By.xpath("//button[normalize-space()='Menu 1']");
    By option1B_Locator=By.xpath("//button[normalize-space()='Option 1B']");

    By selectedOption_Locator=By.id("output");
    public ActionPage() {

    }

    public String verifyKeysChord(String text){
        WebElement textArea =findElement(textArea1_Locator);
        textArea.clear();
        textArea.sendKeys(Keys.chord(Keys.SHIFT,text));
        //hacer ejercicio de usar gettext o getdomeatribute a ver que pasa
        return textArea.getAttribute("value");
    }

    public String verifyActionKeyBoard(String text){
        WebElement textArea =findElement(textArea1_Locator);
        textArea.clear();

        Actions action = new Actions(driver);

        action.keyDown(Keys.SHIFT).sendKeys(textArea,text).keyUp(Keys.SHIFT).perform();

        return textArea.getAttribute("value");

    }
    public String verifyActionCopyPaste(String text){

        WebElement textArea1 = findElement(textArea1_Locator);
        textArea1.clear();
        WebElement textArea2 = findElement(textArea2_Locator);
        textArea2.clear();

        Actions action = new Actions(driver);
        //Se simula uso de SHIFT escriben mayus usando SHIFT
        action.keyDown(Keys.SHIFT)
                .sendKeys(textArea1,text)
                .keyUp(Keys.SHIFT)
                .perform();
        //Se simula usar tecla CTRL que presiona CTRL +A y Copiamos CTROL + C
        action.click(textArea1)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();
        //Metodo que hace el pegado del control
        action.click(textArea2)
                .keyDown(Keys.CONTROL)
                .sendKeys(textArea2,"v")
                .keyUp(Keys.CONTROL)
                .perform();
        return textArea2.getAttribute("value");

    }
    //Metodo para hacer Hove over aciones del puntero del mouse
    public String selectMenuOpcion1B(){

        WebElement menu1Btn = findElement(menu1Button_Locator);
        WebElement option1B = findElement(option1B_Locator);

        Actions actions = new Actions(driver);
        actions.moveToElement(menu1Btn).moveToElement(option1B).click().perform();

        return getText(selectedOption_Locator);
    }
}
