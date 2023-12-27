package demo.customassert;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

public class ProductPageAssert extends AbstractAssert<ProductPageAssert, ProductPageValidator> {

    SoftAssertions assertions;
    private ProductPageAssert(ProductPageValidator productPageValidator) {
        super(productPageValidator, ProductPageAssert.class);
        assertions=new SoftAssertions();
    }

    public static ProductPageAssert assertThat(ProductPageValidator productPageValidator){
        return new ProductPageAssert(productPageValidator);
    }

    public ProductPageAssert productNameIs(String productName){
        assertions.assertThat(actual.getProductName()).isEqualTo(productName);
        return this;
    }
    public ProductPageAssert productCodeIs(String productCode){
        assertions.assertThat(actual.getProductCode()).isEqualTo(productCode);
        return this;
    }
    public ProductPageAssert productBrandIs(String productBrand){
        assertions.assertThat(actual.getProductBrand()).isEqualTo(productBrand);
        return this;
    }
    public ProductPageAssert productAvailabilityIs(String productAvailability){
        assertions.assertThat(actual.getProductAvailability()).isEqualTo(productAvailability);
        return this;
    }
    public ProductPageAssert matchesDefaultCartCount(){
        assertions.assertThat(actual.getCartCount()).isEqualTo(0);
        return this;
    }
    public void assertAll(){
        assertions.assertAll();
    }
}
