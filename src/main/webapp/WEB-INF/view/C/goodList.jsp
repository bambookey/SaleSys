<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodList</title>
<link rel="stylesheet" type="text/css"
	href="/SaleSys/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="/SaleSys/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="/SaleSys/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/SaleSys/resources/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		$(".btnTrollery").click(function() {
			var gname = $(this).attr("gname");
			if (confirm("是否要添加" + gname + "至购物车？")) {
				var gid = $(this).attr("gid");
				$.ajax({
					url : '../C/insertTrolley',
					type : 'POST',
					data : {
						goodId : gid
					},
					dataType : 'json',
					success : function(data) {
						var status = data.status;
						switch (status) {
						case 0:alert("添加成功，记得去购物车结账");break;
						case 1:alert("已经添加，记得去购物车结账");break;
						case 500:alert("系统故障，请稍后重试");break;
						default:alert("未知状态");break;
						}
					},
					error : function() {
						console.log('error');
					}
				})
			}
		});

		
		var unPurchased = parseInt(getQueryVariable("noPurchase"));
		console.log(unPurchased)
		if(unPurchased == 1) {
			$("#btnShowAll").show();
		} else {
			$("#btnShowNoPurchase").show();
		}
	});
</script>
</head>
<body>
	<%@include file="../Component/headerC.jsp"%>
	<div>
		<a id="btnShowNoPurchase" style="display:none;" class="btn btn-primary btnPurchased" href="/SaleSys/C/goodList?noPurchase=1">查看未购商品</a>
		<a id="btnShowAll" style="display:none;" class="btn btn-primary btnPurchased" href="/SaleSys/C/goodList">查看全部商品</a>
	</div>
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
					<td><img style="width: 60px; height: 60px;"
						alt="${good.title}" src="${good.imgPath}"> <c:if
							test="${good.isBought}">
							[已购买]
						</c:if></td>
					<td><a href="../C/goodDetail?id=${good.id}"><c:out
								value="${good.title}"></c:out></a></td>
					<td><c:out value="${good.summary}"></c:out></td>
					<td><c:out value="${good.prize}"></c:out></td>
					<td><a class="btn btn-primary" href="goodDetail?id=${good.id}">详情</a>
						<a class="btn btn-primary btnTrollery" gid="${good.id}"
						gname="${good.title}">加入购物车</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>