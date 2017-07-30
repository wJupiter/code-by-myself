<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function mess(id){
	$(".insert").removeClass("hide");
	//var v = document.getElementById("id").innerHTML;
	document.getElementById("empId").value = id;
//	console.log(document.getElementById("empId").value);
}
</script>
</head>
<body>
	<form action="/ttms_ssm/emp/updateEmp" method="post" enctype="multipart/form-data">
		员工编号：<input type="text" name="empId" readonly="readonly" value="${empInfo.empId}"><br/>
		员工账号：<input type="text" name="empNo"><br>
		员工密码：<input type="text" name="empPwd"><br>
		员工姓名：<input type="text" name="empName"><br>
		员工职位：<select name="empPosition">
				<option value="管理员">管理员
				<option value="售票员">售票员
				<option value="普通员工">普通员工
			  </select><br>
		员工性别：<input type="radio" name="sex" value="男">男
				<input type="radio" name="sex" value="女">女<br>
		出生日期：<input type="date" name="dob"/><br>
		员工年龄：<input type="text" name="age"><br>
		电话号码：<input type="text" name="empTel"><br>
		员工邮箱：<input type="text" name="empEmail"><br>
		员工地址：<input type="text" name="empAddress"><br>
		员工头像：<input type="file" name="photo"><br>
		<input type="submit" value="修改">
	</form>
	${msg}
	<a href="/ttms_ssm/emp/list">员工列表</a>
</body>
</html>