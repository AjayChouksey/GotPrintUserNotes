package com.gotprint.usernote.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl implements BaseDao{

	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public <T> T findById(T entity, int id) {
		
		return  (T) getSession().get(entity.getClass(), id);
	}

	@SuppressWarnings("unchecked")
	public <T> T save(T entity) {
		return (T) getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> T update(T entity) {
		return (T) getSession().merge(entity);
	}

	public <T> void deleteById(T entity) {
		getSession().delete(entity);
		
	}
	
}
