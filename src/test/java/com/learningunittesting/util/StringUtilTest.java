package com.learningunittesting.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {
	
	private static final Object[] getStrings(){
		return new Object[] {
			new Object[] {"weyden", "nedyew"},
			new Object[] {"turla", "alrut"},
			new Object[] {"", ""},
		};
	}

	@Test
	@Parameters(method="getStrings")
	public void verifyStringReversal(String input, String output){
		assertEquals(output, StringUtil.reverse(input));
	}
	
	@Test(expected=NullPointerException.class)
	public void throwsNullPointer(){
		String string =  StringUtil.reverse(null);
	}
	
}
