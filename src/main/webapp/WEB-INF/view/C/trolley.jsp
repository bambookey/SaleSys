<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trolley</title>
<link rel="stylesheet" type="text/css"
	href="../resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="../resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//Add
		$(".quantity-add").click(function(e) {
			//Vars
			var count = 1;
			var newcount = 0;

			//Wert holen + Rechnen
			var elemID = $(this).parent().attr("id");
			var countField = $("#" + elemID + 'inp');
			var count = $("#" + elemID + 'inp').val();
			var newcount = parseInt(count) + 1;

			//Neuen Wert setzen
			$("#" + elemID + 'inp').val(newcount);
		});

		//Remove
		$(".quantity-remove").click(function(e) {
			//Vars
			var count = 1;
			var newcount = 0;

			//Wert holen + Rechnen
			var elemID = $(this).parent().attr("id");
			var countField = $("#" + elemID + 'inp');
			var count = $("#" + elemID + 'inp').val();
			var newcount = parseInt(count) - 1;
			if(newcount < 1) {
				return false;
			}
			//Neuen Wert setzen
			$("#" + elemID + 'inp').val(newcount);
		});
		
		$(".trolleyCheck").click(function(){
			refreshShowMoney();
		});
		
		$(".quantity-add").click(function(){
			refreshShowMoney();
		});
		
		$(".quantity-remove").click(function(){
			refreshShowMoney();
		});
		
		
		var goodIds = new Array();
		var goodCnts = new Array();
		function refreshShowMoney() {
			var totalMoney = 0;
			goodIds = new Array();
			goodCnts = new Array();
			$(".trolleyItemTr").each(function(){
				var _tr = $(this);
				if(_tr.find(".trolleyCheck").eq(0).is(':checked')) {
					var prize = _tr.find(".trolleyPrize").eq(0).val() * 1;
					var count = _tr.find(".quantity-count").eq(0).val() * 1;
					var gid = _tr.find(".gid").eq(0).val();
					totalMoney += prize * count;
					
					goodCnts.push(count);
					goodIds.push(gid);
				}
			});
			$("#totalMoney").html(totalMoney);
		}
		
		$("#btnTrolleySubmit").click(function(){
			submitTrolley();
		});
		
		function submitTrolley() {
			console.log(goodCnts);
			console.log(goodIds);
			
			$.ajax({
				url : '../C/insertShoppingRecords',
				type : 'POST',
				data : {
					goodIds : goodIds,
					goodCnts : goodCnts
				},
				dataType : 'json',
				success : function(data) {
					console.log(data)
				},
				error : function() {
					console.log('error');
				}
			})
		}
	});
</script>
</head>
<body>
	<%@include file="../Component/headerC.jsp"%>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>选择</th>
				<th>照片</th>
				<th>商品名称</th>
				<th>单价</th>
				<th>选择数量</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trolleys}" var="trolley">
				<tr class="trolleyItemTr">
					
					<td>
						<input class="gid" value="${trolley.id}" type="hidden">
						<input class="trolleyCheck" id="trolleyCheck_${trolley.id}" type="checkbox">
					</td>
					<td><img style="width:60px; height:60px;" alt="${trolley.title}" src="${trolley.imgPath}"></td>
					<td><a href="../C/goodDetail?id=${trolley.id}"><c:out value="${trolley.title}"></c:out></a></td>
					<td><input type="hidden" class="trolleyPrize" value="${trolley.prize}"><c:out value="${trolley.prize}"></c:out></td>
					<td>
						<div class="col-md-3">
	                        <div class="form-group form-group-options">
	                            <div id="${trolley.id}" class="input-group input-group-option quantity-wrapper">
	                                <span  class="input-group-addon input-group-addon-remove quantity-remove btn">
	                                    <span class="glyphicon glyphicon-minus"></span>
	                                </span>
	                                <input  id="${trolley.id}inp" type="text" value="1" name="option[]"
	                                 style="width:50px; text-align:center;" class="form-control quantity-count" placeholder="1">
	                                <span class="input-group-addon input-group-addon-remove quantity-add btn">
	                                    <span class="glyphicon glyphicon-plus"></span>
	                                </span>
	                            </div>
	                        </div>
	                    </div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>合计: ¥<span id="totalMoney">0</span></div>
	<input type="hidden" value="0">
	<input class="btn btn-primary" id="btnTrolleySubmit" value="提交订单">
</body>
</html>