<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodList</title>
<link rel="stylesheet" type="text/css"
	href="../resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="../resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".btnTrollery").click(function(){
		var gid = $(this).attr("gid");
		console.log(gid);
		$.ajax({
			url : '../C/insertTrolley',
			type : 'POST',
			data : {
				goodId : gid
			},
			dataType : 'json',
			success : function(data) {
				
			},
			error : function() {
				console.log('error');
			}
		})
	});
});
</script>
</head>
<body>
	<%@include file="../Component/headerC.jsp"%>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>照片</th>
				<th>名称</th>
				<th>摘要</th>
				<th>价格（元）</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goodList}" var="good">
				<tr>
					<td></td>
					<td><c:out value="${good.title}"></c:out></td>
					<td><c:out value="${good.summary}"></c:out></td>
					<td><c:out value="${good.prize}"></c:out></td>
					<td><a class="btn btn-primary" href="goodDetail?id=${good.id}">详情</a>
					<a class="btn btn-primary btnTrollery" gid="${good.id}" }>加入购物车</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>