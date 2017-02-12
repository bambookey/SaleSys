<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(function () {
    $(".faq-tabbable").find("li").each(function () {
        var a = $(this).find("a:first")[0];
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
			<a class="navbar-brand" href="#">SaleSys[B端]</a>
		</div>
		<div>
			<ul class="nav navbar-nav faq-tabbable">
				<li class="active"><a href="/SaleSys/B/goodList">货物清单</a></li>
				<li><a href="/SaleSys/B/goodInsert">添加商品</a></li>
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