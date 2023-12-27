package demo.customassert;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import java.util.function.Predicate;

public class APIAssert extends AbstractAssert<APIAssert, Response> {

    SoftAssertions assertions;
    private APIAssert(Response response) {
        super(response, APIAssert.class);
        assertions=new SoftAssertions();
    }

    public static APIAssert assertThat(Response response){
        return new APIAssert(response);
    }

    public APIAssert statusCodeIs(int statusCode){
        assertions.assertThat(actual.statusCode()).isEqualTo(statusCode);
        return this;
    }

    public APIAssert hasKeyWithValue(Predicate<Response> predicate){
        assertions.assertThat(predicate).accepts(actual);
        return this;
    }

    public void assertAll(){
        assertions.assertAll();
    }
}
