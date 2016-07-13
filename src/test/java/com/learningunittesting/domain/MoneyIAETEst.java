package com.learningunittesting.domain;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MoneyIAETEst {
	
	public static final int VALID_AMOUNT =5;
	public static final String VALID_CURRENCY ="USD";
	
	private static final Object[][] invalidAmount(){
		return new Integer[][] {{-12},{-2321},{-123}};
	}
	
	private static final Object[][] invalidCurrency(){
		return new String [][]{{null},{""}};
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="invalidAmount")
	public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
		new Money(invalidAmount, VALID_CURRENCY);
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="invalidCurrency")
	public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
		new Money(VALID_AMOUNT, invalidCurrency);
	}

}
