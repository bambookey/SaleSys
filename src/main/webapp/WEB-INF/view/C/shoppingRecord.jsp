<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShoppingRecords</title>
<link rel="stylesheet" type="text/css"
	href="../resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="../resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<%@include file="../Component/headerC.jsp"%>
	<div>
		<span>您共消费<span>${totalMoney}</span>元
		</span>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>照片</th>
				<th>商品名称</th>
				<th>单价(元)</th>
				<th>购买数量</th>
				<th>总价(元)</th>
				<th>购买日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shoppingRecordVOList}" var="record">
				<tr>
					<td><img style="width: 60px; height: 60px;"
						alt="${record.goodName}" src="${record.imgPath}"></td>
					<td>${record.goodName}</td>
					<td>${record.goodPrize}</td>
					<td>${record.goodCnt}</td>
					<td>${record.totalPrize}</td>
					<td>${record.insertDatetime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>