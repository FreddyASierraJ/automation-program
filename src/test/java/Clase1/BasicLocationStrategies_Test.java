package Clase1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utility;

public class BasicLocationStrategies_Test extends BaseTest2{

    @Test
    void testId() {
        By inputName_Locator = By.id("name");
        WebElement element = driver.findElement(inputName_Locator);

        Utility.printElementInfo("Input Name ",element);
    }
    @Test
    void testName() {
        By inputEmail_Locator = By.name("email");
        WebElement element = driver.findElement(inputEmail_Locator);

        Utility.printElementInfo("Input Email ",element);
    }
    @Test
    void testClassName() {
        By imageThumbnail_Locator = By.className("email");
        WebElement element = driver.findElement(imageThumbnail_Locator);

        Utility.printElementInfo("image Thumbnail ",element);
    }
    @Test
    void testTagName() {
        By table_Locator = By.tagName("table");
        WebElement element = driver.findElement(table_Locator);

        Utility.printElementInfo("Table Locator ",element);
    }
    @Test
    void testLinkText() {
        By appointment_Locator = By.linkText("Go to Appointment Page");
        WebElement element = driver.findElement(appointment_Locator);

        Utility.printElementInfo("Link Text ",element);
    }
    @Test
    void testPartialLinkText() {
        By appointment_Locator = By.partialLinkText("Go to");
        WebElement element = driver.findElement(appointment_Locator);

        Utility.printElementInfo("Partial Link Text ",element);
    }
}
