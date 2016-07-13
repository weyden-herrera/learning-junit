package com.learningunittesting.util;

public class PasswordUtil {
	public static boolean validate(String password){
		
		if(password == null || "".equals(password)){
			throw new IllegalArgumentException("password is either null or empty string");
		}
		
		//set password requirments
		//count number of character should be atlease 8 char long
		//password should have 1 digit minimum
		//should have at lease 1 capital letter
		if(password.length() < 8 || !password.matches(".*\\d+.*") || !checkCapitalLetters(password)){
			return false;
		}
		
		return true;
	}
	
	private static boolean checkCapitalLetters(String password){
		char[] passwordArray = password.toCharArray();
		
		for(char c : passwordArray){
			if(Character.isUpperCase(c)){
				return true;
			}
		}
		return false;
	}
}
