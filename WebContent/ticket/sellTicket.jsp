<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>售票</title>
<script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
<script>
	$(document).ready(
			function() {
				var stdId = $("input[name='stdId']").val();
				$.get("/ttms_ssm/seat/searchSeat", {
					"stdId" : stdId
				}, function(data) {
					var div1 = $("#seat");
					var html = "座位状态：" + "<br>";
					if (data != null) {
						$.each(data, function(i, seat) {
							html += "座位行号：" + seat.seatRow + ",座位列号："
									+ seat.seatCol + ",座位状态：" + seat.seatStatus
									+ "(1损坏，2空缺)"
						});
						div1.append("<br>");
						div1.html(html);
					}
				}, "json");
			});

	$(document).ready(function() {
		var scheId = $("input[name='scheId']").val();
		var startTime = $("input[name='startTime']").val();
		$.get("/ttms_ssm/ticket/searchTicket", {
			"scheId" : scheId,
			"startTime" : startTime
		}, function(data) {
			var div2 = $("#ticket");
			var html = "售票状态：" + "<br>";
			if (data != null) {
				$.each(data, function(i, ticket) {
					html +=  "座位行号：" + ticket.seatRow + ",座位列号："
					+ ticket.seatCol + ",座位状态：" + ticket.ticketStatus
					+ "(0退票后修改的状态,1已选定, 2已售出)&nbsp;&nbsp;&nbsp;&nbsp;";
				});
				div2.append("<br>");
				div2.html(html);
			}
		}, "json");
	});
	
	$(document).ready(function() {
		$("#buttonSet").click(function() {
			alert("ss");
			var formParam = $("#form1").serialize();//序列化表格内容为字符串  
			console.log(formParam);
			$.ajax({
				type : "post",
				url : "/ttms_ssm/ticket/createTicket",
				data : formParam,
				cache : false,
				dataType : "json",
				success : function(data) {
					console.log(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- 座位列表 -->
	<div id="seat"></div>
	<!-- 已选定座位 -->
	<div id="ticket"></div>
	请输入座位的行号列号：
	<input type="hidden" name="stdId" value="${sessionScope.scheInfo.stdioInfo.stdioId}">
	<input type="hidden" name="startTime" value="${sessionScope.scheInfo.scheStartTime}">
	<form action="" method="post" id="form1">
		<input type="hidden" name="scheId" value="${sessionScope.scheInfo.scheId}"> 
		<input type="hidden" name="ticketPrice" value="${sessionScope.scheInfo.playInfo.playTicketPrice}">
		<input type="text" name="seatRow"> ~ <input type="text" name="seatCol">
		<input type="button" id="buttonSet" value="选定" >
	</form>
	
</body>
</html>