package tests.api;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.and;

public class PrivatCurrencyTest extends BaseApiTest {

    //          https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5

    @Test
    public void checkJsonCurrencyAPI() {
        given()
                .queryParam("json")
                .queryParam("exchange")
                .queryParam("coursid", 5)
                .log()
                .all()
                .when()
                .get("https://api.privatbank.ua/p24api/pubinfo")
                .then()
                .log()
                .all()
                .statusCode(200);
    }



 /*
        Map<String, Object> body = new HashMap<>();
        Map<String, String> data = new HashMap<>();

        body.put("status", "active");

        data.put("key", "value");
        body.put("data", data);

        List<String> result = given()
                .spec(this.reqSpec)
                .queryParam("json")
                .queryParam("exchange")
                .queryParam("coursid", 5)
                .when()
                .get("/pubinfo")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("exchangerates.row.exchangerate .ccy", hasItems(equalTo("USD"), equalTo("EUR"), equalTo("RUR")))
                .and()
                .extract()
                .xmlPath()
                .getList("exchangerates.row.exchangerate .ccy");
        result.forEach(System.out::println);
    }

  */
}