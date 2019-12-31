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
function del(){
	var ids=[];
	$(".ck:checked").each(function(){
		ids.push(this.value);
	})
	if(ids.length>0){
		if(confirm("您确定要删除吗")){
			location="delAll?ids="+ids;
		}
	}else{
		alert("请选择数据");
	}
}
</script>
<body>
	<form action="list" method="post">
		品牌名称:<input name="name" value="${g.name}">
		<input type="submit" value="查询">
		<a href="toAdd"><input type="button" value="添加"></a>
		<input type="button" value="删除" onclick="del()">
	<table>
		<tr>
			<td>商品名称</td>
			<td>英文名称</td>
			<td>商品价格</td>
			<td>商品图片</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pg.list}" var="g">
			<tr>
				<td>${g.name}</td>
				<td>${g.ename}</td>
				<td>${g.price}</td>
				<td><img src="${g.pic}" width="180px" height="150px"></td>
				<td>
					<a href="update.jsp?id=#{id}"></a><input type="button" value="修改">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<button name="pageNum" value="1">首页</button>
				<button name="pageNum" value="${pg.prePage==0?1:pg.prePage}">上一页</button>
				<button name="pageNum" value="${pg.nextPage==0?pg.pages:pg.nextPage}">下一页</button>
				<button name="pageNum" value="${pg.pages}">尾页</button>
				总条数:${pg.total}
			</td>
		</tr>
	</table>
	</form>
</body>
</html>