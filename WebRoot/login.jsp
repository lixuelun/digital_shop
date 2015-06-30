<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
  	<jsp:include page="search_product.jsp" />
  	<s:if test="#request.tip!=null">
  		提示：<s:property value="#request.tip" />
  	</s:if>
  	<h2><b>用户登录:</b></h2>
  	<div align="center">
    	<s:form action="login">
    		<s:textfield name="username" label="登录名称" />
			<s:password name="password" label="登录密码" />
			<s:submit value="登录 " method="memlogin"/>
		 </s:form>
		如果你还没注册，点此进行<a href="register.jsp" >注册</a>
	</div>
  </body>
</html>
