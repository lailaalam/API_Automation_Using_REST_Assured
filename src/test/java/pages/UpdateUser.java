package pages;

import base.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.io.IOException;


import static io.restassured.RestAssured.given;

public class UpdateUser extends Setup {


    public void callingUpdateUserAPI() throws IOException {
        prop.load(file);
        RestAssured.baseURI =prop.getProperty("baseUrl");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("X-AUTH-SECRET-KEY"))

                        .body("{\n" +
                                "    \n" +
                                "    \"name\": \"Test Engineer\",\n" +
                                "    \"email\": \"1234@gmail.com\",\n" +
                                "    \"password\": \"joel.hubert@\",\n" +
                                "    \"phone_number\": \"01543223457\",\n" +
                                "    \"nid\": \"123456798\",\n" +
                                "    \"role\": \"Student\"\n" +
                                "}").
                        when()
                        .put("/user/update/"+prop.getProperty("id")).


                        then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath response=res.jsonPath();
        System.out.println(response.get("user").toString());


    }

}

