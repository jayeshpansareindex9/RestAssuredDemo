package RestAssuredDemoProject.RestAssuredDemoProject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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
    	//Generate a random number
    	int random = (int)(Math.random() * 50 + 1);
    	
    	Response POSTMethod  = RestAssured.given()
			    .header("Content-Type", "application/json")
			    .when()
			    .body("{\"name\":\"testRest"+random+"\",\"salary\":\"12000\",\"age\":\"23\"}")
		    	.post("http://dummy.restapiexample.com/api/v1/create");
    			
    			//Check response status.
    			int getStatusCodeForPOSTMethod = POSTMethod.getStatusCode();
    			Assert.assertEquals(getStatusCodeForPOSTMethod, 200); 

    			//Convert result to JSON format
				JsonPath getPostMethodJsonPath = POSTMethod.jsonPath();
				
				//Get the user id
				String getPostMethodId = getPostMethodJsonPath.getString("id"); 
				
				// Assertion
				Assert.assertEquals(getPostMethodJsonPath.getString("name"), "testRest"+random+"");
				Assert.assertEquals(getPostMethodJsonPath.getString("salary"), "12000");
				Assert.assertEquals(getPostMethodJsonPath.getString("age"), "23");
				
				String getBodyResponce = POSTMethod.getBody().asString();
				System.out.println("Post Method result is="+getBodyResponce);
    }
}
