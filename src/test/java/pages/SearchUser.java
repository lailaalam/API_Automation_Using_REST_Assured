package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SearchUser extends Setup {
    public void callingSearchUserAPI() throws IOException {
        prop.load(file);
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("X-AUTH-SECRET-KEY")).
                        when()
                        .get("/user/search?id=4746").


                        then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath response = res.jsonPath();
        Assert.assertEquals(response.get("user.name").toString(), "Hugh Dare");
       System.out.println(response.get("user.name").toString());



    }


}
