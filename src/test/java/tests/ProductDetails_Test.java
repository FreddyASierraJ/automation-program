package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductDetailsPage;

public class ProductDetails_Test extends BaseTest{
    HomePage homePage;

    ProductDetailsPage productDetailsPage;
    @BeforeEach
    void initPageObject() {
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
