import io.restassured.path.json.JsonPath;

public class Utils {
    public static JsonPath stringToJsonPath(String body){
        return new JsonPath(body);
    }
}
