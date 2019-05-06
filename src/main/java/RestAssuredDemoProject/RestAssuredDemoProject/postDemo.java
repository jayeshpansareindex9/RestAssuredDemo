package RestAssuredDemoProject.RestAssuredDemoProject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class postDemo {

	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }
	/**
     * 
     * Demo Post method
     * */
    
    @Test
    public void demoPostMethod(){
    	
    	RequestSpecification httpRequest = RestAssured.given();
    	httpRequest.contentType(ContentType.JSON);
    	
    	Response getPostResponce = httpRequest
    			.contentType("application/json")
    			.body("{\"name\":\"testRest1233\",\"salary\":\"12000\",\"age\":\"23\"}")
    			.post("http://dummy.restapiexample.com/api/v1/create");
    	
    	Assert.assertEquals(getPostResponce.statusCode(), 200); // For create a new user status is 201
    	
    	String getBodyResponce = getPostResponce.getBody().asString();
    	System.out.println(getBodyResponce);
    	Assert.assertEquals(getBodyResponce.contains("testRest123"), true);
    	Assert.assertEquals(getBodyResponce.contains("12000"), true);
    	Assert.assertEquals(getBodyResponce.contains("23"), true);
    }
}
