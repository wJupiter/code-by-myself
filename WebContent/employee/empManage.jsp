<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
</head>
<body>
	<table>
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
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty empList}">
				<c:forEach items="${empList}" var="emp">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.empNo}</td>
						<td>${emp.empName}</td>
						<td>${emp.empPosition}</td>
						<td>${emp.sex}</td>
						<td>${emp.dob}</td>
						<td>${emp.age}</td>
						<td>${emp.empTel}</td>
						<td>${emp.empEmail}</td>
						<td>${emp.empAddress}</td>
						<td><img src="${pageContext.request.contextPath}${emp.empPhoto}" alt="头像" width="20" height="20"/></td>
						<td><a href="${pageContext.request.contextPath}/emp/getInfoById/${emp.empId}">修改</a></td>
						<td><a href="${pageContext.request.contextPath}/emp/deleteEmp/${emp.empId}">删除</a></td>
					</tr>
				</c:forEach>				
			</c:if>
		</tbody>
	</table>
</body>
</html>