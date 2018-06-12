<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cp_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.4.4.min.js"></script>
	<link rel="stylesheet" href="js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="js/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="js/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="js/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="js/kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : 'js/kindeditor/plugins/code/prettify.css',
				uploadJson : 'js/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'js/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <form action="cp/update"  enctype="multipart/form-data"  method="post">
    	<!-- 通过隐藏域将id保存下来 -->
    	<input type="hidden" name="id" value="${cp.id }"/>
    	<!-- 通过隐藏域将原始的图片地址保存下来 ,为什么要保存下来？？-->
    	<input type="hidden" name="pic" value="${cp.pic }"/>
    	<img src="<%=basePath%>${cp.pic }" width="100"/>
    	类型：
    	<select name="tid" id="tid">
				
		</select>
    	
    	<br/>
    	图片：<input type="file" name="uploadFile"/><br/>
    	标题：<input name="title" value="${cp.title }"/><br/>
    	内容：<textarea name="content" rows="5" cols="50">${cp.content }</textarea><br/>
    	<input type="submit"/><br/>
    </form>
  </body>
</html>
<!-- 写ajax方法 -->
<script>
		var tid="${cp.tid}";
		$.ajax( {
						url:'cp/gettype',
						type:'post',
						data: {
							para1:'1111',
							para2:'2222'
						},
						datatype : "json",//"xml", "html", "script", "json", "jsonp", "text".           
						success : function(data) {
							var json=eval('(' + data + ')');
							$.each(json, function (n, item) {
								if(tid==item.id){
									$("#tid").append("<option selected value='"+item.id+"'>"+item.name+"</option>");
								}else{
									$("#tid").append("<option value='"+item.id+"'>"+item.name+"</option>");
								}
								
							});
						}
				});
	
</script>