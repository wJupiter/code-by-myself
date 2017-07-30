<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>演出厅管理</title>
    <link rel="stylesheet" type="text/css" href="/ttms_ssm/dist/css/bootstrap.min.css">
     <link href="/ttms_ssm/css/footer.css" rel="stylesheet" media="all"/>
    <script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
    
    <link rel="stylesheet" href="/ttms_ssm/css/mIndex.css">
    
    <script>
    function mess(id){
    	$(".insert").removeClass("hide");
    	$(".title").removeClass("hide");
    	//var v = document.getElementById("id").innerHTML;
    	document.getElementById("stdioId").value = id;
    	console.log(document.getElementById("stdioId").value);
    }
    function add(){
    	$(".insertAdd").removeClass("hide");
    	//var v = document.getElementById("id").innerHTML;
    	//document.getElementById("stdioId").value = id;
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
					<li class="active"><a href="/ttms_ssm/stdio/list">演出厅管理</a></li>
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

<div class="container context">
          
	<c:if test="${not empty stdList}">
        <table  class="table table-hover" id="table">
			<thead>
				<tr>
					<th>影厅编号</th>
					<th>影厅名称</th>
					<th>座位行数</th>
					<th>座位列数</th>
					<th>影厅类型</th>
					<th>影厅介绍</th>
					<th>操作</th>
					<th><button class="btn btn-info" onclick="add()">添加</button></th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${stdList}" var="std">
						<tr>
							<td style="height:50px;">${std.stdioId}</td>
							<td>${std.stdioName}</td>
							<td>${std.stdioRows}</td>
							<td>${std.stdioCols}</td>
							<td>${std.stdioType}</td>
							<td>${std.stdioDesc}</td>
							<td><a href="#" onclick="mess(${std.stdioId})">修改</a></td>
							<td><a href="${pageContext.request.contextPath}/stdio/deleteStdio/${std.stdioId}">删除</a></td>
						</tr>
					</c:forEach>				
			</tbody>
		</table>
	</c:if>
	
	<div class="row">
	<div class="col-md-6 insertAdd hide"><h3>添加演出厅</h3></div>
	<div class="col-md-6 hide title"><h3>修改演出厅</h3></div>
	</div>
	<div class="row">
	<div class="insertAdd hide col-md-6">
	<form action="/ttms_ssm/stdio/add" method="post" class="form-group">
	<label for="name">演出厅名称</label>
	<input type="text" name="stdioName" id="name" class="form-control"> 	
	<label for="rows">演出厅行号</label>
	<input type="text" name="stdioRows" id="rows"  class="form-control">
	<label for="cols">演出厅列号</label>
	<input type="text" name="stdioCols" id="cols"  class="form-control">
	<label for="type">演出厅类型</label>
	<select id="stdioType" name="stdioType" id="type"  class="form-control">
					<option value="0">请选择演出厅类型</option>
					<option value="1">3D影厅</option>
					<option value="2">2D影厅</option>
					<option value="3">普通影厅</option>
				</select>
    <label for="desc">演出厅描述：</label>
    <textarea rows="3" cols="20" name="stdioDesc" id="desc"  class="form-control"></textarea><br>
		<input type="submit" value="添加" class="btn btn-info">
	</form>
	</div>
	
	<div class="insert hide col-md-6">
	<form action="/ttms_ssm/stdio/update" method="post" class="form-group">
	<!-- <label  for="stdioId">演出厅编号</label> -->
	<input type="hidden" name="stdioId" id="stdioId" readonly="readonly" class="form-control">
	<label for="stdioName">演出厅名称</label>
	<input type="text" name="stdioName" id="stdioName" class="form-control">
	<label for="stdioRows">演出厅行数</label>
	<input type="text" name="stdioRows" id="stdioRows" class="form-control">
	<label for="stdioCols">	演出厅列数</label>
	<input type="text" name="stdioCols" id="stdioCols" class="form-control">
	<label for="stdioType">演出厅类型</label>
	<select id="stdioType" name="stdioType" id="stdioType" class="form-control">
					<option value="0">请选择演出厅类型</option>
					<option value="1">3D影厅</option>
					<option value="2">2D影厅</option>
						<option value="3">普通影厅</option>
	</select>
	<label for="stdioDesc">演出厅描述</label>
	<textarea rows="3" cols="20" name="stdioDesc" id="stdioDesc" class="form-control"></textarea><br>
		<input type="submit" value="修改" class="btn btn-info">
	</form>
	</div>
	</div>
</div>
<footer class="footer hide">
    <p>@2016 永乐票务 yongle.com 京ICP证160733号 京ICP备16022489号-1 京公网安备 11010502030881号 网络文化经营许可证 电子公告服务规则</p>
    <p>北京永乐文化传媒有限公司</p>
</footer>
	<script src="/ttms_ssm/dist/js/bootstrap.min.js"></script>
</body>
</html>