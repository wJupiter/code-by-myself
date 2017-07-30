<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影厅列表</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>影厅编号</th>
				<th>影厅名称</th>
				<th>座位行数</th>
				<th>座位列数</th>
				<th>影厅类型</th>
				<th>影厅类型</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty stdList}">
				<c:forEach items="${stdList}" var="std">
					<tr>
						<td>${std.stdioId}</td>
						<td>${std.stdioName}</td>
						<td>${std.stdioRows}</td>
						<td>${std.stdioCols}</td>
						<td>${std.stdioType}</td>
						<td>${std.stdioDesc}</td>
						<td><a href="${pageContext.request.contextPath}/stdio/getInfoById/${std.stdioId}">修改</a></td>
						<td><a href="${pageContext.request.contextPath}/stdio/deleteStdio/${std.stdioId}">删除</a></td>
					</tr>
				</c:forEach>				
			</c:if>
		</tbody>
	</table>
</body>
</html>