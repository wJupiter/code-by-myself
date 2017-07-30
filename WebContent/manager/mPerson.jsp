<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>人员管理</title>
 <link href="/ttms_ssm/css/footer.css" rel="stylesheet" media="all"/>
<link rel="stylesheet" type="text/css"
	href="/ttms_ssm/dist/css/bootstrap.min.css">
<script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/ttms_ssm/css/mPerson.css">
<script type="text/javascript">
function mess(id){
	$(".insertModifi").removeClass("hide");
	//var v = document.getElementById("id").innerHTML;
	document.getElementById("empId").value = id;
	console.log(document.getElementById("empId").value);
}
function add(){
	$(".insertAdd").removeClass("hide");
	//var v = document.getElementById("id").innerHTML;
	//document.getElementById("empId").value = id;
}
</script>
</head>

<body>

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">永乐票务</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li ><a href="/ttms_ssm/stdio/list">演出厅管理</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">演出计划 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/ttms_ssm/sche/getScheduleList">演出计划列表</a></li>
							<li><a href="/ttms_ssm/manager/addSchedule.jsp">添加演出计划</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">影片管理 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/ttms_ssm/play/playList">影片列表</a></li>
							<li><a href="/ttms_ssm/manager/addPlay.jsp">添加影片</a></li>
							<li><a href="#">分页检索</a></li>
						</ul>
					</li>
					<li class="active"> <a href="/ttms_ssm/emp/list">人员管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/ttms_ssm/emp/getInfoById/${sessionScope.empId}">个人中心</a></li>
					<li><a href="#">关于</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container-fluid  context" style="margin-top:70px;">

			<table class="table table-hover" id="table">
				<thead>
					<tr>
						<th>员工编号</th>
						<th>员工账号</th>
						<th>员工姓名</th>
						<th>员工职位</th>
						<th>员工性别</th>
						<th>出生日期</th>
						<th>员工年龄</th>
						<th>员工电话</th>
						<th>员工邮箱</th>
						<th>员工地址</th>
						<th>员工头像</th>
						<th colspan="2">操作</th>
						<th><button class="btn btn-info" onclick="add()">添加</button></th>
					</tr>
				</thead>
			<c:if test="${not empty empList}">
				<tbody>
					<c:forEach items="${empList}" var="emp">
						<tr>
							<td align="center" style="height: 50px;">${emp.empId}</td>
							<td align="center">${emp.empNo}</td>
							<td align="center">${emp.empName}</td>
							<td align="center">${emp.empPosition}</td>
							<td align="center">${emp.sex}</td>
							<td align="center">${emp.tempDob}</td>
							<td align="center">${emp.age}</td>
							<td align="center">${emp.empTel}</td>
							<td align="center">${emp.empEmail}</td>
							<td align="center">${emp.empAddress}</td>
							<td align="center"><img
								src="${pageContext.request.contextPath}${emp.empPhoto}" alt="头像"
								width="20" height="20" /></td>
							<%-- <td><a href="${pageContext.request.contextPath}/emp/getInfoById/${emp.empId}">修改</a></td> --%>
							<td align="center"><a href="#" onclick="mess(${emp.empId})">修改</a></td>
							<td align="center"><a
								href="${pageContext.request.contextPath}/emp/deleteEmp/${emp.empId}">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
		</c:if>
			</table>
		<div class="row">
			<div class="col-md-6 insertAdd hide">
				<h3>添加人员</h3>
			</div>
			<div class="col-md-6 insertModifi hide">
				<h3>修改人员</h3>
			</div>
		</div>
		<div class="row">
			<div class="insertAdd hide col-md-6">
				<form action="/ttms_ssm/emp/addEmp" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="empNo">员工账号：</label> <input type="text" name="empNo"
							id="empNo" class="form-control"> <label for="empName">员工姓名：</label>
						<input type="text" name="empName" id="empName"
							class="form-control"> <label for="empPosition">员工职位：</label>
						<select name="empPosition" id="empPosition" class="form-control">
							<option value="管理员">管理员
							<option value="售票员">售票员
							<option value="普通员工">普通员工
						</select> 
						<br>
						<label>员工性别：</label>
						<div class="radio">
							<label> <input type="radio" name="sex"
								id="optionsRadios1" value="男" checked>男
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="sex"
								id="optionsRadios1" value="女" checked> 女
							</label>
						</div>
						
						<label for="dob">出生日期：</label> 
						<input type="date" name="dob" id="dob"
							class="form-control" /> 
						<label for="age">员工年龄:</label>
						 <input
							type="text" name="age" id="age" class="form-control" /> 
							<label
							for="empTel">电话号码：</label> <input type="text" name="empTel"
							id="empTel" class="form-control"> <label for="empEmail">员工邮箱:</label>
						<input type="text" name="empEmail" id="empEmail"
							class="form-control">
							 <label for="empAddress">员工地址:</label>
						<input type="text" name="empAddress" id="empAddress"
							class="form-control">
							 <label for="photo">员工头像:</label> <input
							type="file" name="photo" id="photo">
                        <br>
						<input type="submit" value="添加" class="btn btn-info">
					</div>
				</form>

			</div>

			<div class="insertModifi hide col-md-6">
				<form action="/ttms_ssm/emp/updateEmp" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
					<label for="empId">员工编号：</label>
					<input type="text" name="empId" id="empId" readonly="readonly" class="form-control">
						<label for="empNo">员工账号：</label> <input type="text" name="empNo"
							id="empNo" class="form-control">
						<label for="empNo">员工密码：</label> <input type="text" name="empPwd"
							id="empNo" class="form-control"> <label for="empName">员工姓名：</label>
						<input type="text" name="empName" id="empName"
							class="form-control"> <label for="empPosition">员工职位：</label>
						<select name="empPosition" id="empPosition" class="form-control">
							<option value="管理员">管理员
							<option value="售票员">售票员
							<option value="普通员工">普通员工
						</select> 
						<br>
						<label>员工性别：</label>
						<div class="radio">
							<label> <input type="radio" name="sex"
								id="optionsRadios1" value="男" checked>男
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="sex"
								id="optionsRadios1" value="女" > 女
							</label>
						</div>
						<!-- <label for="dob">出生日期：</label> 
						<input type="date" name="dob" id="dob"
							class="form-control" />  -->
						<label for="age">员工年龄:</label>
						 <input
							type="text" name="age" id="age" class="form-control" /> 
							<label
							for="empTel">电话号码：</label> <input type="text" name="empTel"
							id="empTel" class="form-control"> <label for="empEmail">员工邮箱:</label>
						<input type="text" name="empEmail" id="empEmail"
							class="form-control">
							 <label for="empAddress">员工地址:</label>
						<input type="text" name="empAddress" id="empAddress"
							class="form-control">
							 <label for="photo">员工头像:</label> <input
							type="file" name="photo" id="photo">
                        <br><br>
						<input type="submit" value="修改" class="btn btn-info">
						</div>
				</form>
			</div>
		</div>
	</div>
	<footer class="footer" style="margin-top:100px;">
    <p>@2016 永乐票务 yongle.com 京ICP证160733号 京ICP备16022489号-1 京公网安备 11010502030881号 网络文化经营许可证 电子公告服务规则</p>
    <p>北京永乐文化传媒有限公司</p>
</footer>
		<script src="/ttms_ssm/dist/js/bootstrap.min.js"></script>
</body>
</html>