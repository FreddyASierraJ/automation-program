package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.QSCreditCardsPage;

public class QSCreditCardTest extends BaseTest {

    HomePage homePage;

    QSCreditCardsPage creditCardsPage;

    @BeforeEach
    void initPageObject() {
        homePage = new HomePage(driver);
        creditCardsPage = new QSCreditCardsPage(driver);

        homePage.clickOnQSCreditCardsLink();
        creditCardsPage.enterPassword();
    }

    @Test
    void areCreditCardImagesPresent() {
        Assertions.assertTrue(creditCardsPage.areCreditCardPresent(), "Credit Card Images are not present");
    }
}
