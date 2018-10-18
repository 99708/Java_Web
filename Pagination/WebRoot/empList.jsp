<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="empList.css">
  </head>
  
  <body>
  <%-- 	${pageUtil.pageData } --%>
   		<h3>员工信息展示页面</h3>
   		<hr>
   	<div id="tabId">
   	<table >
   		   <tr>
   				<th>员工编号</th>
   				<th>员工名称</th>
   				<th>岗　　位</th>
   			</tr>
   			<c:forEach var="pageData" items="${pageUtil.pageData }">
   				<tr>
   					<td>${pageData.empno }</td>
   					<td>${pageData.ename }</td>
   					<td>${pageData.job }</td>
   				</tr>
   			</c:forEach>
   			
   		</table>
   	</div>
   	<div id="page">
   		当前是第${pageUtil.currentPage }页 &emsp;&emsp;&emsp;&emsp;
   		<c:if test="${pageUtil.currentPage != pageUtil.first}">
	   		<span><a href="empServlet?currentPage=${pageUtil.first }">首页</a></span>&emsp;
	   		<span><a href="empServlet?currentPage=${pageUtil.prev }">上一页</a></span>&emsp;
   		</c:if>
   		<c:forEach var="i" begin="${pageUtil.begin }" end="${pageUtil.end }">
	   		<c:if test="${pageUtil.currentPage == i }">
	   			<span style="background: blue; color: white;"><a href="empServlet?currentPage=${i }">${i }</a>&emsp;</span>
	   		</c:if>
	   		<c:if test="${pageUtil.currentPage != i}">
	   			<span><a href="empServlet?currentPage=${i }">${i }</a>&emsp;</span>
	   		</c:if>
	   		
   		</c:forEach>
   		<c:if test="${pageUtil.currentPage != pageUtil.last}">
	   		<span><a href="empServlet?currentPage=${pageUtil.next }">下一页</a></span>&emsp;
	   		<span><a href="empServlet?currentPage=${pageUtil.last }">尾页</a></span>&emsp;
   		</c:if>
   	</div>
  </body>
</html>
