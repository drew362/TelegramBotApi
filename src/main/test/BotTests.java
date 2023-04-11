import com.google.common.annotations.VisibleForTesting;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BotTests {

    private final static String URL = "https://api.telegram.org/bot1017809460:AAE4PO3os7ht_AraJ7J8MvYW6UTRMzl--3w/";
    @Test
    void succesSendMessageTest(){
        RestAssured.baseURI = "https://api.telegram.org/bot1017809460:AAE4PO3os7ht_AraJ7J8MvYW6UTRMzl--3w";
        given()
                .param("text","rest")
                .param("chat_id","196918542")
                .when()
                .get("/sendMessage")
                .then()
                .statusCode(200);
    }

    @Test
    void checkTipesTest(){

    }
}
