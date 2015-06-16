<%@ page language="java" import="java.util.*" import="com.db.*" pageEncoding="UTF-8"%>
<%@page import="java.util.Date.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getproduct.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body style="margin:0;padding:0">
   <jsp:include page="search_product.jsp" />
   <table border="1" align="center" id="mytable">
  		<tr>
  			<td>商品图片</td>
  			<td>商品编号</td>
  			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品库存</td>
			<td>商品内容</td>
			<td>导入日期</td>
		</tr>
		<s:form aciton="delete">
		<s:hidden value="#request.category" name="category" />
		<s:hidden value="#request.list.get(0).proId" name="proid" />
		
		<s:iterator value="#request.list" var="product">
  			<tr>
  				<td><img src="<s:url value="product.proImg"/>"/></td>
  				<td><s:property value="#product.proId" /></td>
  				<td><s:property value="#product.proName" /></td>
  				<td><s:property value="#product.proPrice" /></td>
  				<td><s:property value="#product.proNum" /></td>
  				<td><s:property value="#product.proContent" /></td>
  				<td><s:property value="#product.proDate" /></td>
  				<td><s:submit value="删除商品" mothod="deleteProduct"/></td>
  			</tr>
  		</s:iterator>	
  		</s:form>	
  </table>
  </body>
</html>
