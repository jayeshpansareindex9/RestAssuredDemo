package RestAssuredDemoProject.RestAssuredDemoProject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteDemo {

	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }
	@Test
    public void demoDeleteMethod(){
    	
    	RequestSpecification httpRequest = RestAssured.given();
    	httpRequest.contentType(ContentType.JSON);
    	
    	Response getDeleteResponce = httpRequest
    			.contentType("application/json")
    			.delete("http://dummy.restapiexample.com/api/v1/delete/35043");
    	int getDeleteResult = getDeleteResponce.statusCode();
    	Assert.assertEquals(getDeleteResult, 200);
    }
}
