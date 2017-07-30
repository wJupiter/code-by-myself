<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>售票管理</title>

    <link href="/ttms_ssm/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="/ttms_ssm/dist/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/ttms_ssm/css/ticket.css" rel="stylesheet">
    <link href="/ttms_ssm/css/footer.css" rel="stylesheet">

</head>

<body role="document" data-spy="scroll">

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top navbar-static " id="navbar-example" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">永乐票务</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#menu1">正在上映 </a></li>
                <li><a href="#menu2">即将上映</a></li>
                <li><a href="#menu3">今日票房</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/ttms_ssm/emp/getSaleInfoById/${sessionScope.empId}">个人中心</a></li>
                <li><a href="/ttms_ssm/about.jsp">关于</a></li>
                <li><a href="javascript:void(0);" onclick="message()">帮助</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container theme-showcase" data-target="#navbar-example" role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <h1>Hello, Thursday</h1>
        <p>Sometimes one day looks like life, sometimes cry like a short day. World no two the same day, but every day for the start（有时候一天长得像一生，有时候一生短得像一天。世界上没有两个相同的一天，但每一天都适合开始）by周一周二</p>
        <p><a href="#" class="btn btn-primary btn-lg" role="button">See more &raquo;</a></p>
    </div>

   <div>
   <table  class="table table-hover">
			<thead>
				<tr>
					<th>演出计划编号</th>
					<th>演出厅编号</th>
					<th>演出厅</th>
					<th>电影编号</th>
					<th>电影名</th>
					<th>电影海报</th>
					<th>演出开始时间</th>
					<th>演出结束时间</th>
					<th>售票</th>				
				</tr>
			</thead>
				<c:if test="${not empty scheList}">
						<tbody>
							<c:forEach items="${scheList}" var="sched">
								<tr>
									<td align="center">${sched.scheId}</td>
									<td align="center">${sched.stdioInfo.stdioId}</td>
									<td align="center">${sched.stdioInfo.stdioName}</td>
									<td align="center">${sched.playInfo.playId}</td>
									<td align="center">${sched.playInfo.playName}</td>
									<td align="center"><img src="${pageContext.request.contextPath}${sched.playInfo.playImage}" height="200" width="180"></td>
									<td align="center">${sched.scheStartTime}</td>
									<td align="center">${sched.scheEndTime}</td>
									<td align="center"><a href="/ttms_ssm/sche/getScheduleById/${sched.scheId}">售票</a></td>
								</tr>
							</c:forEach>			
						</tbody>
				</c:if>
		</table>
		</div>
        <div class="row">

            <div class="col-lg-6">
                <h2 id="menu3" class="text-danger">今日票房</h2>
                <div class="row">
                <div class="col-lg-1 text-error">1.</div>
                <div class="col-lg-4">神奇女侠</div>
                <div class="col-lg-2">463.1万</div>
                </div>
                <div class="row">
                <div class="col-lg-1">2.</div>
                <div class="col-lg-4">加勒比海盗5：死无对证</div>
                <div class="col-lg-2">463.1万</div>
                </div>
                 <div class="row">
                <div class="col-lg-1">3.</div>
                <div class="col-lg-4">新木乃伊</div>
                <div class="col-lg-2">463.1万</div>
                </div>
                 <div class="row">
                <div class="col-lg-1">4.</div>
                <div class="col-lg-4">摔跤吧！爸爸</div>
                <div class="col-lg-2">463.1万</div>
                </div>
                 <div class="row">
                <div class="col-lg-1">5.</div>
                <div class="col-lg-4">哆啦A梦：大雄的南极冰冰凉大冒险</div>
                <div class="col-lg-2">463.1万</div>
                </div>
                 <div class="row">
                <div class="col-lg-1">6.</div>
                <div class="col-lg-4">美好的意外</div>
                <div class="col-lg-2">463.1万</div>
                </div>
                
               
            </div>
            <div class="col-lg-6">
                <h2 id="menu4" class="text-danger">今日热议</h2>
                <ul>
                    <li>《新木乃伊》再曝特辑，木乃伊公主空降惊吓路人</li><br>
                    <li>《青禾男高》曝青禾牌局版海报，景甜变身“麻将鲜师”</li><br>
                    <li>《赢天下》“金丝山纹”版群像海报曝光 范冰冰携众星亮相</li><br>
                    <li>《战狼2》曝非洲战场版海报，吴京从“天上”打到“水下”</li><br>
                    <li>《绝世高手》连曝10张“脑洞大开”海报，神奇想象力获赞</li><br>
                    <li>《新木乃伊》再曝特辑，木乃伊公主空降惊吓路人</li><br>
                    <li>《青禾男高》曝青禾牌局版海报，景甜变身“麻将鲜师”</li><br>
                    <li>《赢天下》“金丝山纹”版群像海报曝光 范冰冰携众星亮相</li><br>
                    <li>《战狼2》曝非洲战场版海报，吴京从“天上”打到“水下”</li><br>
                    <li>《绝世高手》连曝10张“脑洞大开”海报，神奇想象力获赞</li><br>
                </ul>
            </div>
        </div>
    </div> <!-- /container -->

<footer class="footer">
    <p>@2016 永乐票务 yongle.com 京ICP证160733号 京ICP备16022489号-1 京公网安备 11010502030881号 网络文化经营许可证 电子公告服务规则</p>
    <p>北京永乐文化传媒有限公司</p>
</footer>
<script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
<script src="/ttms_ssm/dist/js/bootstrap.min.js"></script>
<script src="/ttms_ssm/dist/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>