<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../resources/bootstrap/css/bootstrap.min.css">

<script type="text/javascript" src="../resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../resources/js/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="../resources/bootstrap/js/bootstrap.min.js"></script>
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
						alert("INSERT SUCCESS");
					}
					console.log(data);
				},
				error : function() {
					console.log('error');
				}
			})
		});

		$("#iptImg").change(function() {
			ajaxFileUpload();
		});
		
		function ajaxFileUpload(){
			$.ajaxFileUpload({
				//处理文件上传操作的服务器端地址(可以传参数,已亲测可用)  
				url : '../fileUpload',
				fileElementId : 'iptImg', //文件选择框的id属性  
				dataType : 'text', //服务器返回的格式,可以是json或xml等  
				success : function(data) { //服务器响应成功时的处理函数  
					var imgPath = data;
					$("#iptImgPath").val(imgPath);
					console.log(imgPath)
					$("#picView").html("<img style='width:200px; height:200px;' src=../upload/"+imgPath+">");
					//
					$("#iptImg").change(function() {
						ajaxFileUpload();
					});
				},
				error : function() { //服务器响应失败时的处理函数  
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
			<div class="col-sm-10">
				<input class="form-control" id="iptTitle" type="text" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">商品摘要</label>
			<div class="col-sm-10">
				<input class="form-control" id="iptSummary" type="text"
					placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">介绍正文</label>
			<div class="col-sm-10">
				<input class="form-control" id="iptText" type="text" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">上传图片</label>
			<div class="col-sm-10">
				<input id="iptImgPath" type="hidden">
				<input id="iptImg" type="file" name="file" style="display: inline;">
				<span id="picView"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">商品价格</label>
			<div class="col-sm-10">
				<input class="form-control" id="iptPrize" type="text" placeholder="">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input id="btnInsert" type="button" class="btn btn-primary"
					value="添加商品">
				<div id="result"></div>
			</div>
		</div>
	</form>
</body>
</html>