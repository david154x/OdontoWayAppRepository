package com.drr.odontoway.core;

import java.util.List;

public interface GenericRepository<T, ID> {
	
	public List<T> findAll();
	
	public T findById(ID id);
	
	public T create(T t);
	
	public T update(T t);
	
	public void delete(ID id);
	
}
