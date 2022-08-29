package pages;

import Utils.Utils;
import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.CreateNewUserModel;
import org.apache.commons.configuration.ConfigurationException;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CreateNewUser extends Setup {

    public void callingCreateNewUserAPI() throws IOException, ConfigurationException {

        prop.load(file);

        String name = "customer" +(int)(Math.random() * (100 - 10) + 100);
        //System.out.println(name);
        String email =(int)(Math.random() * (9999 - 1000) + 9999) + "@gmail.com";
        //System.out.println(email);
        String password = (int)(Math.random() * (100 - 10) + 100)+ "a";
       // System.out.println(password);
        String phone_number = "012345" + (int)(Math.random() * (90000 - 10000) + 90000);
        String nid = (Math.random() * (999 - 100) + 999) + "1";
        String role = "Customer";

        CreateNewUserModel createNewUserModel = new CreateNewUserModel(name, email, password, phone_number, nid, role);
        RestAssured.baseURI = prop.getProperty("baseUrl");

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("X-AUTH-SECRET-KEY"))

                        .body(createNewUserModel)./*"{\n" +
                                "    \"name\":\"{{$randomFullName}}\",\n" +
                                "    \"email\":\"{{$randomEmail}}\",\n" +
                                "    \"password\":\"{{$randomPassword}}\",\n" +
                                "    \"phone_number\":\"{{phoneNumber}}\",\n" +
                                "    \"nid\":\"{{nid}}\",\n" +
                                "    \"role\":\"Customer\"\n" +
                                "}"*/
                        when()
                        .post("/user/create").


                        then()
                        .assertThat().statusCode(201).extract().response();

        JsonPath response = res.jsonPath();
        String id=response.get("user.id").toString();
        Utils utils=new Utils();
        utils.setEnvVariable1(id);
        System.out.println(res.asString());
    }

}


