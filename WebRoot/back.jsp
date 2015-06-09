<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>申请退货</title>
    
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
  	<div>
  		<s:if test="#request.list.size()!=0">
  			<h2 align="center">商品信息</h2>
  			<table align="center" border="2" cellpadding="5">
  				<tr>
  					<td>商品图片</td>
  					<td>商品名称</td>
  					<td>商品价格</td>
  				</tr>
  				<s:iterator value="#request.list" var="back">
  				<tr>
  					<td><s:property value="#"></s:property></td>
  					<td><s:property value="#"></s:property></td>
  					<td><s:property value="#"></s:property></td>
  				</tr>
  				</s:iterator>  			
  			</table>
  			</s:if>
  	</div>
    <div align="center">
    	<form action="/backAction" method="post" name="">
    		 <table align="center">
    		 <tr>
    		 <td>退货原因</td>
    		 <td>
    		 	<select >
    		 		<option value="reason1">与卖家协商一致</option>
    		 		<option value="reason2">物品坏了</option>
    		 		<option value="reason3">货不对板</option>
    		 		<option value="reason4">其他</option>
    		 	</select>
    		 </td>
    		 </tr>
    		 <tr>
    		 <td>说明:</td>
    		 <td><input type="text" name="back_context"></td>
    		 </tr>
    		 <tr>
    		 	<input type="submit" value="提交申请">
    		 </tr>    		 
    		 </table>
    	</form>
    </div>
  </body>
</html>
