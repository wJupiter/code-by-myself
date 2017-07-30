<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>演出计划</title>
<link href="/ttms_ssm/css/footer.css" rel="stylesheet" media="all"/>
<link rel="stylesheet" type="text/css" href="/ttms_ssm/dist/css/bootstrap.min.css">
<script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/ttms_ssm/css/mPlan.css">
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
					<li><a href="/ttms_ssm/stdio/list">演出厅管理</a></li>
					<li class="dropdown active"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">演出计划 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/ttms_ssm/sche/getScheduleList">演出计划列表</a></li>
							<li><a href="/ttms_ssm/manager/addSchedule.jsp">添加演出计划</a></li>
						</ul>
					</li>
					<li class="dropdown"  ><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">影片管理 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/ttms_ssm/play/playList">影片列表</a></li>
							<li><a href="/ttms_ssm/manager/addPlay.jsp">添加影片</a></li>
							<li><a href="#">分页检索</a></li>
						</ul>
					</li>
					<li> <a href="/ttms_ssm/emp/list">人员管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/ttms_ssm/emp/getInfoById/${sessionScope.empId}">个人中心</a></li>
					<li><a href="#">关于</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container-fluid context">
		<table class="table"> 
			<thead>
				<tr>
					<th>演出计划编号</th>
					<th>演出厅</th>
					<th>电影名</th>
					<th>电影海报</th>
					<th>演出开始时间</th>
					<th>演出结束时间</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<c:if test="${not empty scheList}">
				<tbody>
					<c:forEach items="${scheList}" var="sched">
						<tr>
							<td align="center">${sched.scheId}</td>
							<td align="center">${sched.stdioInfo.stdioName}</td>
							<td align="center">${sched.playInfo.playName}</td>
							<td align="center"><img
								src="${pageContext.request.contextPath}${sched.playInfo.playImage}"
								height="35" width="35"></td>
							<td align="center">${sched.scheStartTime}</td>
							<td align="center">${sched.scheEndTime}</td>
							<td align="center"><a
								href="/ttms_ssm/manager/editSchedule.jsp?scheId=${sched.scheId}">修改</a></td>
							<td align="center"><a
								href="/ttms_ssm/sche/deleteSchedule/${sched.scheId}">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
		</table>

		<%-- <div class="add">
			<h3 class="center">添加演出计划</h3>
			<form class="form-horizontal" action="/ttms_ssm/sche/addSche"
				method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">演出厅</label>
					<div class="col-sm-6">
						<select name="stdioId" id="stdioId" class="form-control"></select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">演出开始时间</label>
					<div class="col-sm-6">
						<select name="startTime" class="form-control">
							<option value="1">8:00</option>
							<option value="2">10:30</option>
							<option value="3">13:00</option>
							<option value="4">15:30</option>
							<option value="5">18:00</option>
							<option value="6">20:30</option>
						</select>
					</div>
				</div>
				<div class="form-group" style="margin-left: 150px;">

					<div id="playList"></div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">添加</button>
					</div>
				</div>
				${msg} <a href="/ttms_ssm/sche/getScheduleList">演出计划表</a>
			</form>
		</div>
		<div class="modif">

			<form action="/ttms_ssm/sche/updateSche" method="post"
				class="form-horizontal">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">演出计划编号</label>
					<div class="col-sm-6">
						<input type="text" name="scheId" readonly="readonly"
							value="${param.scheId}">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">演出厅</label>
					<div class="col-sm-6">
						<select name="stdioId" id="stdioId"></select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">演出开始的时间</label>
					<div class="col-sm-6">
						<select name="startTime">
							<option value="1">8:00</option>
							<option value="2">10:30</option>
							<option value="3">13:00</option>
							<option value="4">15:30</option>
							<option value="5">18:00</option>
							<option value="6">20:30</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"></label>
					<div class="col-sm-6">
						<div id="playList"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">修改</button>
					</div>
				</div>
			</form>
			${msg} <a href="/ttms_ssm/sche/getScheduleList">演出计划表</a>
		</div>
		 --%>
	</div>
	<footer class="footer">
    <p>@2016 永乐票务 yongle.com 京ICP证160733号 京ICP备16022489号-1 京公网安备 11010502030881号 网络文化经营许可证 电子公告服务规则</p>
    <p>北京永乐文化传媒有限公司</p>
</footer>
	<script src="/ttms_ssm/dist/js/bootstrap.min.js"></script>

</body>
</html>