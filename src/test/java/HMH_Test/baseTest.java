package HMH_Test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class baseTest {

    public static String API_KEY = "a2e931d9245cf987424de98c8c837d1b";

	    @BeforeClass
	    public void setup() {
	        RestAssured.baseURI = "https://favqs.com/api/";
	    }
    
}
