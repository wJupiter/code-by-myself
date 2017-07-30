<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ttms_ssm/emp/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="empPhoto"/>
		<input type="submit" value="上传"/>
	</form>
	${msg}<br>
	用户头像:<img alt="暂无图片" src="${pageContext.request.contextPath}${fileUrl}" />	
</body>
</html>