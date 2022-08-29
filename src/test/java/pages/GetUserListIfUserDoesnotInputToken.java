package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetUserListIfUserDoesnotInputToken extends Setup {

    public void callingGetUserListAPIWithoutInputtingToken() throws IOException {
        prop.load(file);
        RestAssured.baseURI=prop.getProperty("baseUrl");
        Response res=
                given()
                        .contentType("application/json")
                        .header("Authorization",prop.getProperty("token2")).

                        when()
                        .get("/user/list").


                        then()
                        .assertThat().statusCode(401).extract().response();

        JsonPath response=res.jsonPath();
        Assert.assertEquals(response.get("error.message").toString(),"No Token Found!");
        System.out.println(response.get("error.message").toString());

    }

}
