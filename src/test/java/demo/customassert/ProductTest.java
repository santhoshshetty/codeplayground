package demo.customassert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @Test(description = "Test Assertions using AssertJ")
    public void verifyLoginPageSpec(){
        ProductPage productPage=ProductPage.getProductPage();
        productPage.loadProductPage();
        ProductPageAssert productAssert=new ProductPageAssert(productPage.getValidator());
        productAssert
                .productNameIs("iPhone")
                .productCodeIs("product 11")
                .productAvailabilityIs("In Stock")
                .productBrandIs("Apple")
                .matchesDefaultCartCount()
                .assertAll();
    }
}
