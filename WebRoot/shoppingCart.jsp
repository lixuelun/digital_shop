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
  	<s:if test="#request.tip!=null">
  		提示：<s:property value="#request.tip" /><br>
  	</s:if>
  	
    <s:if test="#request.list.size()!=0">
    <h2><b>购物车:</b></h2>
  		<table align="center" border="2" cellpadding="5">
  			<tr>
  				<td>商品图片</td>
  				<td>商品名称</td> 
  				<td>商品价格</td>
  				<td>库存数量</td>
  			</tr>
  			<s:iterator value="#request.list" var="shoppingCart">
  				<s:form action="shoppingCart" theme = "simple">
  					<tr>
  						<td><img src="../<s:property value="shoppingCart.img" />"></img></td>
  						<td><s:property value="#shoppingCart.name" /></td>
  						<td><s:property value="#shoppingCart.price" /></td>
  						<td><s:property value="#shoppingCart.quantity" /></td>
  						<s:hidden name="name" value="%{#shoppingCart.name}"></s:hidden>
  						<td><s:submit value="删除商品" method="deleteShoppingCart" /></td>
					</tr>
  				</s:form>
  			</s:iterator>
  		</table>
  	</s:if>
  	<s:else>
  		您的购物车中空空如也，<a href="search_product.jsp">点此</a>继续选购
  	</s:else>
  </body>
</html>
