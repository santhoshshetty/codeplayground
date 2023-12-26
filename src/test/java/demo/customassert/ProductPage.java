package demo.customassert;

import Drivers.DriverManager;
import org.openqa.selenium.By;

public class ProductPage {

    private static final By PRODUCT_NAME = By.xpath("//div[contains(@class,'entry-content content-title')]/h1");
    private static final By PRODUCT_CODE = By.xpath("//span[text()='Product Code:']/following-sibling::span");
    private static final By PRODUCT_BRAND = By.xpath("//span[text()='Brand:']/following-sibling::a");
    private static final By PRODUCT_AVAILABILITY = By.xpath("//span[text()='Availability:']/following-sibling::span");
    private static final By CART_COUNT = By.xpath("//div[contains(@class,'flex-wrap')]//span[contains(@class,'cart-item-total')]");

    public static ProductPage getProductPage() {
        return new ProductPage();
    }

    public void loadProductPage(){
        DriverManager.getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=product/product&product_id=40&search=iphone");
    }

    public ProductPageValidator getValidator() {
        return ProductPageValidator.builder()
                .productBrand(getProductBrand())
                .productName(getProductName())
                .productCode(getProductCode())
                .productAvailability(getProductAvailability())
                .cartCount(Integer.valueOf(getCartCount())).build();
    }

    public String getProductName() {
        return DriverManager.getDriver().findElement(PRODUCT_NAME).getText();
    }

    public String getProductCode() {
        return DriverManager.getDriver().findElement(PRODUCT_CODE).getText();
    }

    public String getProductBrand() {
        return DriverManager.getDriver().findElement(PRODUCT_BRAND).getText();
    }

    public String getProductAvailability() {
        return DriverManager.getDriver().findElement(PRODUCT_AVAILABILITY).getText();
    }

    public String getCartCount() {
        return DriverManager.getDriver().findElement(CART_COUNT).getText();
    }
}
