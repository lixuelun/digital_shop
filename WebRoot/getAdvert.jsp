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
  </head>
  
  <body style="margin:0;padding:0">
   <jsp:include page="search_product.jsp" />

   <table border="1" align="center" id="mytable">
  		<tr>
  			<td>广告图片</td>
  			<td>广告编号</td>
  			<td>广告内容</td>
			<td>广告价格</td>
			<td>广告企业</td>
			<td>导入日期</td>
		</tr>
		<div align = "center">
		<s:form aciton="delete">
		<s:hidden value="#request.category" name="category" />
		<s:hidden value="#request.list.get(0).proId" name="proid" />
		
		<s:iterator value="#request.list" var="advert">
  			<tr>
  				<td><img src="images/<s:property value="#advert.advertImg"/>"/></td>
  				<td><s:property value="#advert.advertId" /></td>
  				<td><s:property value="#advert.advertContent" /></td>
  				<td><s:property value="#advert.advertPrice" /></td>
  				<td><s:property value="#advert.proCompany" /></td>
  				<td><s:submit value="删除广告" mothod="deleteAdvert"/></td>
  			</tr>
  		</s:iterator>	
  		</s:form>	
  		</div>
  </table>
  </body>
</html>
