package RestAssuredDemoProject.RestAssuredDemoProject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
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
    	
		Response UPDATEMethod  = RestAssured.given()
			    .header("Content-Type", "application/json")
			    .when()
				.body("{\"name\":\"testupdate1\",\"salary\":\"11000\",\"age\":\"23\"}")
		    	.put("http://dummy.restapiexample.com/api/v1/update/55760");
				
				//Check response status.
				int getUpdatedStatusCode = UPDATEMethod.getStatusCode();
				Assert.assertEquals(getUpdatedStatusCode, 200);
				
				//Convert result to JSON format
				JsonPath getUpdateMethodJsonPath = UPDATEMethod.jsonPath();
				
				// Assertion
				Assert.assertEquals(getUpdateMethodJsonPath.getString("name"), "testupdate1");
				Assert.assertEquals(getUpdateMethodJsonPath.getString("salary"), "11000");
				Assert.assertEquals(getUpdateMethodJsonPath.getString("age"), "23");
				
				String getUpdateBodyResponce = UPDATEMethod.getBody().asString();
				System.out.println("Put Method result is="+getUpdateBodyResponce);
    }
}
