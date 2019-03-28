package com.hyx.dao;

import java.util.List;

public interface IUserInfoDao {
	public void delete(Integer number);
	public List<Object> findAll();
	public Object findById(Integer number);
	public void insert(Object o);
	public void update(Object o);
	public List findByNamePwd(String id, String pwd);
	public boolean findByName(String id);
	public List findJion();
	public boolean findByDept(Integer dept);
}
