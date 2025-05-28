package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomeTest extends BaseTest{

    HomePage homePage;

    @BeforeEach
    void initPageObjects() {
        homePage = new HomePage();
    }

    @Test
    void verifyQstreamCreditCardsLinks()
    {

        Assertions.assertTrue(homePage.isQsCreditCardsLinksDisplayed(),"Credit cards link is not displayed");
    }

    @Test
    void verifyHeaderYtbIcon()
    {
        Assertions.assertTrue(homePage.isHeaderYtbIconDisplayed(), "Youtube icon in the header is not present");
    }

    @Test
    void verifyHomePageFilter()
    {
        Assertions.assertTrue(homePage.areFiltersPresent(),"Filters are not present");
    }
}
