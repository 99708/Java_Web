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
    
    <title>My JSP 'threeLinkAge.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body>
  	<!-- 通过el表达式来获取数据 -->
  	<%-- ${provinceList } --%>
    <p>省份城市县区三级联动</p><hr />
    <select id="provinceId" onchange="findCity()">
    	<option>---请选择---</option>
    	<c:forEach var="province" items="${provinceList }">
    		<option value="${province.code }">${province.name }</option>
    	</c:forEach>
    </select>
    <select id="cityId" onchange="findTown()">
    	<option>---请选择---</option>
    </select>
    <select id="townId">
    	<option>---请选择---</option>
    </select>
    
    <script type="text/javascript">
    	//1、查询省份下面的地级市
		function findCity(){
			//1.1、获得省份的节点
			var provinceId = document.getElementById("provinceId");
			//1.2、获得省份的code码
			var provinceCode = provinceId.value;
			//1.3、向后端发送请求(使用ajax技术)
				//1.3.1创建ajax引擎对象
					var xhr = new XMLHttpRequest();
				//1.3.2与服务器建立连接
					xhr.open("post", "cityServlet", true);
				//1.3.3设置头信息(post请求特有)
					xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				//1.3.4发送消息
					xhr.send("provinceCode="+provinceCode);
				//1.3.4获取后端响应数据
					//1.3.4.1 当状态发送改变时执行的函数
					xhr.onreadystatechange = function(){
						//如果XMLHttpRequest对象的readystate值为4(请求已完成且响应已就绪)
						//并且XMLHttpRequest对象的status(http的状态码)为200执行的内容
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								var rsData = xhr.responseText;
								//将String转为json对象
								eval("var jsonArr = "+rsData);
								//清空后面两个下拉框中的内容
									//获取城市的select框
									var cityEle = document.getElementById("cityId");
									//清空城市历史节点
									cityEle.innerHTML = "<option>---请选择---</option>";
									//获取区县的select框
									var townEle = document.getElementById("townId");
									//清空区县下拉框中的历史节点
									townEle.innerHTML = "<option>---请选择---</option>";
								
								//遍历jsonArr数组
								for(var i in jsonArr){
									var cityObj = jsonArr[i];
									//创建option节点
									var option = document.createElement("option");
									//设置option的value值和显示的值
									option.value = cityObj.code;
									option.innerHTML = cityObj.name;
									//将option对象追加到city的select框中
									cityEle.append(option);
								}
							}
						}
					};
		}
    	function findTown(){
    		//1、创建ajax引擎对象
    		var xhr = new XMLHttpRequest();
    		//2、建立连接
    		xhr.open("post", "townServlet", true);
    		//3、设置请求头信息
    		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    		//4、发送数据
    			//4.1获得数据
    			var cityObj = document.getElementById("cityId");
    			var cityCode = cityObj.value;
    		xhr.send("cityCode="+cityCode);
    		//5、接收服务器返回的数据
    		xhr.onreadystatechange = function (){
    			if(xhr.readyState == 4){
    				if(xhr.status == 200){
    					var rsData = xhr.responseText;
    					//将json字符串转为json对象
    					eval("var jsonArr = " + rsData);
    					//获取town下拉框
    					var townEle = document.getElementById("townId");
    					//清空历史数据
    					townEle.innerHTML="<option>---请选择---</option>";
    					//遍历数组
    					for(var i in jsonArr){
    						var townObj = jsonArr[i];
    						//创建option节点
    						var option = document.createElement("option");
    						//设置option的value值和显示值
    						option.value = townObj.code;
    						option.innerHTML = townObj.name;
    						//添加option到town下拉框
    						townEle.append(option);
    					}
    				}
    			}
    		};
    	}
	</script>
  </body>
  
</html>








