<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="/SaleSys/resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/SaleSys/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/SaleSys/resources/js/md5.js"></script>
<script type="text/javascript"
	src="/SaleSys/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		document.onkeydown = function (e) { 
			var theEvent = window.event || e; 
			var code = theEvent.keyCode || theEvent.which; 
			if (code == 13) { 
			$("#btnLogin").click(); 
			} 
		}  
		
		$("#btnLogin").click(function() {
			login();
		});
		
		function login() {
			var userId = $("#userId").val();
			var userPassword = hex_md5($("#userPassword").val());
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
					if (status == 0) { // login success
						if (userType == 0) { //seller
							window.location.href = "B/goodList";
						} else if (userType == 1) { //buyer
							window.location.href = "C/goodList";
						}
					} else {
						$("#msgBox").html("用户名或密码错误");
					}
				},
				error : function() {
					console.log('error');
				}
			})
		}
	});
</script>
<style type="text/css">
.loginItem{ margin:0 0 8px 0;}
</style>
</head>
<body>
	<div class="row" style="margin:100px auto 0 auto;width:500px;">
		<div class="col-md-12">
			<div class="well col-md-12">
				<h3>用户登录</h3>
				<div class="input-group input-group-md loginItem">
					<span class="input-group-addon" id="sizing-addon1"><i
						class="glyphicon glyphicon-user" aria-hidden="true"></i></span> <input
						id="userId" type="text" class="form-control" placeholder="用户名">
				</div>
				<div class="input-group input-group-md loginItem">
					<span class="input-group-addon" id="sizing-addon1"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="userPassword"
						type="password" class="form-control" placeholder="密码">
				</div>
				<div class="loginItem">
					<input id="btnLogin" type="submit" class="btn btn-primary btn-block" value="登录">
				</div>
				<div>
					<span id="msgBox"></span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>