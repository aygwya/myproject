package com.blog.dao;

import java.io.Serializable;
import java.util.List;


public interface Dao {
	
	public void flush();
	
	public void clear();

	public void refresh(Object entity);
	
	
	public void evict(Object entity);
	
	public Serializable save(Object entity);
	
	public void update(Object entity);
	
	public void merge(Object entity);
	

	public void saveOrUpdate(Object entity);

	public void delete(Object entity);
	
	public void delete(String hql);
	
	public <T> void delete(Class<T> entityClass, Serializable id);
	
	
	public <T> T get(Class<T> entityClass, Serializable id);

	
	public List find(String hql);
	
	public List find(String hql,Object param);
	
	public List find(String hql,Object[] params);
	
	public List findPaginated(String hql, String index, String size);
	
	public List findPaginated(String hql, Object param, String index, String size);
	
	public List findPaginated(String hql, Object[] params, String index, String size);
	
}