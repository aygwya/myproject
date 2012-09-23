package com.blog.service;

import java.io.Serializable;
import java.util.List;

public interface Service {
	
    public <T> T get(Class<T> entityClass,Serializable id);
    
    public Serializable save(Object entity);
    
    public void update(Object entity);
    
    public void delete(Object entity);
    
    public <T> void delete(Class<T> entityClass,Serializable id);
   
    public List find(String hql);
}
