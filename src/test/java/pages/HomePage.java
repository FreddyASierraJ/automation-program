package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    /**
     * Header social links
     */

    By qsCreditCardLink_Locator = By.cssSelector("a[href='/qualitystream-credit-cards']");
    By headerYoutubeIcon_Locator = By.cssSelector("div.header-actions-action.header-actions-action--social a[aria-label='YouTube']");

    //Filters

    By aboutBottomsLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'B')]");

    By aboutTopsLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'T')]");

    By aboutAllLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'A')]");

    By saleLink_Locator = By.cssSelector("a[href='/shop/sale']");

    //Products

    By productLinkList_Locator =By.cssSelector("a.grid-item-link.product-lists-item");






    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Methods
     */

    public boolean isQsCreditCardsLinksDisplayed()
    {
        boolean isDisplayed = isDisplayed(qsCreditCardLink_Locator);
        System.out.println("is CC Link Displayed "+ isDisplayed);
        return isDisplayed;
    }
    public void clickOnQSCreditCardsLink()
    {
        click(qsCreditCardLink_Locator);
    }
    public boolean isHeaderYtbIconDisplayed()
    {
        boolean isDisplayed = isDisplayed(headerYoutubeIcon_Locator);
        System.out.println("is CC Link Displayed "+ isDisplayed);
        return isDisplayed;
    }
    public boolean areFiltersPresent()
    {
        boolean topFilterLinkIsPresent = isDisplayed(aboutTopsLocator);
        System.out.println("is CC Link Displayed "+ topFilterLinkIsPresent);
        return topFilterLinkIsPresent;
    }
}
