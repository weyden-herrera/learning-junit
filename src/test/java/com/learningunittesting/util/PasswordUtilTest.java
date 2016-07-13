package com.learningunittesting.util;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class PasswordUtilTest {

	public Object[] nullAndEmpty(){
		return $(null,"");
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="nullAndEmpty")
	public void throwsIAEonNullAndEmptyString(String password){
		PasswordUtil.validate(password);
	}
	
	public Object[] invalidPasswords(){
		return $("qwertt", "addbutwe", "eeaddedf", "Esdfdfdf");
	}
	
	@Test
	@Parameters(method="invalidPasswords")
	public void falseIfPasswordReqNotMet(String password){
		assertFalse("Password String " + password + " is invalid but return true",PasswordUtil.validate(password));
	}
	
	public Object[] validPasswords(){
		return $("W3yden26", "mousE0123", "233Addedf", "Esdfd333");
	}
	
	@Test
	@Parameters(method= "validPasswords")
	public void trueIfPasswordReqIsMet(String password){
		assertTrue("Password String " + password + " is valid but return false",PasswordUtil.validate(password));
	}
	
}
