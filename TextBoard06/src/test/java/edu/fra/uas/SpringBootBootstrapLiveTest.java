package edu.fra.uas;

import org.springframework.http.MediaType;

import edu.fra.uas.text.model.Text;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import edu.fra.uas.text.model.Text;

public class SpringBootBootstrapLiveTest {

    private static final String API_ROOT
      = "http://localhost:8080/api/text";

    private Text createRandomText() {
        Text text = new Text();
        text.setTitle("Justi");
        text.setContent("Justiland");
        return text;
    }

    private String createBookAsUri(Text text) {
        Response response = RestAssured.given()
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .body(text)
          .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }
}
