<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Show all departments</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F0F4FF;
}
.STYLE1 {
	color: #FFFFFF;
	font-size: 9pt;
}
.STYLE3 {font-size: 9pt; }
.STYLE5 {font-size: 9pt; font-weight: bold; }
-->
  </style>
  </head>
  
  <body>
    <table background="images/23_03.gif" width="755px" height="27px" border="0" align="left" cellpadding="0" cellspacing="0">
    	<tr>
    		<td width="20px">&nbsp;</td>
    		<td><span class="STYLE1">Current location-&gt;Department Management Page</span></td>
    	</tr>
  	</table>
  	<br>
  	<br>
	<table width="775">
		<tr>
			<td height="40" align="center"><a href="insertOrUpdateDept.html">Create new department</a></td>
		</tr>
	</table>
	<table  style="position: relative;top: 0px;left: 50px" width="650" border="1" cellpadding="0" cellspacing="1" bordercolor="#F0F4FF" bgcolor="#999999">
        <tr>
          <td height="24" bgcolor="#F0F4FF"><div align="center" class="STYLE5">Department id</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">Department name</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">Established date</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">Introduction</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">Operation</div></td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="i">
          <tr>
            <td height="24" bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.number}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.name}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.createDate}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.remark}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
            	<a href="deptOperation.html?method=findById&number=${item.number}">Modify</a>&nbsp;&nbsp;
            	<a href="deptOperation.html?method=deleteDept&number=${item.number}">Delete</a></div></td>
          </tr>
        </c:forEach>
  </table>
  </body>
</html>
