<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影片列表</title>
</head>
	<a href="/ttms_ssm/play/searchPlay">分页检索</a>
<body>
	<table>
		<thead>
			<tr>
				<th>影片编号</th>
				<th>影片名称</th>
				<th>影片类型</th>
				<th>影片语言</th>
				<th>影片介绍</th>
				<th>影片长度</th>
				<th>影片海报</th>
				<th>影片导演</th>
				<th>影片主演</th>
				<th>影片票价</th>
				<th>影片评分</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty playList}">
				<c:forEach items="${playList}" var="play">
					<tr>
						<td>${play.playId}</td>
						<td>${play.playName}</td>
						<td>${play.playType}</td>
						<td>${play.playLanguage}</td>
						<td>${play.playDesc}</td>
						<td>${play.playLength}分钟</td>
						<td><img src="${pageContext.request.contextPath}${play.playImage}" alt="海报" width="20" height="20"/></td>
						<td>${play.playDirector}</td>
						<td>${play.playActor}</td>
						<td>${play.playTicketPrice}</td>
						<td>${play.playGrade}</td>
						<td><a href="${pageContext.request.contextPath}/play/getPlayById/${play.playId}">修改</a></td>
						<td><a href="${pageContext.request.contextPath}/play/deletePlay/${play.playId}">删除</a></td>
					</tr>
				</c:forEach>				
			</c:if>
		</tbody>
	</table>
</body>
</html>