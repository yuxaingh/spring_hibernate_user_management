package com.hyx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.hyx.dao.IDeptInfoDao;
import com.hyx.dao.IUserInfoDao;
import com.hyx.dao.UserInfo;

public class UserOperationController extends MultiActionController {
	
	private IUserInfoDao userInfoDao;
	private IDeptInfoDao deptInfoDao;
	private FileUpload fileUpload;
	
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	public void setDeptInfoDao(IDeptInfoDao deptInfoDao) {
		this.deptInfoDao = deptInfoDao;
	}
	
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	public ModelAndView insertUser(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		Map map = fileUpload.upload(request, response);
		if(map != null) {
			UserInfo user = new UserInfo();
			user.setId((String) map.get("id"));
			user.setPwd((String) map.get("pwd"));
			user.setName((String) map.get("name"));
			user.setSex((String) map.get("sex"));
			user.setBirthday((String) map.get("birthday"));
			user.setCome((String) map.get("come"));
			user.setDept(Integer.parseInt((String) map.get("dept")));
			user.setFace((String) map.get("face"));
			user.setRemark((String) map.get("remark"));
			userInfoDao.insert(user);
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('Please use different id to register!)");
			out.print("window.hiatory.go(-1);");
			out.print("</script>");
			out.close();
		}
		return null;
	}
	
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map map = fileUpload.upload(request, response);
		UserInfo user = new UserInfo();
		user.setId((String) map.get("id"));
		user.setPwd((String) map.get("pwd"));
		user.setName((String) map.get("name"));
		user.setSex((String) map.get("sex"));
		user.setBirthday((String) map.get("birthday"));
		user.setCome((String) map.get("come"));
		user.setDept(Integer.parseInt((String) map.get("dept")));
		user.setFace((String) map.get("face"));
		user.setRemark((String) map.get("remark"));
		user.setNumber(Integer.parseInt((String) map.get("number")));
		userInfoDao.update(user);
		return showUser(request, response);
	}
	
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer number = Integer.parseInt(request.getParameter("number"));
		userInfoDao.delete(number);
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('Successfully deleted user')");
		out.print("window.location='userOperation.html?method=showUser';");
		out.print("</script>");
		out.close();
		return null;
	}
	
	public ModelAndView showUser(HttpServletRequest request, HttpServletResponse response) {
		List list = userInfoDao.findJion();
		return new ModelAndView("user/showUser", "list", list);
	}
	
	public ModelAndView findById(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		List list = deptInfoDao.findAll();
		if(number == null || number.equals("")) {
			return new ModelAndView("user/insertUser", "map", list);
		}else {
			UserInfo user = (UserInfo) userInfoDao.findById(Integer.parseInt(number));
			Map map = new HashMap();
			map.put("user", user);
			map.put("list", list);
			return new ModelAndView("user/updateUser", "map", map);
		}
	}
}
