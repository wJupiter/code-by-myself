<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/ttms_ssm/dist/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/ttms_ssm/css/personal.css" rel="stylesheet" media="all"/>
    <link href="/ttms_ssm/css/footer.css" rel="stylesheet" media="all"/>
    <script type="text/javascript" src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
    <script src="/ttms_ssm/js/personal.js"></script>
</head>
<body>
<div class="header-top">
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
						<ul class="dropdown-menu" role="menu"  style="background-color:black;">
							<li><a href="/ttms_ssm/sche/getScheduleList">演出计划列表</a></li>
							<li><a href="/ttms_ssm/manager/addSchedule.jsp">添加演出计划</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">影片管理 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu"  style="background-color:black;">
							<li><a href="/ttms_ssm/play/playList">影片列表</a></li>
							<li><a href="/ttms_ssm/manager/addPlay.jsp">添加影片</a></li>
							<li><a href="#">分页检索</a></li>
						</ul>
					</li>
					<li> <a href="/ttms_ssm/emp/list">人员管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="/ttms_ssm/emp/getInfoById/${sessionScope.empId}">个人中心</a></li>
					<li><a href="#">关于</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
</div>
<div class="header">
    <div class="container">
        <div class="col-md-8 header-left">
            <div class="col-sm-5 pro-pic">
                <img class="img-responsive" src="${pageContext.request.contextPath}${empInfo.empPhoto}" alt=" "/>
            </div>
            <div class="col-sm-5 pro-text">
                <h1>${empInfo.empName}</h1>
                <p>${empInfo.empPosition}</p>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="col-md-4 header-right ">
            <ul class="list-left">
                <li>电话:</li>
                <li>邮箱:</li>
                <li>性别：</li>
                <li>地址:</li>
            </ul>
            <ul class="list-right">
                <li>${empInfo.empTel}</li>
                <li><a href="mailto:info@example.com">${empInfo.empEmail}</a></li>
                <li>${empInfo.sex}</li>
                <li>${empInfo.empAddress}</li>
            </ul>
            <div class="clearfix">
                <button class="btn btn-info btn-sm display" onclick="output()">编辑资料</button>
            </div>
        </div>
    </div>
</div>
<div id="about" class="about">
    <div class="container form hide">
        <form action="/ttms_ssm/emp/updateMgrEmp" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="empId" value="${sessionScope.empId}">
            <div class="form-group">
                <label for="exampleInputEmail1">邮箱</label>
                <input type="text" name="empEmail" class="form-control" id="exampleInputEmail1" placeholder="Email">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">地址</label>
                <input type="text" name="empAddress" class="form-control" id="exampleInputPassword1" placeholder="Address">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">电话</label>
                <input type="text" name="empTel" class="form-control" id="exampleInputTel" placeholder="TelNumber">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">上传头像</label>
                <input type="file" name="photo" id="exampleInputFile" >
            </div>
            <button type="submit" class="btn btn-info" onclick="output()">提交</button>
        </form>
        ${msg}
        <hr>
    </div>
    <div class="container">
        <h3 class="tittle">关于我</h3>
        <p class="abt-para">Sed ut perspiciatis unde omnis iste natus error sit
            voluptatem accusantium doloremque laudantium, totam
            rem aperiam, eaque ipsa quae ab illo inventore veritatis
            et quasi architecto beatae vitae dicta sunt explicabo.
            Nemo enim ipsam voluptatem quia voluptas sit aspernatur . </p>
    </div>

</div>
<footer class="footer">
    <p>@2016 永乐票务 yongle.com 京ICP证160733号 京ICP备16022489号-1 京公网安备 11010502030881号 网络文化经营许可证 电子公告服务规则</p>
    <p>北京永乐文化传媒有限公司</p>
</footer>
<script src="/ttms_ssm/dist/js/bootstrap.min.js"></script>
</body>
</html>