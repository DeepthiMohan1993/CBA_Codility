package com.cba.petstore.pet.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cba.petstore.api.RestRequestResponse;
import com.cba.petstore.base.BaseTest;
import com.cba.petstore.model.CreatePet;
import com.cba.petstore.payload.PetPayload;
import com.cba.petstore.utilities.DataReader;
import com.cba.petstore.utilities.Pet;
import com.cba.petstore.utilities.RandomData;

import io.restassured.response.Response;

public class TC03_UpdatePet extends BaseTest {

	@BeforeClass
	public void beforeClass() {
		Properties prop = DataReader.LoadPropertiesfile();
		baseUri = prop.getProperty("petbaseuri");
		petById = prop.getProperty("petById");
		path = prop.getProperty("path");
	}

	
	@Test
	public void updatePet() {

		PetPayload pet = new PetPayload();
		Response response = RestRequestResponse.post(baseUri, path, pet.createPet(), 200);
		CreatePet petResponse = response.as(CreatePet.class);
		
		String updatedName = RandomData.generateRandomWord(8);
		petResponse.setName(updatedName);
		 
		Response updatePetResponse = RestRequestResponse.put(baseUri, path, petResponse, 200);
		MatcherAssert.assertThat(updatePetResponse.jsonPath().getString("name"), is(updatedName));

	}
	
	@Test
	public void addFormDataForPet() {
		
		Map<String, String> map = new HashMap<>();
		map.put("name", RandomData.generateRandomWord(5));
		map.put("status", Pet.Available.getValue());
		
		Response response = RestRequestResponse.postFormData(baseUri, petById, map, 200,String.valueOf(141));

		int code = response.jsonPath().getInt("code");
		MatcherAssert.assertThat(code, is(equalTo(200))); 

	}
}
