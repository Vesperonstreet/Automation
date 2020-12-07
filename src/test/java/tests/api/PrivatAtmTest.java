package tests.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PrivatAtmTest extends BaseApiTest {

    //   https://api.privatbank.ua/p24api/infrastructure?json&atm&address=&city=

    @Test
    public void checkJsonPrivatATM() {
        given()
                .spec(reqSpec)
                .queryParam("json")
                .queryParam("atm")
                .queryParam("address", "Украина,область Харьковская,город Харьков")
                .queryParam("city", "Харьков")
                .log()
                .all(true)
                .when()
                .get("/infrastructure")
                .then()
                .log()
                .all(true)
                .spec(resSpec)
                .body("devices.type", hasItem("atm"),
                        "devices.tw.mon", hasItem("00:00 - 23:59"),
                        "devices.tw.tue", hasItem("00:00 - 23:59"),
                        "devices.placeRu", hasItem("ТЦ Рост"),
                        "devices.cityEN", hasItem("Kharkiv"))
                .body("city", equalTo("Харьков"));
    }
}