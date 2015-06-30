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
    
    <title>My JSP 'member_information.jsp' starting page</title>
    
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
  	<h2><b>个人资料:</b></h2>
  	<div align="center">
	<s:form action="member">
  		<table border="2">
    		<s:iterator value="#request.list" var="member">
  	  		<tr>
  	  			<td colspan="2">用户名：<s:property value="#member.memName" /><td>
  	  		</tr>
  	  		<tr>
  	  			<td>密码：<s:property value="#member.memPass" /></td>
  	  			<td><s:textfield name="newMemPass" theme = "simple"/>
  	  				<s:submit value="修改" method="updateMemPass" theme = "simple" />
  	  			<td>
  	  		</tr>
  	  		<tr>
  	  			<td>地址：<s:property value="#member.memAdds" /></td>
  	  			<td><s:textfield name="newMemAdds" theme = "simple"/>
  	  				<s:submit value="修改" method="updateMemAdds" theme = "simple"/>
  	  			</td>
  	  		</tr>
  	  		<tr>
  	  			<td>e-mail：<s:property value="#member.memMail" /></td>
  	  			<td>
  	  				<s:textfield name="newMemMail" theme = "simple"/>
  	  				<s:submit value="修改" method="updateMemMail" theme = "simple"/>
  	  			</td>
  	  		</tr>
  	  		<tr>
  	  			<td>电话：<s:property value="#member.memTel" /></td>
  	  			<td>
  	  				<s:textfield name="newMemTel" theme = "simple"/>
  	  				<s:submit value="修改" method="updateMemTel" theme = "simple"/>
  	  			</td>
  	  		</tr>
  			</s:iterator>
  		</table>	
	</s:form>	
	</div>
	
	<br><br> 
	<s:form theme = "simple" action="login">
	<div align="center"><s:submit value="退出登陆" method="quit" /></div>
	</s:form>
  </body>
</html>
