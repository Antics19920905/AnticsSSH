package com.service.impl;

import java.util.List;

import com.bean.Country;
import com.dao.CountryDao;
import com.service.CountryService;

public class CountryServiceImpl implements CountryService {
	private CountryDao dao;
	@Override
	public List<Country> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	
	@Override
	public void delete(Country c) {
		// TODO Auto-generated method stub
		dao.delete(c);
	}
	@Override
	public void add(Country c) {
		// TODO Auto-generated method stub
		dao.add(c);
	}
	@Override
	public void update(Country c) {
		// TODO Auto-generated method stub
		dao.update(c);
	}
	@Override
	public List<Country> select(Country c) {
		// TODO Auto-generated method stub
		if(c.getName().length()==0&&c.getLanguage().length()==0){
			return dao.queryAll();
		}
		return dao.select(c);
	}
	@Override
	public Country queryById(Country c) {
		// TODO Auto-generated method stub
		return dao.queryById(c);
	}
	
	public CountryDao getDao() {
		return dao;
	}
	public void setDao(CountryDao dao) {
		this.dao = dao;
	}
}
