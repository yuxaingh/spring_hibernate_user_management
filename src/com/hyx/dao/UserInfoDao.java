package com.hyx.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserInfoDao implements IUserInfoDao {

	SessionFactory sessionFactory;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer number) {
		Session session = getSession();
		UserInfo user = (UserInfo) session.load(UserInfo.class, number);
		session.delete(user);
		session.flush();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public List<Object> findAll() {
		Query query = getSession().createQuery("FROM UserInfo");
		List list = query.list();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public Object findById(Integer number) {
		UserInfo user = (UserInfo) getSession().get(UserInfo.class, number);
		return user;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Object o) {
		getSession().save(o);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object o) {
		Session session=this.getSession();
		session.update(o);
		session.flush();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public List findByNamePwd(String id, String pwd) {
		Query query = getSession().createQuery("FROM UserInfo WHERE id='" + id + "' AND pwd='" + pwd + "'");
		List list = query.list();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public boolean findByName(String id) {
		Query query = getSession().createQuery("FROM UserInfo WHERE id='" + id + "'");
		List list = query.list();
		return !list.isEmpty();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public List findJion() {
		Query q = getSession().createQuery(
		"from UserInfo u,DeptInfo d where u.dept=d.number order by u.number");
		List list = q.list();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true)
	public boolean findByDept(Integer dept) {
		Query q = getSession().createQuery("FROM UserInfo WHERE dept = '" + dept + "'");
		List list = q.list();
		return !list.isEmpty();
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
