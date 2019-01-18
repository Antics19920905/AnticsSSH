package com.service;


import com.bean.Country;
import com.bean.User;

public interface UserService {
	public User queryByName(String name);
	public void add(Country c);
}
