<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改影厅信息</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/stdio/update" method="post">
		<input type="hidden" name="stdioId" value="${stdInfo.stdioId}" /><br>
		演出厅名称：<input type="text" name="stdioName" value="${stdInfo.stdioName}"><br>
		演出厅行数：<input type="text" name="stdioRows" value="${stdInfo.stdioRows}"><br>
		演出厅列数：<input type="text" name="stdioCols" value="${stdInfo.stdioCols}"><br>
		当前厅类型：<input type="text" value="${stdInfo.stdioType}" readonly="readonly"><br>
		演出厅类型：<select id="stdioType" name="stdioType">
					<option value="0">请选择演出厅类型</option>
					<option value="1">3D影厅</option>
					<option value="2">2D影厅</option>
					<option value="3">普通影厅</option>
				</select><br>
		演出厅描述：<textarea rows="3" cols="20" name="stdioDesc">${stdInfo.stdioDesc}</textarea><br>
		<input type="submit" value="修改">
	</form>
	${msg}<br>
	<a href="${pageContext.request.contextPath}/stdio/list">去影厅列表</a>
</body>
</html>