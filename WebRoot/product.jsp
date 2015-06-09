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
    
    <title>My JSP 'product.jsp' starting page</title>
    
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
  	<s:iterator value="#request.list" var="product">
  		<div id="div1" class="inline_div"><img src="../<s:property value="#product.proImg" />"></img></div>
  		<s:form action="product">
  			<div id="div2" class="inline_div">
	  			<p><b><s:property value="#product.proName" /></b></p>
  	  			<p>商品价格：<s:property value="#product.proPrice" /></p>
  	  			<p>库存数量：<s:property value="#product.proNum" /></p>
  	  			<p>购买数量：<s:textfield name="quantity" /></p>
  	  			<p>商品日期：<s:property value="#product.proDate" /></p>
  	  			<p><s:submit value="加入购物车" method="addShoppingCart"/></p>
  			</div>
  		</s:form>
  		<p><b>商品信息</b></p>
  		<div id="div3"><s:property value="#product.proContent" /></div>
  	</s:iterator>
  	<a href="search.action?search=<s:property value="#request.searchBox" />" >返回</a>
  </body>
</html>
