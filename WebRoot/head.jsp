<%@ page language="java" pageEncoding="utf-8"%>
<div id="head">
	<div class="personal">
      <div class="personal-center">
         <ul class="ul">
          <%
          	String name=null;
          	if(request.getSession().getAttribute("name")==null){
          		out.print("<li><a href='login.jsp'>你好，请登录</a></li>");
          	}else{
          		name=request.getSession().getAttribute("name").toString();
         		out.println(name+"，你好");
         		out.println("<li><a href='modifyinfo.jsp'>个人资料</a></li>");
         	}
          %>
              <li><a href="">我的购物车</a></li>
              <li><a href="">已买到的宝贝</a></li>
              <li><a href="">处理退货</a></li>
         </ul>
      </div>
	</div>
	
	<form action="/digital_shop/search.jsp" method="post">
    <div class="search">
        <input type="text" name="searchbar" style=" border-color:#999;;height:25px;width:400px"/>
        <input type="submit" value="搜索商品" name="search" style="height:30px;width:70px">       	
	</div>
	</form>
  </div>