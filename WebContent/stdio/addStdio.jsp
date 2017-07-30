<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/stdio/add" method="post">
		演出厅名称：<input type="text" name="stdioName"><br>
		演出厅行号：<input type="text" name="stdioRows"><br>
		演出厅列号：<input type="text" name="stdioCols"><br>
		演出厅类型：<select id="stdioType" name="stdioType">
					<option value="0">请选择演出厅类型</option>
					<option value="1">3D影厅</option>
					<option value="2">2D影厅</option>
					<option value="3">普通影厅</op.tion>
				</select><br>
		演出厅描述：<textarea rows="3" cols="20" name="stdioDesc"></textarea><br>
		<input type="submit" value="添加">
	</form>
	${msg}<br>
	<a href="${pageContext.request.contextPath}/stdio/list">去影厅列表</a>
</body>
</html>