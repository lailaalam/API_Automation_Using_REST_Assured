package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.LoginModel;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class LoginWithWrongPassword extends Setup {
    public void callingLoginWithWrongPasswordAPI() throws IOException {
        prop.load(file);
        LoginModel loginModel=new LoginModel("joel.hubert@example.com","12");
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res=
                given()
                        .contentType("application/json")
                        .body(loginModel).
                        when()
                        .post("/user/login").


                        then()
                        .assertThat().statusCode(401).extract().response();

        JsonPath jsonPath=res.jsonPath();
        System.out.println(jsonPath.get("message").toString());
        Assert.assertEquals(jsonPath.get("message").toString(),"Password incorrect");
    }
}
