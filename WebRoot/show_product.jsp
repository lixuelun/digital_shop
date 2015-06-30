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
    
    <title>My JSP 'show_product.jsp' starting page</title>
    
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
    <s:if test="#request.list.size()!=0">
  		<table align="center" border="2" cellpadding="5">
  			<tr>
  				<td>商品图片</td>
  				<td>商品名称</td>
  				<td>商品价格</td>
  				<td>库存数量</td>
  			</tr>
  			<s:iterator value="#request.list" var="product">
  			<tr>
  				<td><img src="../<s:property value="#product.proImg" />"></img></td>
  				<td>
  					<a href="product.action?product.proName=<s:property value="#product.proName" />" >
  						<s:property value="#product.proName" />
  					</a>
  				</td>
  				<td><s:property value="#product.proPrice" /></td>
  				<td><s:property value="#product.proNum" /></td>
  			</tr>
  			</s:iterator>
  		</table>
  	</s:if>
  	<s:else>
  		没有符合条件的商品！
  	</s:else>
  </body>
</html>
