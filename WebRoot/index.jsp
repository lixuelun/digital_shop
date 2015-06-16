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
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body style="margin:0;padding:0">
<jsp:include page="search_product.jsp" />

<div class="main">
<div class="add">
	<ul>
		<li style="list-style-type=none"><a href="#" title="Home" style="font-size:30px;">管理商品</a></li>
	</ul>	
	<h5>添加商品:</h5>
	
	<br>
	<s:form action="update">	  
		商品分类：
		<s:select list="{'computer','ipad','phone','cammer'}" theme="simple"  name="product.proCategoryid"></s:select>
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
	
	
	test0修改商品：
	<s:form  action="Cotegory">	  
		<s:select  list="{'computer','ipad','phone','cammer'}" theme="simple"  name="category"></s:select>
		<s:submit value="进入" method="getCategoryProduct" onChange="javascript:document.forms[1].submit()"/>
	</s:form>	
	<!--  <form id="frm1" action="ajax/uploadimage" method="post">
		商品分类：
		<select name="categoryid">
			<option value ="computer">电脑</option>
			<option value="ipad">平板</option>
		  	<option value ="phone">手机</option>
		  	<option value="cammer">单反</option>  	
		</select>
		<br>
		<br>
		商品名称：<input type="text" name="product_name"/>
		<br>
		<br>
		商品价格：<input type="text" name="product_price"/> 元
		<br>
		<br>
		商品库存：<input type="text" name="product_num"/> 件
		<br>
		<br>
		商品内容：<input type="text" style="height:70px;width:300px" name="product_content"/>
		<br>
		<br>
		商品图片：
		<img id="image" src=""/>
		<input type="file" onchange="selectImage(this);" name="image"/>
		<br>
		<input type="submit" value="提交" onChange="javascript:document.forms[0].submit()"/>
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
</form>-->
</div>
<!--  <div class="delete">
	<h5>分类编辑:</h5>
	<form id="frm2" action="ajax/getproduct"  method="post">
		<select name="categoryid" onChange="javascript:document.forms['frm2'].submit()">
				<option value ="computer">电脑</option>
				<option value="ipad">平板</option>
			  	<option value ="phone">手机</option>
			  	<option value="cammer">单反</option>  	
		</select>
	</form>
</div>
-->
</div>
</body>
</html>
