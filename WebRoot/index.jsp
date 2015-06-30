<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数码专卖店</title>
</head>
<body style="margin:0;padding:0">
<jsp:include page="search_product.jsp" />
 

<div class="main" align = "center">
<div class="add" align = "center">
	
	<h5>添加商品:</h5>
	
	<br>
	<s:form action="update">	  
		商品分类：
    	<s:select list="{'computer','ipad','phone','cammer'}" theme="simple"  name="product.proCategoryid"></s:select>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;&nbsp;&nbsp;
		<s:textfield key="商品名称" name="product.proName" />
		<br>
		<br>
		<s:textfield key="商品价格" name="product.proPrice" />
		<br>
		<br>
		<s:textfield key="商品库存" name="product.proNum" /> 
		<br>
		<br>
		<s:textfield key="商品内容" name="product.proContent" style="height:70px;width:300px" />
		<br>
		<br>
		<s:file key="商品图片" onchange="selectImage(this)" name="product.proImg" />
		<br>
		<br>
		<script>
		 var image = '';
		 function selectImage(file){
			 if(!file.files || !file.files[0]){
				return;
			 }
			 var reader = new FileReader();
			 reader.onload = function(evt){
				 document.getElementById('image').src = evt.target.result;
				 image = evt.target.result;		 
			 }
				reader.readAsDataURL(file.files[0]);
		 }
		</script>
		<script src="js/jquery-1.11.1.min.js"></script>
		<s:submit value="提 交" method="updateProduct"/>
	</s:form>
	<img id="image" src=""/>
	<br>
	查看商品：
	<s:form  action="Cotegory">	  
		<s:select  list="{'computer','ipad','phone','cammer'}" theme="simple"  name="category"></s:select>
		<br>
		<s:submit value="进入" method="getCategoryProduct" onChange="javascript:document.forms[1].submit()"/>
	</s:form>	
</div>

</div>
</body>
</html>
