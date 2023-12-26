package demo.customassert;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class ProductPageValidator {

    private String productName;
    private String productCode;
    private String productAvailability;
    private String productBrand;
    private Integer cartCount;

}
