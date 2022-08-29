package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetUserListIfInputWrongToken  extends Setup {
    public void callingGetUserListIfInputWrongToken() throws IOException {
        prop.load(file);
        RestAssured.baseURI=prop.getProperty("baseUrl");
        Response res=
                given()
                        .contentType("application/json")
                        .header("Authorization",prop.getProperty("token1")).

                        when()
                        .get("/user/list").


                        then()
                        .assertThat().statusCode(403).extract().response();

        JsonPath response=res.jsonPath();
        Assert.assertEquals(response.get("error.message").toString(),"Token expired!");
        System.out.println(response.get("error.message").toString());


    }
}
