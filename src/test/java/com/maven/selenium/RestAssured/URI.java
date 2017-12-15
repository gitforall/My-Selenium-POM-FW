package com.maven.selenium.RestAssured;

import io.restassured.RestAssured;

public class URI {

	public static void baseURI() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.port = 80;
		RestAssured.basePath = "/posts";
	//	RestAssured.authentication = basic("username", "password");
	//	RestAssured.rootPath = "x.y.z";
	}

}
