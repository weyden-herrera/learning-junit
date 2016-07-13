package com.learningunittesting.util;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
	
	private Map<String, String> testHashMap;
	
	@Before
	public void init(){
		testHashMap = new HashMap<>();
		testHashMap.put("key", "value");
	}
	
	@Test
	public void verifyPutCanBeGet(){
		assertNotNull(testHashMap.get("key"));
	}
	
	@Test
	public void verifySameKeyWillOveright(){
		String old = testHashMap.get("key");
		testHashMap.put("key", "value2");
		String newest = testHashMap.get("key");
		
		assertNotEquals(old, newest);
	}
	
	@Test
	public void clearMethodCanClear(){
		testHashMap.clear();
		assertEquals(0, testHashMap.size());
	}
	
	@Test
	public void nullCanBeUseAsKey(){
		testHashMap.put(null, "null");
		assertNotNull(testHashMap.get(null));
	}
	
}
