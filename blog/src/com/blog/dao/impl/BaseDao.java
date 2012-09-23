package com.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.blog.dao.Dao;


@Repository("dao")
public  class BaseDao implements Dao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public void flush() {
		sessionFactory.getCurrentSession().flush();
	}

	public void clear() {
		sessionFactory.getCurrentSession().clear();
	}

	public void refresh(Object entity) {
		sessionFactory.getCurrentSession().refresh(entity);
	}



	public void evict(Object entity) {
		sessionFactory.getCurrentSession().evict(entity);
	}

	public Serializable save(Object entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	public void update(Object entity) {
		sessionFactory.getCurrentSession().update(entity);
	}


	public void merge(Object entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}


	public void saveOrUpdate(Object entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Object entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public void delete(String hql) {
		sessionFactory.getCurrentSession().delete(hql);
	}

	public <T> void delete(Class<T> entityClass, Serializable id) {
		sessionFactory.getCurrentSession().delete(this.get(entityClass, id));
	}

	public <T> T get(Class<T> entityClass, Serializable id) {
		return (T)sessionFactory.getCurrentSession().get(entityClass, id);
	}


	public List find(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public List find(String hql,Object param) {
		return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,param).list();
	}

	public List find(String hql,Object[] params) {
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		for(int i=0,n=params.length;i<n;i++){
			query.setParameter(i,params[i]);
		}
		return query.list();
	}
	
	public List findPaginated(String hql, String index, String size){
		return findPaginated(hql, (Object[]) null, index, size);
	}
	
	public List findPaginated(String hql, Object param, String index, String size){
		return findPaginated(hql, new Object[] { param }, index, size);
	}
	
	public List findPaginated(String hql, Object[] params, String index, String size){
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult(first(index, size));
		query.setMaxResults(max(size));
		return query.list();
	}
	

	
	private int first(String index, String size) {
		return (index != null && index.trim().length() != 0)? (Integer.parseInt(index) - 1) * Integer.parseInt(size):0;
	}

	private int max(String size) {
		return  (size != null && size.trim().length() != 0)?Integer.parseInt(size):0;
	}
}
