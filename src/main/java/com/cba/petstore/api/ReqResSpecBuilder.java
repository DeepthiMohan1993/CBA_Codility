package com.cba.petstore.api;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpecBuilder {

	public static RequestSpecification getRequestSpec(String uri) {
		return new RequestSpecBuilder().
				setBaseUri(uri).
				setContentType(ContentType.JSON).
				build();			
	}
	
	public static  ResponseSpecification getResponseSpec(int statusCode) {
		return new ResponseSpecBuilder().
				expectStatusCode(statusCode).
				build();
				
	}
	
	public static RequestSpecification getRequestSpecWithQuery(String uri,String query, String param) {
		return new RequestSpecBuilder().
				setBaseUri(uri).
				addQueryParam(query, param).
				setContentType(ContentType.JSON).
				build();			
	}
	
	public static RequestSpecification getRequestSpecUpload(String uri,String parameter,String value) {
		return new RequestSpecBuilder().
				setBaseUri(uri).
				addPathParam(parameter, value).
				setContentType(ContentType.MULTIPART).
				build();			
	}
	
	public static RequestSpecification getRequestSpecWithPathParam(String uri,String parameter,String value) {
		return new RequestSpecBuilder().
				setBaseUri(uri).
				//addHeader("api_key", "").
				addPathParam(parameter, value).
				setContentType(ContentType.JSON).
				build();			
	}
	
	public static RequestSpecification getRequestSpecWithForm(String uri,Map<String,?>formParam,String parameter, String value) {
		return new RequestSpecBuilder().
				setBaseUri(uri).
				addFormParams(formParam).
				addPathParam(parameter, value).
				addHeader("Accept", "application/json").
				setContentType(ContentType.URLENC).
				build();			
	}
}
