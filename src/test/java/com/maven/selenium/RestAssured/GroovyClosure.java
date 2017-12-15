package com.maven.selenium.RestAssured;

import static org.testng.Assert.assertEquals;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class GroovyClosure {

	//@Test
	public void testFindUsingGroovyClosure() {
	  String json = get("http://restcountries.eu/rest/v1/name/norway").asString();
	  JsonPath jp = new JsonPath(json);
	  jp.setRoot("translations");
	  Map person = jp.get("find {e -> e.fr =~ /Nor@/}");
	  assertEquals("test@hascode.com", person.get("email"));
	  assertEquals("Tim", person.get("firstName"));
	  assertEquals("Testerman", person.get("lastName"));
	}
	
	@Test
	public void testGetSingleUserProgrammatic() {
	  Response res = get("http://restcountries.eu/rest/v1/name/norway");
	  assertEquals(200, res.getStatusCode());
	  String json = res.asString();
	  JsonPath jp = new JsonPath(json);
	//  assertEquals("NO", jp.get("alpha2Code[0]"));
	  //assertEquals("ingdom of Norway", jp.get("altSpellings[3]"));
	  System.out.println(jp.get("altSpellings[0]")); //Kingdom of Norway
	  //String usernames = res.jsonPath().getString("altSpellings[0]");
	  
	  String usernames = res.jsonPath().getString("username");
	  System.out.println(usernames);
	  String t = res.jsonPath().getString("username[0]");
        System.out.println(t);
	}
}
