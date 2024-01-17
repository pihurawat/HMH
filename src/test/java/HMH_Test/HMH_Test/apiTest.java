package HMH_Test.HMH_Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class apiTest {
	 private static final String API_KEY = "a2e931d9245cf987424de98c8c837d1b";

	    @BeforeClass
	    public void setup() {
	        RestAssured.baseURI = "https://favqs.com/api";
	    }


    @Test
    public void testInvalidAuthorization() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=invalid_api_key")
            .when()
            .get("/qotd");

        System.out.println("Test Case: testInvalidAuthorization");
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 401);
    }

	@Test
    public void testFavQuote() {

		String quoteId = "4";
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .when()
            .put("/quotes/" + quoteId + "/fav");

        System.out.println("Test Case: testFavQuote");
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testListQuotes() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .when()
            .get("/quotes");

        System.out.println("Test Case: testListQuotes");
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("quotes").size() > 0);
    }

		

}
