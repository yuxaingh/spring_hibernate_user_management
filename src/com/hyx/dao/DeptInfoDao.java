package com.hyx.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DeptInfoDao implements IDeptInfoDao {

	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer number) {
		Session session = getSession();
		DeptInfo dept = (DeptInfo) session.load(DeptInfo.class, number);
		session.delete(dept);
		session.flush();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public List<Object> findAll() {
		Query query = this.getSession().createQuery("FROM DeptInfo");
		List list = query.list();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public Object findById(Integer number) {
		DeptInfo dept = (DeptInfo) getSession().get(DeptInfo.class, number);
		return dept;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Object dept) {
		getSession().save(dept);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object dept) {
		Session session=this.getSession();
		session.update(dept);
		session.flush();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.openSession();
	}

}
