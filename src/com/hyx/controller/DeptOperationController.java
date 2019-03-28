package com.hyx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.hyx.dao.DeptInfo;
import com.hyx.dao.IDeptInfoDao;
import com.hyx.dao.IUserInfoDao;

public class DeptOperationController extends MultiActionController {
	
	private IDeptInfoDao deptInfoDao;
	private IUserInfoDao userInfoDao;
	
	public void setDeptInfoDao(IDeptInfoDao deptInfoDao) {
		this.deptInfoDao = deptInfoDao;
	}
	
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	public ModelAndView insertOrUpdateDept(HttpServletRequest request, HttpServletResponse response) {
		DeptInfo dept = new DeptInfo();
		dept.setName(request.getParameter("name"));
		dept.setCreateDate(request.getParameter("createDate"));
		dept.setRemark(request.getParameter("remark"));
		dept.setNumber(Integer.parseInt(request.getParameter("number")));
		if(dept.getNumber() == 0) {
			deptInfoDao.insert(dept);
		}else {
			deptInfoDao.update(dept);
		}
		return showDept(request, response);
	}
	
	public ModelAndView deleteDept(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 Integer number = Integer.parseInt(request.getParameter("number"));
		 boolean bool = userInfoDao.findByDept(number);
		 String message = "";
		 if(!bool) {
			 deptInfoDao.delete(number);
			 message = "Successfully deleted department!";
		 }else {
			 message = "Can not delete department! Please make sure there is not user under this department!";
		 }
		 PrintWriter out = response.getWriter();
		 out.print("<script type='text/javascript'>");
		 out.print("alert('"+ message + "');");
		 out.print("window.location='deptOperation.html?method=showDept';");
		 out.print("</script>");
		 out.close();
		 return null;
	}
	
	public ModelAndView showDept(HttpServletRequest request, HttpServletResponse response) {
		List list = deptInfoDao.findAll();
		return new ModelAndView("dept/showDept", "list", list);
	}
	
	public ModelAndView findById(HttpServletRequest request, HttpServletResponse response) {
		DeptInfo dept = (DeptInfo) deptInfoDao.findById(Integer.parseInt(request.getParameter("number")));
		return new ModelAndView("dept/insertOrUpdateDept", "dept", dept);
	}
}
