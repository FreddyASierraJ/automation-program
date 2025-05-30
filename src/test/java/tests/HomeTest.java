package tests;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;

@ExtendWith(ExtentReportExtension.class)
public class HomeTest extends BaseTest{

    static HomePage homePage;

    @BeforeAll
    static void initPageObjects() {
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
