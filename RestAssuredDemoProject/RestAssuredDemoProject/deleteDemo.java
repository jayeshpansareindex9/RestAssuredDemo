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
    	
		Response DELETEMethod  = RestAssured.given()
			    .header("Content-Type", "application/json")
			    .when()
				.delete("http://dummy.restapiexample.com/api/v1/delete/55760");
		
		//Check response status.
		int getDeleteStatusCode = DELETEMethod.getStatusCode();
		Assert.assertEquals(getDeleteStatusCode, 200);
		
		// Assertion
		String getDeleteBodyResponce = DELETEMethod.getBody().asString();
		Assert.assertEquals(getDeleteBodyResponce.contains("successfully! deleted Records"), true);

    }
}
