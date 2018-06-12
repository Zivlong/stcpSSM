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
    
    <title>My JSP 't_list.jsp' starting page</title>
    
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
    <table>
    	<tr>
    		<td>
    			类型名称
    		</td>
    		<td>
    			操作
    		</td>
    	</tr>
    	<c:forEach items="${types}" var="t">
    			<tr>
		    		<td>
		    			${t.name }
		    		</td>
		    		<td>
		    			<a href="type/selectbyid?id=${t.id }">编辑</a>
		    			<a href="type/delete?id=${t.id }">删除</a>
		    		</td>
		    	</tr>
    	</c:forEach>
    </table>
    <a href="${page.page_first }">首页</a>
    <a href="${page.page_pre }">上一页</a>
    <a href="${page.page_next }">下一页</a>
    <a href="${page.page_last }">尾页</a>
    
    
  </body>
</html>
