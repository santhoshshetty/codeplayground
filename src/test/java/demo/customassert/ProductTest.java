package demo.customassert;

import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @Test(description = "Test Assertions using AssertJ")
    public void verifyLoginPageSpec(){
        ProductPage productPage=ProductPage.getProductPage();
        productPage.loadProductPage();
        ProductPageAssert.assertThat(productPage.getValidator())
                .productNameIs("iPhone")
                .productCodeIs("product 11")
                .productAvailabilityIs("In Stock")
                .productBrandIs("Apple")
                .matchesDefaultCartCount()
                .assertAll();
    }
}
