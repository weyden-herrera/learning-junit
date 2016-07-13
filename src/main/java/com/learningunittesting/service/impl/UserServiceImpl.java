package com.learningunittesting.service.impl;

import com.learningunittesting.dao.UserDao;
import com.learningunittesting.domain.User;
import com.learningunittesting.service.SecurityService;
import com.learningunittesting.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDAO;
	private SecurityService securityService;
	
	public UserServiceImpl(UserDao dao, SecurityService security) {
		 this.userDAO = dao;
		 this.securityService = security;
		 }

	
	@Override
	public void assignPassword(User user) {
		String passwordMd5 = securityService.md5(user.getPassword());
		user.setPassword(passwordMd5);
		userDAO.updateUser(user);
	}

}
