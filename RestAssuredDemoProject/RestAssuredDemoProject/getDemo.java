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
    	Response GETMethod  = RestAssured.given()
			    .header("Content-Type", "application/json")
			    .when()
				.get("http://dummy.restapiexample.com/api/v1/employee/5576");
		    	
    			//Check response status.
				int getStatusCodeForGETMethod = GETMethod.getStatusCode();
				Assert.assertEquals(getStatusCodeForGETMethod, 200); // Check response status.
				
				//Convert result to JSON format
				JsonPath getMethodJsonPath = GETMethod.jsonPath();
				
				// Assertion
				Assert.assertEquals(getMethodJsonPath.getString("employee_name"), "testRest1");
				Assert.assertEquals(getMethodJsonPath.getString("employee_salary"), "12000");
				Assert.assertEquals(getMethodJsonPath.getString("employee_age"), "23");
				
				String getMethodBodyResponce = GETMethod.getBody().asString();
				System.out.println("GET Method result is="+getMethodBodyResponce);
    }
}
