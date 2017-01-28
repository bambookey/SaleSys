<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodDetail</title>
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname"
					value="${good.title}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品摘要</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname"
					value="${good.summary}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">详细内容</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname"
					value="${good.text}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">图片路径</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname"
					value="${good.imgPath}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">是否可用</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname"
					value="${good.isAvailable}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input id="btnUpdate" type="button" class="btn btn-primary"
					value="更新">
			</div>
		</div>
	</form>
	
</body>
</html>