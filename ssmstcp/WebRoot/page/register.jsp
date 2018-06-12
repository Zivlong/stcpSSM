<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <form action="cuser/register"   enctype="multipart/form-data" method="post">
    	<table>
    		<tr>
    			<td>
    				头像：
    			</td>
    			<td>
    				<input type="file" name="uploadFile"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				账号：
    			</td>
    			<td>
    				<input  name="zh"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				密码：
    			</td>
    			<td>
    				<input  name="pass"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				真实姓名：
    			</td>
    			<td>
    				<input  name="realname"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				手机：
    			</td>
    			<td>
    				<input  name="mobile"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit"  value="注册"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
