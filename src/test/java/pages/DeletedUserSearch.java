package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DeletedUserSearch extends Setup {
    public void searchDeletedAPI() throws IOException {
        prop.load(file);
        RestAssured.baseURI =prop.getProperty("baseUrl");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("X-AUTH-SECRET-KEY")).
                        when()
                        .get("/user/search?"+"id="+prop.getProperty("id")).


                        then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath response=res.jsonPath();
        Assert.assertEquals(res.asString(),"{\"user\":null}");
        System.out.println(res.asString());
    }
}
