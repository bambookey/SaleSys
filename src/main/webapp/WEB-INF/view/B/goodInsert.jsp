<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodInsert</title>
<link rel="stylesheet" type="text/css"
	href="/SaleSys//resources/bootstrap/css/bootstrap.min.css">

<script type="text/javascript" src="/SaleSys/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/SaleSys/resources/js/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="/SaleSys/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(window).on('load', function() {
		$("#btnInsert").click(function() {
			var title = $("#iptTitle").val();
			var summary = $("#iptSummary").val();
			var text = $("#iptText").val();
			var img = $("#iptImgPath").val();
			var prize = $("#iptPrize").val();

			$.ajax({
				url : '../B/insertGood',
				type : 'POST',
				data : {
					title : title,
					summary : summary,
					text : text,
					img : img,
					prize : prize
				},
				dataType : 'json',
				success : function(data) {
					var status = data.status;
					if (status == 0) {
						alert("添加商品成功");
					}
				},
				error : function() {
					alert("添加商品失败，请注意格式");
					console.log('error');
				}
			})
		});

		$("#iptImg").change(function() {
			ajaxFileUpload();
		});
		
		function ajaxFileUpload(){
			$("#fileUploadMsg").html("");
			$.ajaxFileUpload({ 
				url : '../fileUpload',
				fileElementId : 'iptImg', 
				dataType : 'text', 
				success : function(data) {
					var result = eval("(" + data + ")");
					var status = result.status;
					var imgPath = result.filePath;
					
					if(status == 0) {
						$("#iptImgPath").val(imgPath);
						$("#picView").html("<img style='width:200px; height:200px;' src="+imgPath+">");
					} else {
						$("#fileUploadMsg").html("图片上传大小超过最高限制，请上传小于1M的图片");
					}
					
					$("#iptImg").change(function() {
						ajaxFileUpload();
					});
				},
				error : function() {
					console.log("error")
				}
			});
		}
	});
</script>
</head>
<body>
	<%@include file="../Component/headerB.jsp"%>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label class="col-sm-2 control-label">商品标题</label>
			<div class="col-sm-6">
				<input class="form-control" id="iptTitle" type="text">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">商品摘要</label>
			<div class="col-sm-6">
				<input class="form-control" id="iptSummary" type="text">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">介绍正文</label>
			<div class="col-sm-6">
				<input class="form-control" id="iptText" type="text">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">上传图片</label>
			<div class="col-sm-6">
				<span id="picView"></span>
				<input id="iptImgPath" type="hidden">
				<input id="iptImg" type="file" name="file" style="display: inline;">
				<span id="fileUploadMsg" style="color:#F00;"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">商品价格</label>
			<div class="col-sm-2">
				<input class="form-control" id="iptPrize" type="text">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-6">
				<input id="btnInsert" type="button" class="btn btn-primary"
					value="添加商品">
				<div id="result"></div>
			</div>
		</div>
	</form>
</body>
</html>