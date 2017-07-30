<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>售票管理</title>
</head>
<body>
		<table>
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
</body>
</html>