package com.learningunittesting.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MoneyTest {
	
	@Test
	public void constructorShouldSetAmountAndCurrency() {
		Money money = new Money(10, "USD");
		
		assertEquals(10, money.getAmount());
		assertEquals("USD", money.getCurrency());
	}
}
