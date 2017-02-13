<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link rel="stylesheet" type="text/css"
	href="/SaleSys/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/SaleSys/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="/SaleSys/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
$(function(){
	$(".goodDelete").click(function(){
		if(confirm("确定删除该项目？")) {
			var goodId = $(this).attr("gid");
			$.ajax({
				url : '../B/deleteGood',
				type : 'POST',
				data : {
					goodId : goodId
				},
				dataType : 'json',
				success : function(data) {
					var status = data.status;
					if(status == 1) {
						$("#good" + goodId).remove();
					}
				},
				error : function() {
					console.log('error');
				}
			})
		}
	});
});
</script>
</head>
<body>
	<%@include file="../Component/headerB.jsp"%>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>照片</th>
				<th>名称</th>
				<th>摘要</th>
				<th>价格(元)</th>
				<th>已售出(件)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goodList}" var="good">
				<tr id="good${good.id}">
					<td><img style="width:60px; height:60px;" alt="${good.title}" src="${good.imgPath}"></td>
					<td><c:out value="${good.title}"></c:out></td>
					<td>
						<span title="${good.summary}">
							<c:if test="${fn:length(good.summary)>10}">  
				                    ${fn:substring(good.summary,0,10)}...  
				            </c:if>  
				            <c:if test="${fn:length(good.summary)<=10}">  
				                ${good.summary}  
				            </c:if>
			            </span>
					</td>
					<td><c:out value="${good.prize}"></c:out></td>
					<td><c:out value="${good.soldCnt}"></c:out></td>
					<td><a class="btn btn-primary" href="goodDetail?id=${good.id}">详细信息／修改</a>
						<c:if test="${good.soldCnt <= 0}">
						   <a class="btn btn-danger goodDelete" gid="${good.id}">删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>