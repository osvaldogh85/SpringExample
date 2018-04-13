package com.practice.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
public class RandomWords {

	
	// class variable
	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

	private static Random rand = new Random();

	
	private static Set<String> identifiers = new HashSet<String>();

	public static String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(alphabet.charAt(rand.nextInt(alphabet.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
}
