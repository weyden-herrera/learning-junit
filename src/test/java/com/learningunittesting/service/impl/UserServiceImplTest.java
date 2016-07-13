package com.learningunittesting.service.impl;

import org.junit.Test;

import static org.mockito.Mockito.*;

import com.learningunittesting.dao.UserDao;
import com.learningunittesting.domain.User;
import com.learningunittesting.service.SecurityService;

public class UserServiceImplTest {
	
	private static final String PASSWORD = "123456";
	
	private UserDao userDao = mock(UserDao.class);
	private SecurityService securityService = mock(SecurityService.class);
	private User user = mock(User.class);
	private UserServiceImpl sut = new UserServiceImpl(userDao, securityService);
	
	@Test
	public void verifyUserGetsNewPassword(){
		//to bypass md5 encrypting
		when(securityService.md5(user.getPassword())).thenReturn(PASSWORD);
		sut.assignPassword(user);
		verify(user).setPassword(PASSWORD);
		
	}
	
	@Test
	public void verifyUserPasswordIsPersisted(){
		sut.assignPassword(user);
		verify(userDao).updateUser(user);
		
	}
}
