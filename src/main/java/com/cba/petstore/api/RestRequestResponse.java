package com.cba.petstore.api;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Map;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import static com.cba.petstore.api.ReqResSpecBuilder.*;

public class RestRequestResponse {

	
	public static Response post(String uri, String path, Object payload,int statusCode) {
		return given(getRequestSpec(uri)).
				filter(new RequestLoggingFilter()).
				filter(new ResponseLoggingFilter()).
				body(payload).
				when().
				post(path).
				then().log().ifError().
				spec(getResponseSpec(statusCode)).
				extract().
				response();			
				
	}
	
	public static Response get(String uri, String path,String query, String param, int statusCode) {
		return given(getRequestSpec(uri)).
				filter(new ResponseLoggingFilter()).
				when().
				get(path).
				then().log().ifError().
				spec(getResponseSpec(statusCode)).
				extract().
				response();			
				
	}
	
	public static Response put(String uri, String path, Object payload,int statusCode) {
		return given(getRequestSpec(uri)).
				filter(new RequestLoggingFilter()).
				filter(new ResponseLoggingFilter()).
				body(payload).
				when().
				put(path).
				then().log().ifError().
				spec(getResponseSpec(statusCode)).
				extract().
				response();			
				
	}
	
	public static Response upload(String uri, String path,String id, File file,int statusCode) {
		return given(getRequestSpecUpload(uri,"id",id)).
				filter(new ResponseLoggingFilter()).
				multiPart(file).
				when().
				post(path).
				then().log().ifError().
				spec(getResponseSpec(statusCode)).
				extract().
				response();			
				
	}
	
	public static Response delete(String uri, String path,String id,int statusCode) {
		return given(getRequestSpecWithPathParam(uri,"id",id)).
				filter(new ResponseLoggingFilter()).
				when().
				delete(path).
				then().log().ifError().
				spec(getResponseSpec(statusCode)).
				extract().
				response();			
				
	}
	
	public static Response getById(String uri, String path, String value, int statusCode) {
		return given(getRequestSpecWithPathParam(uri,"id",value)).
				filter(new ResponseLoggingFilter()).
				when().
				get(path).
				then().log().ifError().
				spec(getResponseSpec(statusCode)).
				extract().
				response();			
				
	}
	
	public static Response postFormData(String uri, String path, Map<String,?> formParam,int statusCode,String value) {
		return given(getRequestSpecWithForm(uri,formParam,"id",value)).
				filter(new RequestLoggingFilter()).
				filter(new ResponseLoggingFilter()).
				when().
				post(path).
				then().log().ifError().
				spec(getResponseSpec(statusCode)).
				extract().
				response();			
				
	}
}
