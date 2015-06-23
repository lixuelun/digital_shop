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
  	<h2><b>用户注册:</b></h2>
  	<div align="center">
    	<s:form action="member">
    		<s:textfield name="re_name" label="用户名" />
			<s:textfield name="re_pass" label="密码" />
			<s:textfield name="re_adds" label="地址" />
			<s:textfield name="re_mail" label="e-mail" />
			<s:textfield name="re_tel" label="电话" />
			<s:submit value="注册 " method="register"/>
    	</s:form>
    </div>
  </body>
</html>
