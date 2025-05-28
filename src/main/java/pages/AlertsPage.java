package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsPage extends BasePage{

    By alertBox_Locator = By.id("simple");

    By confirmAlert_Locator = By.id("confirm");
    By confirmLabel_Locator = By.id("demo");

    By promptAlert_Locator = By.id("prompt");
    By promptLabel_Locator = By.id("prompt_demo");


    public AlertsPage() {

    }

    public void clickOnAlert_TypeAlertBox(){
        click(alertBox_Locator);
    }

    public void clickOnAlert_TypeConfirm(){
        click(confirmAlert_Locator);
    }

    public void clickOnAlert_TypePrompt(){
        click(promptAlert_Locator);
    }

    public String get_ConfirmAlertText(){
        return getText(confirmLabel_Locator);
    }

    public String get_PromptAlertText(){
        return getText(promptLabel_Locator);
    }



}
