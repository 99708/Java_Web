<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		div{
			text-align: center;
			color:red;
		}
	</style>
  </head>
  
  <body>
  	<div>
  		 测试分页查询
  		<hr>
  	   	<form   id="lgoinId" action="loginServlet" method="post" >
			name:<input id="uname" name="uname" type="text"   /><br/> 
			<input id="submitId"  type="submit" value="登录" />
	    </form>
  	</div>
  </body>
</html>
