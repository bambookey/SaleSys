<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodDetail</title>
<link rel="stylesheet" type="text/css"
	href="/SaleSys/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/SaleSys/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="/SaleSys/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".btnTrollery").click(function(){
		var gname = $(this).attr("gname");
		if(confirm("是否要添加" +gname+ "至购物车？")) {
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
					switch(status) {
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
});
</script>
</head>
<body>
	<%@include file="../Component/headerC.jsp"%>
	<div class="form-horizontal">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">展示图片</label>
			<div class="col-sm-10">
				<div id="picView">
					<img style="width:200px; height:200px;" alt="${good.title}" src="${good.imgPath}">
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品名称</label>
			<div class="col-sm-10">
				<span>${good.title}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品单价</label>
			<div class="col-sm-10">
				<span>${good.prize}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品摘要</label>
			<div class="col-sm-10">
			<span>${good.summary}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">详细内容</label>
			<div class="col-sm-10">
			<span>${good.text}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<a class="btn btn-primary btnTrollery" gid="${good.id}" gname="${good.title}">加入购物车</a>
			</div>
		</div>
	</div>
	
</body>
</html>