package RestAssuredDemoProject.RestAssuredDemoProject;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class getDemo {

	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }
	/**
     * Demo Get API
     * 
     * */
    @Test
     public void demoGetMethod(){
    	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    	RequestSpecification httpRequest = RestAssured.given();
    	Response response = httpRequest.get("/Hyderabad");
    	
    	// First get the JsonPath object instance from the Response interface
    	JsonPath jsonPathEvaluator = response.jsonPath();
    	
    	// get body
    	ResponseBody getResultBody = response.getBody();
    	String getResultBodyToString= getResultBody.asString();
    	System.out.println(getResultBodyToString);
    	
    	Assert.assertEquals(getResultBodyToString.contains("Hyderabad"), true);
    	
    	//get header
    	Headers getResultHeader = response.getHeaders();
    	String getResultHeaderToString = getResultHeader.toString();
    	System.out.println(getResultHeaderToString);
    }
}
