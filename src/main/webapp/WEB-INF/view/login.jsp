<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnLogin").click(function() {
			var userId = $("#userId").val();
			var userPassword = $("#userPassword").val();
			$.ajax({
				url : 'userLogin',
				type : 'POST',
				data : {
					userId : userId,
					userPassword : userPassword
				},
				dataType : 'json',
				success : function(data) {
					var userType = data.userType;
					var status = data.status;
					if(status == 0) { // login success
						if(status == 0) { //seller
							window.location.href = "goodList";
						} else if(status == 1) { //buyer
							window.location.href = "login";
						}
					} else {
						$("#msgBox").html("用户名或密码错误");
					}
				},
				error : function() {
					console.log('error');
				}
			})
		});
	});
</script>
</head>
<body>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="inputUserName" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-10">
				<input id="userId" type="text" class="form-control"
					id="inputUserName" placeholder="请输入用户名">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10">
				<input id="userPassword" type="password" class="form-control"
					id="inputPassword" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<input id="btnLogin" type="button" class="btn btn-primary"
					value="登录"><span id="msgBox"></span>
			</div>
		</div>
	</form>
</body>
</html>