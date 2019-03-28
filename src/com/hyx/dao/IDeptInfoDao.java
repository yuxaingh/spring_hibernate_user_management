package com.hyx.dao;

import java.util.List;

public interface IDeptInfoDao {
	public void delete(Integer number);
	public List<Object> findAll();
	public Object findById(Integer number);
	public void insert(Object dept);
	public void update(Object dept);
}
