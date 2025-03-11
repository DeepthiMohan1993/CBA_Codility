package com.cba.petstore.pet.test;

import org.testng.annotations.Test;

import com.cba.petstore.api.RestRequestResponse;
import com.cba.petstore.base.BaseTest;
import com.cba.petstore.utilities.DataReader;
import com.cba.petstore.utilities.Pet;

import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Properties;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterClass;

public class TC01_FindPet extends BaseTest {

	@BeforeClass
	public void beforeClass() {
		Properties prop = DataReader.LoadPropertiesfile();
		baseUri = prop.getProperty("petbaseuri");
		path = prop.getProperty("getPath");
		petById = prop.getProperty("petById");
	}

	@Test
	public void findPetByStatus() {
		
		RestRequestResponse.get(baseUri, path, "status", Pet.Available.getValue(), 200);
		
	}
	
	@Test
	public void findPetById() {
		Response response = RestRequestResponse.getById(baseUri, petById, String.valueOf(540), 200);
		int id = response.jsonPath().getInt("id");
		MatcherAssert.assertThat(id, is(equalTo(540)));
	}

	@AfterClass
	public void afterClass() {
	}

}
