<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加影片</title>
</head>
<body>
	<form action="/ttms_ssm/play/updatePlay" method="post" enctype="multipart/form-data">
		<input type="hidden" name="playId" value="${info.playId}">
		影片名称：<input type="text" name="playName" value="${info.playName}"><br>
		影片类型：<select name="playType">
				<option value="科幻片">科幻片</option>
				<option value="惊悚片">惊悚片</option>
				<option value="剧情片">剧情片</option>
				<option value="喜剧片">喜剧片</option>
				<option value="悲剧片">悲剧片</option>
			  </select><br>
		影片语言：<select name="playLanguage">
				<option value="简体中文">简体中文</option>
				<option value="英语">英语</option>
				<option value="韩语">韩语</option>
				<option value="粤语">粤语</option>
				<option value="日语">日语</option>
			  </select><br>
		影片描述：<textarea rows="4" cols="30" name="playDesc">${info.playDesc}</textarea><br>
		影片长度：<input type="text" name="playLength" value="${info.playLength}"><br>
		影片导演：<input type="text" name="playDirector" value="${info.playDirector}"><br>
		影片演员：<input type="text" name="playActor" value="${info.playActor}"><br>
		影片票价：<input type="text" name="playTicketPrice" value="${info.playTicketPrice}"><br>
		影片评分：<input type="text" name="playGrade" value="${info.playGrade}"><br>
		影片海报：<input type="file" name="Image" value="${info.playImage}">
		<input type="submit" value="修改"><br>
	</form>
	${msg}
	<a href="/ttms_ssm/play/playList">影片列表</a>
</body>
</html>