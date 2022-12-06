import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Basic {
    public static void main(String[] args){
        //Given endpoint with all details
        //When I submit request
        //Then validate the response

        baseURI = "https://simple-tool-rental-api.glitch.me";
        //Get method
        given().header("Content-Type", "application/json")
                .when().get("status")
                .then().log().all().assertThat().statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8");

        //Post
        String resToken = given().header("Content-Type", "application/json")
                .body(Payload.requestBody())
                .when().post("api-clients")
                .then().log().all().assertThat().statusCode(201)
                .header("Content-Type","application/json; charset=utf-8")
                .extract().response().asString();
        System.out.println(resToken);
        JsonPath js = new JsonPath(resToken);
        String token = js.getString("accessToken");
        System.out.println("Token: " + token);
        JsonPath js2 = Utils.stringToJsonPath(resToken);
        System.out.println("Token: " + js2.getString("accessToken"));

        //post
        Map m = new HashMap();
        m.put("Authorization", "Bearer " + token);
        m.put("Content-Type", "application/json");
        String response = given().headers(m)
                .body(Order.requestBody())
                .when().post("orders")
                .then().log().all().assertThat().statusCode(201)
                .body("created", equalTo(true))
                .header("Content-Type","application/json; charset=utf-8")
                .extract().response().asString();
        System.out.println(response);
        JsonPath js3 = Utils.stringToJsonPath(response);
        String orderId = js3.getString("orderId");
        String isCreated = js3.getString("created");
        System.out.println("OrderId: " + orderId);

        Assert.assertEquals(isCreated, "true");

        //Serialization
        Order o = new Order("4643", "Tam Huynh 2");
        //OrderResult or = new OrderResult(false, "");
        OrderResult or = given().headers(m)
                .body(o)
                .when().post("orders").as(OrderResult.class);
        System.out.println("Created: " + or.isCreated());
        System.out.println("OrderId: " + or.getOrderId());

        //Deserialization
    }
}
