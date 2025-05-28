package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{


    By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");
    By productPrice_Locator = By.cssSelector("div.product-price");
    By selectSize_Locator = By.cssSelector("select[aria-label='Select Size']");
    By inputQuantity_Locator = By.cssSelector("input[aria-label='Quantity']");
    By addToCartBtn_Locator = By.cssSelector("div[role='button'][data-original-label='Add To Cart']");

    public ProductDetailsPage() {

    }
    // Método para devolver el título del producto
    public String getProductTitle() {
        return getText(productTitle_Locator);
    }
    // Método para devolver el precio del producto
    public String getProductPrice() {
        return getText(productPrice_Locator);
    }
    // Método para seleccionar la talla
    public void selectSize(String size) {
        selectByVisibleText(selectSize_Locator, size);
    }
    // Método para seleccionar la cantidad
    public void selectQuantity(int quantity) {
        type(inputQuantity_Locator, String.valueOf(quantity));
    }
    // Método para hacer clic en el botón "Add to Cart"
    public void clickAddToCart() {
        click(addToCartBtn_Locator);
    }



    //Método para seleccionar talla, cantidad (recibimos talla y cant como parámetros)
    // Hacer click en el btn Add to Cart y
    //Verificar que el número del carrito aumenta en la cantidad de elementos que añadimos

    //Tarea
    //1- Crear Método que retorne el título del producto
    //2- Crear Método que retorne el precio del producto


}
