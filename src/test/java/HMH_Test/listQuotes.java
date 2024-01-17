package HMH_Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class listQuotes extends baseTest {



    @Test
    public void testQuotesContainingWord() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .param("filter", "funny")
            .get("/quotes");

        System.out.println("Response for Quotes Containing Word: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        
    }

    @Test
    public void testQuotesWithTag() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .param("filter", "funny")
            .param("type", "tag")
            .get("/quotes");

        System.out.println("Response for Quotes with Tag: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        
    }

    @Test
    public void testQuotesByAuthor() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .param("filter", "Mark Twain")
            .param("type", "author")
            .get("/quotes");

        System.out.println("Response for Quotes by Author: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
       
    }

    @Test
    public void testPublicQuotesByUser() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .param("filter", "gose")
            .param("type", "user")
            .get("/quotes");

        System.out.println("Response for Public Quotes by User: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        
    }

    @Test
    public void testPrivateQuotes() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .param("private", "1")
            .get("/quotes");

        System.out.println("Response for Private Quotes: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        
    }

    @Test
    public void testPrivateQuotesContainingWords() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .param("filter", "little book")
            .param("private", "1")
            .get("/quotes");

        System.out.println("Response for Private Quotes Containing Words: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        
    }

    @Test
    public void testHiddenQuotes() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Token token=" + API_KEY)
            .param("hidden", "1")
            .get("/quotes");

        System.out.println("Response for Hidden Quotes: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        
    }
}