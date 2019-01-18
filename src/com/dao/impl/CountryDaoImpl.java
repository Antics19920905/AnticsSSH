package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Country;
import com.dao.CountryDao;

public class CountryDaoImpl implements CountryDao {
	private SessionFactory sessionFactory;

	@Override
	public List<Country> queryAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("from Country").list();
	}


	@Override
	public void delete(Country c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(c);
	}

	@Override
	public void add(Country c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(c);
	}

	@Override
	public void update(Country c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(c);
	}

	@Override
	public List<Country> select(Country c) {
		// TODO Auto-generated method stub
		Query q=null;
		Session session=sessionFactory.getCurrentSession();
		if(c.getName().length()!=0&&c.getLanguage().length()!=0){
			q=session.createQuery("from Country where name = ? and language=?");
		}else{
			q=session.createQuery("from Country where  name=? or language=?");
		}
		q.setString(0, c.getName());
		q.setString(1, c.getLanguage());
		return q.list();
	}

	@Override
	public Country queryById(Country c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		return (Country) session.get(Country.class, c.getId());
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
