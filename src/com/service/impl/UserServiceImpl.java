package com.service.impl;


import com.bean.Country;
import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao;
	@Override
	public User queryByName(String name) {
		// TODO Auto-generated method stub
		
		return dao.queryByName(name);
	}
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	@Override
	public void add(Country c) {
		// TODO Auto-generated method stub
		
	}
	
}
