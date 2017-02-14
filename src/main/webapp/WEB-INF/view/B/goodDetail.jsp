<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品【${good.title}】</title>
<link rel="stylesheet" type="text/css"
	href="/SaleSys/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/SaleSys/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/SaleSys/resources/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="/SaleSys/resources/js/validator.js"></script>
<script type="text/javascript"
	src="/SaleSys//resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(window).on('load', function() {
	$("#goodUpdateForm").validator().on("submit", function (e) {
		if (!e.isDefaultPrevented()) {
			goodUpdate();
		}
		e.preventDefault();
		return false;
	});
	
	function goodUpdate() {
		var id = $("#iptId").val();
		var title = $("#iptTitle").val();
		var summary = $("#iptSummary").val();
		var text = $("#iptText").val();
		var img = $("#iptImgPath").val();
		var prize = $("#iptPrize").val();
		$.ajax({
			url : '../B/updateGood',
			type : 'POST',
			data : {
				id : id,
				title : title,
				summary : summary,
				text : text,
				img : img,
				prize : prize
			},
			dataType : 'json',
			success : function(data) {
				alert("更新成功");
			},
			error : function() {
				console.log('error');
			}
		})
	}
	
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
			error : function() { //服务器响应失败时的处理函数  
				console.log("error")
			}
		});
	}
});
</script>
<body>
	<%@include file="../Component/headerB.jsp"%>
	<form class="form-horizontal" role="form" id="goodUpdateForm">
		<input type="hidden" id="iptId" value="${good.id}">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品名称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="iptTitle"
					value="${good.title}" placeholder="2-80字符"
					data-minlength="2" data-maxlength="80" data-error="标题长度为2-80个字符。" required>
				<div class="help-block with-errors"></div>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品摘要</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="iptSummary"
					value="${good.summary}" placeholder="2-140字符"
					data-minlength="2" data-maxlength="140" data-error="摘要长度为2-140个字符。" required>
				<div class="help-block with-errors"></div>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">详细内容</label>
			<div class="col-sm-6">
				<textarea class="form-control" rows="5" id="iptText" placeholder="2-1000字符" 
				 data-minlength="2" data-maxlength="140" data-error="正文长度为2-1000个字符。" required>${good.text}</textarea>
				<div class="help-block with-errors"></div>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">展示图片</label>
			<div class="col-sm-6">
				<div id="picView">
					<img style="width:200px; height:200px;" alt="${good.title}" src="${good.imgPath}">
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">图片路径</label>
			<%-- <div class="col-sm-10">
				<input type="text" class="form-control" id="firstname"
					value="${good.imgPath}">
			</div> --%>
			<div class="col-sm-6">
				<input id="iptImgPath" type="hidden" value="${good.imgPath}">
				<input id="iptImg" type="file" name="file" style="display: inline;">
				<span id="fileUploadMsg" style="color:#F00;"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">商品价格</label>
			<div class="col-sm-2">
				<input class="form-control" id="iptPrize"
					value="${good.prize}" type="number" min="0" step="0.01" required>
				<div class="help-block with-errors"></div>
			</div>
			<p class="form-control-static">元</p>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label"></label>
			<div class="col-sm-6">
				<input id="btnUpdate" type="submit" class="btn btn-primary"
					value="更新">
				<a class="btn btn-primary" href="/SaleSys/B/goodList">&lt&lt返回货物清单</a>
			</div>
		</div>
	</form>
	<%@include file="../Component/footer.jsp"%>
</body>
</html>