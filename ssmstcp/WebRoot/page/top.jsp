<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
   <table border="1" width="100%">
   	<tr>
   		<td width="60%">
   			类型1 类型2 .。。。。
   		</td>
   		<td width="40%" align="right">
   			<c:if test="${sessionScope.USER==null}">
   				<a href="page/register.jsp">注册</a>
   				<a href="page/login.jsp">登录</a>
   			</c:if>
   			<c:if test="${sessionScope.USER!=null}">
   				<c:if test="${sessionScope.USER.type=='0'}">
   					${sessionScope.USER.realname }，欢迎你！
				   			<a href="type/select">查看类型</a>
				   			<a href="page/t_add.jsp">新增类型</a>
				   			<a href="cuser/logout">退出登录</a>
   				</c:if>
   				<c:if test="${sessionScope.USER.type=='1'}">
   					${sessionScope.USER.realname }，欢迎你！
				   			<a href="cp/selectbyuser">我的菜谱</a>
				   			<a href="page/cp_add.jsp">新增菜谱</a>
				   			<a href="page/mymsg.jsp">个人中心</a>
				   			<a href="cuser/logout">退出登录</a>
   				</c:if>
   			</c:if>					
   		</td>
   	</tr>
   </table>
  </body>
</html>
