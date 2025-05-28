package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.QSCreditCardsPage;

public class QSCreditCardTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(QSCreditCardTest.class);

    HomePage homePage;
    QSCreditCardsPage creditCardsPage;

    @BeforeEach
    void initPageObject() {
        homePage = new HomePage();
        creditCardsPage = new QSCreditCardsPage();

        homePage.clickOnQSCreditCardsLink();
        creditCardsPage.enterPassword();
    }

    @Test
    void areCreditCardImagesPresent() {
        Assertions.assertTrue(creditCardsPage.areCreditCardPresent(),
                "Credit Card Images are not present");
    }

    @ParameterizedTest
    @CsvSource({"diamond,Interés: 18.81% Anual Fee: $550",
            "golden, Interés: 20.31% Anual Fee: $350",
            "platinum, Interés: 22.58% Anual Fee: $150"})
    void areCreditCardsDetailsCorrect(String type, String expectedText){

        //En otra clase veremos cómo parametrizar este Test
        creditCardsPage.selectCreditCard("diamond");

        //String expectedText = "Interés: 18.81% Anual Fee: $550";
        String ccDetails = creditCardsPage.creditCardDetailsUpdated();

        logger.info("Expected: " + expectedText +"\n Current: "+ccDetails);
        Assertions.assertEquals(expectedText,ccDetails,"CC details are incorrect");

        logger.info("Este print está después del Assertion");
    }
}
