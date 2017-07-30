<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>影片管理</title>
    <link rel="stylesheet" type="text/css" href="/ttms_ssm/dist/css/bootstrap.min.css">
    <script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
     <link href="/ttms_ssm/css/footer.css" rel="stylesheet" media="all"/>
    <script src="/ttms_ssm/js/mMovie.js"></script>
    <link rel="stylesheet" href="/ttms_ssm/css/mMovie.css">
    <script type="text/javascript">
    function mess(id){
    	$(".insertModifi").removeClass("hide");
    	//var v = document.getElementById("id").innerHTML;
    	document.getElementById("playId").value = id;
    	console.log(document.getElementById("playId").value);
    }
    function add(){
    	$(".insertAdd").removeClass("hide");
    	//var v = document.getElementById("id").innerHTML;
    	//document.getElementById("playId").value = id;
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
					<li><a href="/ttms_ssm/stdio/list">演出厅管理</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">演出计划 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/ttms_ssm/sche/getScheduleList">演出计划列表</a></li>
							<li><a href="/ttms_ssm/manager/addSchedule.jsp">添加演出计划</a></li>
						</ul>
					</li>
					<li class="dropdown active"  ><a href="#" class="dropdown-toggle"
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
    <table  class="table">
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
						<td style="height:50px;">${play.playId}</td>
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
	<div class="row">
		<div class="col-md-6 insertAdd hide">
			<h3>添加影片</h3>
		</div>
		<div class="col-md-6 insertModifi hide">
			<h3>修改影片</h3>
		</div>
	</div>
	<div class="row">
		<div class="insertAdd hide col-md-6">
	    <form action="/ttms_ssm/play/addPlay" method="post" enctype="multipart/form-data">
	    	<div class="form-group">
	    		<label for="playName">影片名称：</label>
					<input type="text" name="playName" class="form-control">
				<label for="playName">影片类型：</label>
				<select name="playType" class="form-control">
					<option value="科幻片">科幻片</option>
					<option value="惊悚片">惊悚片</option>
					<option value="剧情片">剧情片</option>
					<option value="喜剧片">喜剧片</option>
					<option value="悲剧片">悲剧片</option>
				 </select>
				<label for="playName">影片语言：</label>	  
				<select name="playLanguage" class="form-control">
					<option value="简体中文">简体中文</option>
					<option value="英语">英语</option>
					<option value="韩语">韩语</option>
					<option value="粤语">粤语</option>
					<option value="日语">日语</option>
				 </select>
				<label for="playName">影片描述：</label>	  
				<textarea rows="4" cols="30" name="playDesc" class="form-control"></textarea>
				<label for="playName">影片长度：</label>
				<input type="text" name="playLength" class="form-control">
				<label for="playName">影片导演：</label>
				<input type="text" name="playDirector" class="form-control">
				<label for="playName">影片演员：</label>
				<input type="text" name="playActor" class="form-control">
				<label for="playName">影片票价：</label>
				<input type="text" name="playTicketPrice" class="form-control">
				<label for="playName">影片评分：</label>
				<input type="text" name="playGrade" class="form-control">
				<label for="playName">影片海报：</label>
				<input type="file" name="Image">
				<br>
				<input type="submit" value="添加" class="btn btn-info"><br>
			</div>
		</form>
		</div>
		<div class="insertModifi hide col-md-6">
			<form action="/ttms_ssm/play/updatePlay" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="playName">影片名称：</label>
					<input type="hidden" name="playId" id="playId" class="form-control">
					<input type="text" name="playName" value="${info.playName}" class="form-control">
					<label for="playName">影片类型：</label>
					<select name="playType" class="form-control">
						<option value="科幻片">科幻片</option>
						<option value="惊悚片">惊悚片</option>
						<option value="剧情片">剧情片</option>
						<option value="喜剧片">喜剧片</option>
						<option value="悲剧片">悲剧片</option>
					</select>
					<label for="playName">影片语言：</label>
					<select name="playLanguage" class="form-control">
						<option value="简体中文">简体中文</option>
						<option value="英语">英语</option>
						<option value="韩语">韩语</option>
						<option value="粤语">粤语</option>
						<option value="日语">日语</option>
					</select>
					<label for="playName">影片描述：</label>
					<textarea rows="4" cols="30" name="playDesc" class="form-control">${info.playDesc}</textarea>
					<label for="playName">影片长度：</label>
					<input type="text" name="playLength" value="${info.playLength}" class="form-control">
					<label for="playName">影片导演：</label>
					<input type="text" name="playDirector" value="${info.playDirector}" class="form-control">
					<label for="playName">影片演员：</label>
					<input type="text" name="playActor" value="${info.playActor}" class="form-control">
					<label for="playName">影片票价：</label>
					<input type="text" name="playTicketPrice" value="${info.playTicketPrice}" class="form-control">
					<label for="playName">影片评分：</label>
					<input type="text" name="playGrade" value="${info.playGrade}" class="form-control">
					<label for="playName">影片海报：</label>
					<input type="file" name="Image" value="${info.playImage}" class="form-control">
					<br>
					<input type="submit" value="修改" class="btn btn-info"><br>
				</div>
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