<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加演出计划</title>
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
	
	$(document).ready(function(){
		$.get("/ttms_ssm/sche/getPlayList",{},function(data){
			var html = "";
			if(data != null){
				var div = $("#playList");
				div.empty();
				$.each(data,function(d,play){
					html +="影片名称：" + "<input type='radio' name='playId' value='"+ play.playId + "'>" 
						+ "<input type='text' value='"+ play.playName +"' readonly='readonly'> " + "<br>" 
				});
				div.html(html);
			}
		},"json");
	});
</script>
</head>
<body>
	<form action="/ttms_ssm/sche/addSche" method="post">
		演出厅：<select name="stdioId" id="stdioId">
			</select><br>
		演出开始的时间：<select name="startTime">
			<option value="1">8:00</option>
			<option value="2">10:30</option>
			<option value="3">13:00</option>
			<option value="4">15:30</option>
			<option value="5">18:00</option>
			<option value="6">20:30</option>
		</select><br>
		
		<div id="playList">
		</div>
		<%-- <c:if test="${not empty playList}">
			<c:forEach items="${playList}" var="play">
				影片名称： <input type="radio" name="playId" value="${play.playId}"> 
						<input type="text" name="" value="${play.playName}" readonly="readonly"><br>
			</c:forEach>
		</c:if> --%>
		<input type="submit" value="添加">
		${msg}	
	</form>
	<a href="/ttms_ssm/sche/getScheduleList">演出计划表</a>
</body>
</html>
