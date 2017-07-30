<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>演出计划列表</title>
</head>
<body>
		<table>
			<thead >
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
							<td align="center"><img src="${pageContext.request.contextPath}${sched.playInfo.playImage}" height="35" width="35"></td>
							<td align="center">${sched.scheStartTime}</td>
							<td align="center">${sched.scheEndTime}</td>
							<td align="center"><a href="/ttms_ssm/schedule/editSchedule.jsp?scheId=${sched.scheId}">修改</a></td>
							<td align="center"><a href="/ttms_ssm/sche/deleteSchedule/${sched.scheId}">删除</a></td>
						</tr>
					</c:forEach>			
				</tbody>
			</c:if>
		</table>
</body>
</html>