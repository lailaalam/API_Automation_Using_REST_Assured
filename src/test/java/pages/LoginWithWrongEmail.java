package pages;

import Utils.Utils;
import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.LoginModel;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class LoginWithWrongEmail extends Setup {
    public void callingLoginWithWrongEmailAPI() throws ConfigurationException, IOException {

        prop.load(file);
        LoginModel loginModel=new LoginModel("joe@example.com","1234");
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res=
                given()
                        .contentType("application/json")
                        .body(loginModel).
                        when()
                        .post("/user/login").


                        then()
                        .assertThat().statusCode(404).extract().response();

        JsonPath jsonPath=res.jsonPath();
        System.out.println(jsonPath.get("message").toString());
        Assert.assertEquals(jsonPath.get("message").toString(),"User not found");
    }
}
