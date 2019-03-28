package com.hyx.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.hyx.dao.IUserInfoDao;

import javassist.bytecode.Descriptor.Iterator;

public class FileUpload {

	private IUserInfoDao userInfoDao;
	
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	public Map upload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map map = new HashMap<String, String>();
		File file = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List items = upload.parseRequest(new ServletRequestContext(request));
		java.util.Iterator it = items.iterator();
		while(it.hasNext()) {
			FileItem item = (FileItem) it.next();
			if(!item.isFormField()) {
				if(!item.getName().equals("") && item.getName() != null) {
					if(userInfoDao.findByName((String) map.get("id")) && map.get("number") == null) {
						Map m = null;
						return m;
					}
					//get file extension name
					String name = item.getName();
					name = name.substring(name.lastIndexOf('.'), name.length());
					file = new File(request.getSession().getServletContext().getRealPath("/") + 
							"\\face", map.get("id").toString() + name);
					item.write(file);
					map.put("face", map.get("id").toString() + name);
				}
			}else {
				map.put(item.getFieldName(), item.getString());
			}
		}
		return map;
	}
}
