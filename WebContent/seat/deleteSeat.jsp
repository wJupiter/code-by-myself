<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除座位</title>
<script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$.get("/ttms_ssm/sche/getStdioList",{}, function(data){
				var html = "<option value='0'>请选择演出厅</option>";
				if(data!=null){
					$.each(data,function(i, std){
						html += "<option value='"+ std.stdioId +"'>"
						+ std.stdioName + "</option>";
						});
					$("#stdioId").html(html);
				}
			},"json");
		});
</script>
</head>
<body>
	<form action="/ttms_ssm/seat/deleteSeat" method="post">
		演出厅编号<select id="stdioId" name="stdioId">
				</select><br>
		座位行号：<input type="text" name="seatRow"><br>
		座位列号：<input type="text" name="seatCol"><br>
		<input type="submit" value="删除">
	</form>
	${msg}
</body>
</html>