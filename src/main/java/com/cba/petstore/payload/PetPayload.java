package com.cba.petstore.payload;

import java.util.Arrays;

import com.cba.petstore.model.Category;
import com.cba.petstore.model.CreatePet;
import com.cba.petstore.model.Tag;
import com.cba.petstore.utilities.Pet;
import com.cba.petstore.utilities.RandomData;

public class PetPayload {

	public CreatePet createPet() {
		
		Category category = new Category();
		category = Category.builder()
				.id(RandomData.RandomNumber())
				.name("Working Group")
				.build();
		
		Tag tags = new Tag();
		tags = Tag.builder()
				.id(RandomData.RandomNumber())
				.name(RandomData.generateRandomWord(4))
				.build();
		
		CreatePet petRequest = new CreatePet();
		petRequest = CreatePet.builder()
				.id(RandomData.RandomNumber())
				.category(category)
				.name(RandomData.generateRandomWord(8))
				.photoUrls(Arrays.asList("https://url.com"))
                .tags(Arrays.asList(tags))
                .status(Pet.Available.getValue())	
				.build();
				
				
		return petRequest;
	}
}
