package com.cba.petstore.utilities;

import java.util.Random;

public class RandomData {

	public static int RandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}

	public static String generateRandomWord(int length) {
		Random random = new Random();

		StringBuilder word = new StringBuilder();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < length; i++) {
			char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
			word.append(randomChar);
		}
		return word.toString();
	}

}
