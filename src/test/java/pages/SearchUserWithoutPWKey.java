package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SearchUserWithoutPWKey extends Setup {

    public void callingSearchUserAPI() throws IOException {
        prop.load(file);
        RestAssured.baseURI=prop.getProperty("baseUrl");
        Response res=
                given()
                        .contentType("application/json")
                        .header("Authorization",prop.getProperty("token")).

                        when()
                        .get("/user/search/?4746").


                        then()
                        .assertThat().statusCode(401).extract().response();

        JsonPath response=res.jsonPath();
        Assert.assertEquals(response.get("error.message").toString(),"Secret auth key validation failure!");
        System.out.println(res.asString());


    }
}
