import com.google.common.annotations.VisibleForTesting;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

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
//https://api.telegram.org/bot1017809460:AAE4PO3os7ht_AraJ7J8MvYW6UTRMzl--3w/sendMessage?text=pi&chat_id=196918542
    @Test
    void checkTipesTest(){
        List<DataUser> list = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"sendMessage?text=pi&chat_id=196918542")
                .then().log().all()
                .extract().body().jsonPath().getList("result",DataUser.class);


    }
}
