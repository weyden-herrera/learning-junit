package com.learningunittesting.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	public static String reverse(String s) {
		
		if(s == null){
			throw new NullPointerException();
		}
		
		char[] characterArray = s.toCharArray();
		StringBuilder reversedString = new StringBuilder(s.length());
		
		for(int i = characterArray.length -1; i >= 0; i--){
			reversedString.append(characterArray[i]);
		}
		
		/*
		 List<String> tempArray = new ArrayList<String>(s.length());
		 for (int i = 0; i < s.length(); i++) {
			 tempArray.add(s.substring(i, i+1));
		 }
		 
		 StringBuilder reversedString = new StringBuilder(s.length());
		 for (int i = tempArray.size() -1; i >= 0; i--) {
			 reversedString.append(tempArray.get(i));
		 }
		 return reversedString.toString();
		}*/
		
		return reversedString.toString();
	}

}
