package RestAssuredDemo2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllMethodsDemo {
	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }
	@Test
	public void verifyAllMethods(){
		//Generate a random number
    	int random = (int)(Math.random() * 50 + 1);
    	
		/**
		 * 
		 * POST Method
		 * 
		 **/
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

		/**
		 * GET Method
		 * 
		 * */
		Response GETMethod  = RestAssured.given()
						    .header("Content-Type", "application/json")
						    .when()
							.get("http://dummy.restapiexample.com/api/v1/employee/"+getPostMethodId+"");
		
		//Check response status.
		int getStatusCodeForGETMethod = GETMethod.getStatusCode();
		Assert.assertEquals(getStatusCodeForGETMethod, 200);
		
		//Convert result to JSON format
		JsonPath getMethodJsonPath = GETMethod.jsonPath();
		
		// Assertion
		Assert.assertEquals(getMethodJsonPath.getString("employee_name"), "testRest"+random+"");
		Assert.assertEquals(getMethodJsonPath.getString("employee_salary"), "12000");
		Assert.assertEquals(getMethodJsonPath.getString("employee_age"), "23");
		
		String getMethodBodyResponce = GETMethod.getBody().asString();
		System.out.println("GET Method result is="+getMethodBodyResponce);
		
		/**
		 * 
		 * UPDATE Method
		 * 
		 * **/
		Response UPDATEMethod = RestAssured.given()
							    .header("Content-Type", "application/json")
							    .when()
							    .body("{\"name\":\"testupdate"+random+"\",\"salary\":\"11000\",\"age\":\"23\"}")
						    	.put("http://dummy.restapiexample.com/api/v1/update/"+getPostMethodId+"");
	
		//Check response status.
		int getUpdatedStatusCode = UPDATEMethod.getStatusCode();
		Assert.assertEquals(getUpdatedStatusCode, 200);
		
		//Convert result to JSON format
		JsonPath getUpdateMethodJsonPath = UPDATEMethod.jsonPath();
		
		// Assertion
		Assert.assertEquals(getUpdateMethodJsonPath.getString("name"), "testupdate"+random+"");
		Assert.assertEquals(getUpdateMethodJsonPath.getString("salary"), "11000");
		Assert.assertEquals(getUpdateMethodJsonPath.getString("age"), "23");
		
		String getUpdateBodyResponce = UPDATEMethod.getBody().asString();
		System.out.println("Put Method result is="+getUpdateBodyResponce);
		
		/**
		 * 
		 * Delete Method
		 * */
		Response DELETEMethod  = RestAssured.given()
							    .header("Content-Type", "application/json")
							    .when()
								.delete("http://dummy.restapiexample.com/api/v1/delete/"+getPostMethodId +"");
		
		//Check response status.
		int getDeleteStatusCode = DELETEMethod.getStatusCode();
		Assert.assertEquals(getDeleteStatusCode, 200);
		
		// Assertion
		String getDeleteBodyResponce = DELETEMethod.getBody().asString();
		Assert.assertEquals(getDeleteBodyResponce.contains("successfully! deleted Records"), true);
		
		System.out.println("Delete Method Result is ="+getDeleteBodyResponce);	
	}	
}
