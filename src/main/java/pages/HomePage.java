package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{

    /**
     * Header social links
     */

    By qsCreditCardLink_Locator = By.cssSelector("a[href='/qualitystream-credit-cards']");
    By headerYoutubeIcon_Locator = By.cssSelector("div.header-actions-action.header-actions-action--social a[aria-label='YouTube']");

    //Filters
    By coursePageLink_Locator = By.cssSelector("a[href='/formpage']");

    By webElementTestLink_Locator = By.cssSelector("a[href='/webelements-test']");

    By aboutBottomsLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'B')]");

    By aboutTopsLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'T')]");

    By aboutAllLocator = By.xpath("//a[@class='nested-category-breadcrumb-link'][contains(text(), 'A')]");

    By saleLink_Locator = By.cssSelector("a[href='/shop/sale']");

    //Products

    By productLinkList_Locator =By.cssSelector("a.grid-item-link.product-lists-item");






    public HomePage() {

    }

    /**
     * Methods
     */

    public void clickOnProductLink(int index)
    {
        List<WebElement> productLinks = findElements(productLinkList_Locator);
        if(index < productLinks.size())
        {
            productLinks.get(index).click();
        }

    }

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
    public void clickOnCoursesLink(){

        click(coursePageLink_Locator);

    }
    public void clickOnWebElementTestLink(){

        click(webElementTestLink_Locator);

    }
    public boolean areFiltersPresent()
    {
        boolean topFilterLinkIsPresent = isDisplayed(aboutTopsLocator);
        System.out.println("is CC Link Displayed "+ topFilterLinkIsPresent);
        return topFilterLinkIsPresent;
    }
}
