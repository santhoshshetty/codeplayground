package demo.customassert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.function.Predicate;

import static demo.customassert.APIAssert.assertThat;

public class APITest {

    @Test
    public void apiAssertTest(){
        Response response=RestAssured.given().get("https://reqres.in/api/users/2");
        Predicate<Response> keyValue=res -> res.jsonPath().getInt("data.id")==2;
        assertThat(response)
                .statusCodeIs(200)
                .hasKeyWithValue(keyValue)
                .assertAll();
    }
}
