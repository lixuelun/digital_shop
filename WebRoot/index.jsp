<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>����ר����</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body style="margin:0;padding:0">
<%@include file="head.jsp"%>

<div class="main">
<div class="add">
	<ul>
		<li style="list-style-type=none"><a href="#" title="Home" style="font-size:30px;">������Ʒ</a></li>
	</ul>	
	<h5>�����Ʒ:</h5>
	
	<br>
	<s:form action="update">	  
			��Ʒ���ࣺ
		<!--<select name="categoryid">
			<option value ="computer">����</option>
			<option value="ipad">ƽ��</option>
		  	<option value ="phone">�ֻ�</option>
		  	<option value="cammer">����</option>  	
		</select>-->
		<s:select list="{'����','ƽ��','�ֻ�','����'}" theme="simple"  name="product.categoryid"></s:select>
		<br>
		<br>
		<s:textfield key="��Ʒ����" name="productproName" />
		<br>
		<br>
		<s:textfield key="��Ʒ�۸�" name="product.setProPrice" />
		<br>
		<br>
		<s:textfield key="��Ʒ���" name="product.proNum" /> 
		<br>
		<br>
		<s:textfield key="��Ʒ����" name="product.proContent" style="height:70px;width:300px" />
		<br>
		<br>
		<img id="image" src=""/>
		<s:file key="��ƷͼƬ" onchange="selectImage(this)" name="product.proImg" />
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
		<s:submit value="�� ��" method="updateProduct"/>
	</s:form>
		
		
	<!--  <form id="frm1" action="ajax/uploadimage" method="post">
		��Ʒ���ࣺ
		<select name="categoryid">
			<option value ="computer">����</option>
			<option value="ipad">ƽ��</option>
		  	<option value ="phone">�ֻ�</option>
		  	<option value="cammer">����</option>  	
		</select>
		<br>
		<br>
		��Ʒ���ƣ�<input type="text" name="product_name"/>
		<br>
		<br>
		��Ʒ�۸�<input type="text" name="product_price"/> Ԫ
		<br>
		<br>
		��Ʒ��棺<input type="text" name="product_num"/> ��
		<br>
		<br>
		��Ʒ���ݣ�<input type="text" style="height:70px;width:300px" name="product_content"/>
		<br>
		<br>
		��ƷͼƬ��
		<img id="image" src=""/>
		<input type="file" onchange="selectImage(this);" name="image"/>
		<br>
		<input type="submit" value="�ύ" onChange="javascript:document.forms[0].submit()"/>
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
	<h5>����༭:</h5>
	<form id="frm2" action="ajax/getproduct"  method="post">
		<select name="categoryid" onChange="javascript:document.forms['frm2'].submit()">
				<option value ="computer">����</option>
				<option value="ipad">ƽ��</option>
			  	<option value ="phone">�ֻ�</option>
			  	<option value="cammer">����</option>  	
		</select>
	</form>
</div>
-->
</div>
</body>
</html>
