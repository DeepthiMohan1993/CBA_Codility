package com.cba.petstore.pet.test;

import org.testng.annotations.Test;

import com.cba.petstore.api.RestRequestResponse;
import com.cba.petstore.base.BaseTest;
import com.cba.petstore.payload.PetPayload;
import com.cba.petstore.utilities.DataReader;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.util.Properties;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterClass;
import static org.hamcrest.Matchers.*;

public class TC02_AddNewPet extends BaseTest {

	public int id;

	@BeforeClass
	public void beforeClass() {
		Properties prop = DataReader.LoadPropertiesfile();
		baseUri = prop.getProperty("petbaseuri");
		path = prop.getProperty("path");
		uploadPath = prop.getProperty("uploadImage");
		petById = prop.getProperty("petById");
	}

	@Test
	public void addANewpet() {

		PetPayload pet = new PetPayload();
		Response response = RestRequestResponse.post(baseUri, path, pet.createPet(), 200);

		id = response.jsonPath().getInt("id");
		MatcherAssert.assertThat(id, is(notNullValue()));

	}

	@Test(dependsOnMethods = "addANewpet" )
	public void uploadImageOfPet() {
		String path = System.getProperty("user.dir")+"/src/test/java/com/cba/petstore/test/resources/Picture.png";
		
		File file = new File(path);
		
		Response response = RestRequestResponse.upload(baseUri, uploadPath,String.valueOf(id), file, 200);
		int code = response.jsonPath().getInt("code");
		MatcherAssert.assertThat(code, is(equalTo(200))); 
	}
	
	
	@Test(dependsOnMethods = "addANewpet")
	public void deletePet() {

		Response response = RestRequestResponse.delete(baseUri, petById, String.valueOf(id), 200);	
		int code = response.jsonPath().getInt("code");
		MatcherAssert.assertThat(code, is(equalTo(200))); 

	}

	@AfterClass
	public void afterClass() {
	}

}
