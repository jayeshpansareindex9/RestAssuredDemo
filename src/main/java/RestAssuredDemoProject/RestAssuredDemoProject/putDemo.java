package RestAssuredDemoProject.RestAssuredDemoProject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class putDemo {

	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }
	@Test
    public void demoUpdateMethod(){
    	
    	RequestSpecification httpRequest = RestAssured.given();
    	httpRequest.contentType(ContentType.JSON);
    	
    	Response getPutResponce = httpRequest
    			.contentType("application/json")
    			.body("{\"name\":\"testrestupdate\",\"salary\":\"19\",\"age\":\"44\"}")
    			.put("http://dummy.restapiexample.com/api/v1/update/35043");
    	Assert.assertEquals(getPutResponce.statusCode(), 200);
    	String getBodyResponce = getPutResponce.getBody().asString();
    	System.out.println(getBodyResponce);
    	Assert.assertEquals(getBodyResponce.contains("testrestupdate"), true);
    	Assert.assertEquals(getBodyResponce.contains("19"), true);
    	Assert.assertEquals(getBodyResponce.contains("44"), true);
    }
}
