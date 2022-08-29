package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UpdateSpecificInfo extends Setup {

    public void callingUpdateSpecificUserAPI() throws IOException {
     prop.load(file);
    RestAssured.baseURI =prop.getProperty("baseUrl");
    Response res =
            given()
                    .contentType("application/json")
                    .header("Authorization", prop.getProperty("token"))
                    .header("X-AUTH-SECRET-KEY",prop.getProperty("X-AUTH-SECRET-KEY"))

                    .body("{\n" +
                            "    \n" +
                            "    \"role\": \"Customer\"\n" +
                            "}").
                    when()
                    .patch("/user/update/"+prop.getProperty("id")).


                    then()
                    .assertThat().statusCode(200).extract().response();

    JsonPath response=res.jsonPath();
   // System.out.println(response.get("user").toString());
        System.out.println(res.asString());


}
}
