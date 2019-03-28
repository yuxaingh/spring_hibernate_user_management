<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>User Login</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE6 {font-size: 9pt; color: #000000; }
-->
  </style></head>
  
  <body>
  <table width="765" height="710" align="center" background="images/userInfo.jpg">
  	<tr>
		<td>
			<div>
				    <table width="500" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
      <tr>
        <td height="24" colspan="5" align="center" bgcolor="#FFFFFF"><span class="STYLE6">User Information</span></td>
      </tr>
      <tr>
        <td height="24" rowspan="4" align="center" valign="middle" bgcolor="#FFFFFF"><img src="face/${map.user.face}"/></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">Username：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.name}</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">Sex：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.sex}</span></td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">DOB：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.birthday}</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">Employed Date：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.come}</span></td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">Personal Introduction：</span></td>
        <td height="24" colspan="3" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.remark}</span></td>
      </tr>
  </table><br>
    <table width="500" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
      <tr>
        <td height="24" colspan="4" align="center" bgcolor="#FFFFFF" class="STYLE6">Department Information</td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">Department name：</td>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">${map.dept.name}</td>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">Established Date：</td>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">${map.dept.createDate}</td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">Department Introduction：</td>
        <td height="24" colspan="3" bgcolor="#FFFFFF" class="STYLE6">${map.dept.remark}</td>
      </tr>
  </table><br>
    <center><a href="index.html">Exit</a></center>
			</div>
		</td>
	</tr>
  </table>
  </body>
</html>
