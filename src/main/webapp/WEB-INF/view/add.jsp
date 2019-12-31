<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script type="text/javascript" src="<%=path%>/jquery/jquery-1.8.2.js"></script>
  <link rel="stylesheet" href="<%=path%>/css/css.css" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function add(){
		var formData=new FormData($("#form1")[0]);
		$.ajax({
			type:"post",
			url:"/add",
			data:formData,
			processData:false,
			contentType:false,
			success:function(flag){
				if(flag){
					alert("保存成功");
					location.href="/list";
				}else{
					alert("保存失败");
				}
			}
		})
	}
	 $(function(){
		 $.get("/selectTypes",function(list){
			 for(var i in list){
				$("#tid").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>") 
			 }
		 }); 
		 
		 $.get("/selectBrands",function(list){
			 for(var i in list){
				$("#bid").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>") 
			 }
		 }); 
		 
	 })
	
</script>
<body>
	<h1>商品添加</h1>
	<form id="form1">
		商品名称:<input type="text" name="name"><br>
		英文名称:<input type="text" name="ename"><br>
		品牌：<select name="bid" id="bid">
		      </select><br> 
		种类：<select name="tid" id="tid">
		      </select><br> 
		价格:<input type="text" name="price"><br>
		数量:<input type="text" name="num"><br>
		商品图片:<input type="file" name="file"><br>
		<button type="button" onclick="add()">添加</button>
	</form>
</body>
</html>