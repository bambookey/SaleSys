<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="../resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="../resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="../Component/headerC.jsp"%>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>名称</th>
				<th>摘要</th>
				<th>提交日期</th>
				<th>选择数量</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trolleys}" var="trolley">
				<tr>
					<td><c:out value="${trolley.userId}"></c:out></td>
					<td><c:out value="${trolley.goodId}"></c:out></td>
					<td><c:out value="${trolley.insertDatetime}"></c:out></td>
					<td></td>
					<td><a class="btn btn-primary" href="goodDetail?id=${trolley.id}">提交订单</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>