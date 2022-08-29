package pages;

import Utils.Utils;
import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.LoginModel;
import org.apache.commons.configuration.ConfigurationException;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class LoginCustomer extends Setup {


    public void callingLoginAPI() throws ConfigurationException, IOException {

        prop.load(file);
        LoginModel loginModel=new LoginModel("joel.hubert@example.com","1234");
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res=
                given()
                        .contentType("application/json")
                        .body(loginModel).
                when()
                        .post("/user/login").


                then()
                         .assertThat().statusCode(200).extract().response();

        JsonPath jsonPath=res.jsonPath();
        String token=jsonPath.get("token");
        Utils utils=new Utils();
        utils.setEnvVariable(token);
       // System.out.println(token);
    }
}
