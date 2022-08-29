package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetUserList extends Setup {
    public void callingGetUserListAPI() throws IOException {
        prop.load(file);
        RestAssured.baseURI=prop.getProperty("baseUrl");
        Response res=
                given()
                        .contentType("application/json")
                                .header("Authorization",prop.getProperty("token")).

                        when()
                        .get("/user/list").


                        then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath response=res.jsonPath();
        Assert.assertEquals(response.get("users[0].id").toString(),"33");
        System.out.println(response.get("users[0]").toString());
    }

}
