package tests.api.nova_poshta;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import tests.api.BaseApiTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class NpSearchSettElementsTest extends BaseApiTest {

    private static final String API_KEY = "[ВАШ КЛЮЧ]";

    private Map<String, Object> reqBody = new HashMap<>();

    @Before
    public void setReqBody() {
        Map<String, Object> methodProperties = new HashMap<>();

        methodProperties.put("CityName", "київ");
        methodProperties.put("Limit", 5);

        reqBody.put("calledMethod", "searchSettElements");
        reqBody.put("methodProperties", methodProperties);
        reqBody.put("modelName", "Address");
        reqBody.put("apiKey", API_KEY);
    }

    @Test
    public void checkSettElements() {
        given()
                .spec(this.reqSpec)
                .baseUri("http://testapi.novaposhta.ua/v2.0")
                .body(this.reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post("/json/Address/searchSettElements/")
                .then()
                .spec(this.resSpec);
    }
}