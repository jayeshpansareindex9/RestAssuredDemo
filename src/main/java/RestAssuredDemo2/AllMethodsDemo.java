package RestAssuredDemo2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllMethodsDemo {
	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }
	@Test
	public void verifyAllMethods(){
		/**
		 * 
		 * POST Method
		 * 
		 **/
		Response POSTMethod  = RestAssured.given()
							    .header("Content-Type", "application/json").
								when().
						    	body("{\"name\":\"testRest1\",\"salary\":\"123\",\"age\":\"23\"}")
						    	.post("http://dummy.restapiexample.com/api/v1/create");
		
		int getStatusCodeForPOSTMethod = POSTMethod.getStatusCode();
		Assert.assertEquals(getStatusCodeForPOSTMethod, 200); // Check response status.
		
		JsonPath getPostMethodJsonPath = POSTMethod.jsonPath();
		String getPostMethodId = getPostMethodJsonPath.getString("id"); // get the user id

		Assert.assertEquals(getPostMethodJsonPath.getString("name"), "testRest1");
		Assert.assertEquals(getPostMethodJsonPath.getString("salary"), "123");
		Assert.assertEquals(getPostMethodJsonPath.getString("age"), "23");
		
		String getBodyResponce = POSTMethod.getBody().asString();
		System.out.println("Post Method result is="+getBodyResponce);

		/**
		 * GET Method
		 * 
		 * */
		Response GETMethod  = RestAssured.given()
						    .header("Content-Type", "application/json").
							when()
							.get("http://dummy.restapiexample.com/api/v1/employee/"+getPostMethodId+"");
					    	
		int getStatusCodeForGETMethod = GETMethod.getStatusCode();
		Assert.assertEquals(getStatusCodeForGETMethod, 200); // Check response status.
		
		JsonPath getMethodJsonPath = GETMethod.jsonPath();
		
		Assert.assertEquals(getMethodJsonPath.getString("employee_name"), "testRest1");
		Assert.assertEquals(getMethodJsonPath.getString("employee_salary"), "123");
		Assert.assertEquals(getMethodJsonPath.getString("employee_age"), "23");
		
		String getMethodBodyResponce = GETMethod.getBody().asString();
		System.out.println("GET Method result is="+getMethodBodyResponce);
		
		/**
		 * 
		 * UPDATE Method
		 * 
		 * **/
		Response UPDATEMethod  = RestAssured.given()
							    .header("Content-Type", "application/json").
								when().
						    	body("{\"name\":\"testupdate1\",\"salary\":\"1123456789\",\"age\":\"23\"}")
						    	.put("	http://dummy.restapiexample.com/api/v1/update/"+getPostMethodId+"");
	
		int getUpdatedStatusCode = UPDATEMethod.getStatusCode();
		Assert.assertEquals(getUpdatedStatusCode, 200); // Check response status.
		
		JsonPath getUpdateMethodJsonPath = UPDATEMethod.jsonPath();
		
		Assert.assertEquals(getUpdateMethodJsonPath.getString("name"), "testupdate1");
		Assert.assertEquals(getUpdateMethodJsonPath.getString("salary"), "1123456789");
		Assert.assertEquals(getUpdateMethodJsonPath.getString("age"), "23");
		
		String getUpdateBodyResponce = UPDATEMethod.getBody().asString();
		System.out.println("Put Method result is="+getUpdateBodyResponce);
		
		/**
		 * 
		 * Delete Method
		 * */
		Response DELETEMethod  = RestAssured.given()
							    .header("Content-Type", "application/json").
								when()
								.delete("http://dummy.restapiexample.com/api/v1/delete/"+getPostMethodId +"");
		int getDeleteStatusCode = DELETEMethod.getStatusCode();
		Assert.assertEquals(getDeleteStatusCode, 200);
		String getDeleteBodyResponce = DELETEMethod.getBody().asString();
		Assert.assertEquals(getDeleteBodyResponce.contains("successfully! deleted Records"), true);
		
		System.out.println("Delete Method Result is ="+getDeleteBodyResponce);	
	}	
}
