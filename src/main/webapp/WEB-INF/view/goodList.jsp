<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodList</title>
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>照片</th>
				<th>名称</th>
				<th>摘要</th>
				<th>价格（元）</th>
				<th>可用</th>
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
					<td><c:out value="${good.isAvailable}"></c:out></td>
					<td><a class="btn btn-primary" href="goodDetail?id=${good.id}">详细信息／修改</a>
					<a class="btn btn-danger" href="">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>