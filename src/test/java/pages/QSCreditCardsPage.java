package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QSCreditCardsPage extends BasePage{

    By inputPassword_Locator = By.name("password");

    By diamondCC_Locator =By.xpath("//img[contains(@src,'QStream+Diamond+Credit+Card1.png')]");
    By goldenCC_Locator= By.xpath("//img[contains(@src,'QStream+Golden+Credit+Card1.png')]");

    By platinumCC_Locator= By.xpath("//img[contains(@src,'QStream+Platinum+Credit+Card1.png')]");

    By selectCreditCardType_Locator = By.id("cardType");

    By creditCardDetailsLabel_Locator = By.id("cardDetails");

    By purchaseAmountInput_Locator = By.id("purchaseAmount");

    By PurchaseButton_Locator = By.xpath("//button[normalize-space()='Realizar Compra']");

    By buyButton_Locator = By.xpath("//button[normalize-space()='Realizar pago']");

    By paymentAmountInput_Locator = By.id("paymentAmount");

    By includeInterestCheckbox_Locator = By.id("includeInterest");


    By balanceLabel_locator = By.id("balance");
    By interestLabel_Locator= By.id("interest");

    By totalBalanceLabel_Locator = By.id("totalBalance");



    public QSCreditCardsPage(WebDriver driver) {
        super(driver);


    }

    public void enterPassword()
    {
        String password ="qa123";
        type(inputPassword_Locator,password);
        submit(inputPassword_Locator);
    }

    public boolean areCreditCardPresent()
    {
        //variable que valida si esta en la pantalla la tarjeta de credito
        boolean diamondCC= isDisplayed(diamondCC_Locator);
        System.out.println("the Diamond CC is present " +diamondCC);

        boolean goldCC =isDisplayed(goldenCC_Locator);
        System.out.println("the Gold CC is present " +goldCC);

        boolean platinumCC = isDisplayed(platinumCC_Locator);
        System.out.println("the Platinum CC is present " +platinumCC);

        return diamondCC && goldCC && platinumCC;
    }

    public void selectCreditCard(String creditCardType)
    {
        Select select = new Select(findElement(selectCreditCardType_Locator));
        select.selectByValue("diamond");

    }

    public String creditCardDetailsUpdated()
    {
        String details = getText(creditCardDetailsLabel_Locator);
        System.out.println("Credit card details:" +details);
        return details;

    }
}
