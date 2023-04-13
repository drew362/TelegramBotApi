import com.google.common.annotations.VisibleForTesting;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BotTests {

    private final static String URL = "https://api.telegram.org/bot1017809460:AAE4PO3os7ht_AraJ7J8MvYW6UTRMzl--3w/";

    @Test
    void succesSendMessageTest() {
        given()
                .baseUri(URL)
                .param("text", "rest")
                .param("chat_id", "196918542")
                .when()
                .get("/sendMessage")
                .then()
                .statusCode(200);
    }

    @Test
    void checkTipesTest() {
        List<DataUser> list = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "sendMessage?text=pi&chat_id=196918542")
                .then().log().all()
                .extract().body().jsonPath().getList("result.chat", DataUser.class);
    }

    @Test
    void numberChatIdTest() {
        given()
                .baseUri(URL)
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "sendMessage?text=pi&chat_id=196918542")
                .then().statusCode(200).log().all()
                .body("result.chat.id", equalTo(196918542));
    }
}
