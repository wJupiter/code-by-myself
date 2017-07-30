<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页检索</title>
</head>
<body>
	<form action="/ttms_ssm/play/searchPlay" method="post">
		影片名称：<input type="text" name="playName"><br>
		影片类型：<select name="playType">
				<option value="">请选择影片类别</option>
				<option value="科幻片">科幻片</option>
				<option value="惊悚片">惊悚片</option>
				<option value="剧情片">剧情片</option>
				<option value="喜剧片">喜剧片</option>
				<option value="悲剧片">悲剧片</option>
			  </select><br>
		影片语言：<select name="playLanguage">
				<option value="">请选择语言</option>
				<option value="简体中文">简体中文</option>
				<option value="英语">英语</option>
				<option value="韩语">韩语</option>
				<option value="粤语">粤语</option>
				<option value="日语">日语</option>
			  </select><br>
		影片评分<input type="text" name="lowGrade"> ~ <input type="text" name="highGrade">
		<input type="submit" value="查询">
	<hr>	
	</form>
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
					</tr>
				</c:forEach>
				<tr>
					<td colspan="11">
					当前页:${current}	总页数: ${pageCount} 
					<a href="/ttms_ssm/play/searchPlay">首页</a>
					<c:if test="${current == 1}">上一页</c:if><c:if test="${current > 1}"><a href="/ttms_ssm/play/searchPlay?current=${current}&dir=pre">上一页</a></c:if>
					<c:if test="${current == pageCount}">下一页</c:if><c:if test="${current < pageCount}"><a href="/ttms_ssm/play/searchPlay?current=${current}&dir=next">下一页</a></c:if>
					<a href="/ttms_ssm/play/searchPlay?current=${pageCount}">尾页</a>
					</td>
				</tr>				
			</c:if>
		</tbody>
	</table>
</body>
</html>