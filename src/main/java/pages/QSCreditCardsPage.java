package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QSCreditCardsPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(QSCreditCardsPage.class);

    //password
    By inputPassword_Locator = By.name("password");

    //Credit Cards
    By diamondCC_Locator = By.xpath("//img[contains(@src,'QStream+Diamond+Credit+Card1.png')]");
    By goldenCC_Locator = By.xpath("//img[contains(@src,'QStream+Golden+Credit+Card1.png')]");
    By platinumCC_Locator = By.xpath("//img[contains(@src,'QStream+Platinum+Credit+Card1.png')]");

    //Form
    By selectCreditCardType_Locator = By.id("cardType");
    By creditCardDetailsLabel_Locator = By.id("cardDetails");
    By purchaseAmountInput_Locator = By.id("purchaseAmount");
    By purchaseButton_Locator = By.xpath("//button[normalize-space()='Realizar Compra']");
    By buyButton_Locator = By.xpath("//button[normalize-space()='Realizar Pago']");
    By paymentAmountInput_Locator = By.id("paymentAmount");
    By includeInterestCheckbox_Locator = By.id("includeInterest");

    //Labels
    By balanceLabel_Locator = By.id("balance");
    By interestLabel_Locator = By.id("interest");
    By totalBalanceLabel_Locator = By.id("totalBalance");


    public QSCreditCardsPage() {

    }

    public void enterPassword(){

        waitForElementToBeClickable(inputPassword_Locator);

        if(isDisplayed(inputPassword_Locator))
        {
            String password = "qa123";
            type(inputPassword_Locator,password);
            submit(inputPassword_Locator);
        }else {
            logger.info("Password input was not present");
        }
    }

    public boolean areCreditCardPresent(){
        boolean diamondCC = isDisplayed(diamondCC_Locator);
        logger.info("Is Diamond CC Present: "+diamondCC);

        boolean goldenCC = isDisplayed(goldenCC_Locator);
        logger.info("Is Golden CC Present: "+goldenCC);

        boolean platinumCC = isDisplayed(platinumCC_Locator);
        logger.info("Is Platinum CC Present: "+platinumCC);

        return diamondCC && goldenCC && platinumCC;
    }

    public void selectCreditCard(String creditCardType){
        scrollIntoView(selectCreditCardType_Locator);
        Select select = new Select(findElement(selectCreditCardType_Locator));
        select.selectByValue(creditCardType);
    }

    public String creditCardDetailsUpdated(){

        String details = getText(creditCardDetailsLabel_Locator);
        logger.info("Credit Card details:"+details);
        return details;

    }
}
