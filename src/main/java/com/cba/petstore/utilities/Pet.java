package com.cba.petstore.utilities;

public enum Pet {

	Available("available"),
	Pending("pending"),
	Sold("sold");

	private String value;
	
	Pet(String value) {
		this.value= value;
	}
	
	public String getValue() {
		return value;
	}
	
}
