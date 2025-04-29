package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");
    By productPrice_Locator = By.cssSelector("div.product-price");
    By selectSize_Locator = By.cssSelector("select[aria-label='Select Size']");
    By inputQuantity_Locator = By.cssSelector("input[aria-label='Quantity']");
    By addToCartBtn_Locator = By.cssSelector("div[role='button'][data-original-label='Add To Cart']");

    //Método para seleccionar talla, cantidad (recibimos talla y cant como parámetros)
    // Hacer click en el btn Add to Cart y
    //Verificar que el número del carrito aumenta en la cantidad de elementos que añadimos

    //Tarea
    //1- Crear Método que retorne el título del producto
    //2- Crear Método que retorne el precio del producto


}
