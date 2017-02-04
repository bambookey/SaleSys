<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(function () {
    $(".faq-tabbable").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        console.log(location.pathname)
        if ($(a).attr("href") === location.pathname) {
            $(this).addClass("active");
        } else {
            $(this).removeClass("active");
        }
    });
})
</script>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">SaleSys</a>
		</div>
		<div>
			<ul class="nav navbar-nav faq-tabbable">
				<li class="active"><a href="/SaleSys/C/goodList">商品一览</a></li>
				<li><a href="/SaleSys/C/trolley">购物车</a></li>
				<li><a href="/SaleSys/C/shoppingRecord">已购买</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a><span class="glyphicon glyphicon-user"></span> <%=session.getAttribute("NickName")%></a></li>
				<li><a href="../logout"><span class="glyphicon glyphicon-log-in"></span>
						登出</a></li>
			</ul>
		</div>
	</div>
	</nav>
</body>
</html>