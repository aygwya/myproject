package com.blog.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.blog.dao.Dao;
import com.blog.service.Service;



@org.springframework.stereotype.Service
public  class BaseService  implements Service{
	
	@Resource
    protected Dao dao;

	@Override
	public <T> T get(Class<T> entityClass, Serializable key) {
		return dao.get(entityClass,key);
	}

	@Override
	public Serializable save(Object entity) {
		return dao.save(entity);
	}

	@Override
	public void update(Object entity) {
		dao.update(entity);
	}

	@Override
	public <T> void delete(Class<T> entityClass, Serializable key) {
		dao.delete(entityClass,key);		
	}

	@Override
	public void delete(Object entity) {
		dao.delete(entity);		
	}


	@Override
	public List find(String queryString) {
		return dao.find(queryString);
	}

}
