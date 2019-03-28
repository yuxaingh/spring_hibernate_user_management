package com.hyx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hyx.dao.DeptInfo;
import com.hyx.dao.IDeptInfoDao;
import com.hyx.dao.IUserInfoDao;
import com.hyx.dao.UserInfo;

import antlr.collections.List;

public class UserLoginController extends SimpleFormController {
	private IUserInfoDao userInfoDao;
	private IDeptInfoDao deptInfoDao;
	
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	public void setDeptInfoDao(IDeptInfoDao deptInfoDao) {
		this.deptInfoDao = deptInfoDao;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		UserInfo user = (UserInfo) command;
		java.util.List list = userInfoDao.findByNamePwd(user.getId(), user.getPwd());
		if(!list.isEmpty()) {
			user = (UserInfo) list.get(0);
			//if number equals one, the user is administrator
			if(user.getNumber() == 1) {
				return new ModelAndView(getSuccessView());
			}else {
				DeptInfo deptInfo = (DeptInfo) deptInfoDao.findById(user.getDept());
				Map map = new HashMap();
				map.put("dept", deptInfo);
				map.put("user", user);
				return new ModelAndView("userInfo", "map", map);
			}
		}else {
			return new ModelAndView(getFormView(), "error", "Failed to log in, username or password is not corrct!");
		}
	}
}
