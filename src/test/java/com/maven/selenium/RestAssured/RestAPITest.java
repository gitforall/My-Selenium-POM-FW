package com.maven.selenium.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAPITest {

	// @Test()
	public void rally() { // username password

		System.out.println("Hhhhhhhhhhhhhhhhhh");
		given().contentType(ContentType.JSON)
				.auth()
				.preemptive()
				.basic("nostgusr@cisco.com", "nostg123")
				.and()
				.get("https://rally1.rallydev.com/slm/webservice/v2.0/portfolioitem/feature?project=https://rally1.rallydev.com/slm/webservice/v2.0/"
						+ "project/52458240574&query=&start=1&pagesize=2000&fetch=Parent,c_ParentProject")
				// fetch=Parent,c_ParentProject

				.then()
				.body("title",
						hasItems(
								"sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
								"ea molestias quasi exercitationem repellat qui ipsa sit aut",
								"eum et est occaecati")).statusCode(200).log()
				.all();

		/*
		 * String s = given() .contentType(ContentType.JSON) .param("id", 5)
		 * .param("name", "vero eaque aliquid doloribus et culpa").when()
		 * .get("https://jsonplaceholder.typicode.com/posts/1/comments")
		 * .thenReturn().asString();
		 */

		/*
		 * given().accept(ContentType.JSON) .when() .get(
		 * "https://rally1.rallydev.com/slm/webservice/v2.0/portfolioitem/feature?project=https://rally1.rallydev.com/slm/webservice/v2.0/project/52458240574&query=&start=1&pagesize=2000&fetch=Parent,c_ParentProject"
		 * ) .then() .log().all();
		 */

		// .log().all();

	}

	// @Test(enabled = true, priority = 1)
	public void testStatusCode() {

		System.out.println("Hhhhhhhhhhhhhhhhhh");
		given().accept(ContentType.JSON)
				.when()
				.get("https://jsonplaceholder.typicode.com/posts")
				.then()
				.body("[0].userId", equalTo(1))
				.body("[2].id", equalTo(3))
				.body("title",
						hasItems(
								"sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
								"ea molestias quasi exercitationem repellat qui ipsa sit aut",
								"eum et est occaecati"));
		// .log().all();

	}

	// @Test
	public void jsonpath() {

		String s = given().accept(ContentType.JSON).when()
				.get("https://jsonplaceholder.typicode.com/posts").thenReturn()
				.asString();

		// System.out.println(s);
		JsonPath json = new JsonPath(s);

		System.out.println(" Hari  " + json.getInt("[2].id"));

		// .body("versie", equalTo(11.0f));
		// .body("userId", hasItem("1"))
		// .body("id", equalTo(Arrays.asList("1")));
	}

	// @Test()
	@Parameters({ "number-of-times" })
	public void accessPage(int numberOfTimes) {
		while (numberOfTimes-- > 0) {
			// access the web page
		}
	}

	@Test
	public void jsonQuery() {

		String s = given().contentType(ContentType.JSON).param("id", 5)
				.param("name", "vero eaque aliquid doloribus et culpa").when()
				.get("https://jsonplaceholder.typicode.com/posts/1/comments")
				.thenReturn().asString();

		// System.out.println(s);

		JsonPath js = new JsonPath(s);

		System.out.println(js.getString("[0].email"));
		Assert.assertEquals(js.getString("[0].email"), "Hayden@althea.biz");// Hayden@althea.biz

	}

	// @Test
	public void sampleTest() {

		Response response = get("http://restcountries.eu/rest/v1/name/norway");
		System.out.println(response.getBody().jsonPath());
		int code = response.getStatusCode();
		System.out.println(code);
	}

}
