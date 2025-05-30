package tests;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import pages.ProductDetailsPage;

@ExtendWith(ExtentReportExtension.class)
@Tag("ProductDetail_Regression")
public class ProductDetails_Test extends BaseTest{
    static HomePage homePage;

    static ProductDetailsPage productDetailsPage;
    @BeforeAll
    static void initPageObject() {
        homePage = new HomePage();
        productDetailsPage = new ProductDetailsPage();

    }

    @Test
    void verifyProductTitleIsPresent() {
        homePage.clickOnProductLink(3);
        String curentTitle = productDetailsPage.getProductTitle();
        System.out.println("Product title is: " + curentTitle);
        Assertions.assertFalse(curentTitle.isEmpty(), "Product title is not present");
    }
}
