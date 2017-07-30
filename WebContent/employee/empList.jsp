<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页检索</title>
</head>
<body>
	<form action="/ttms_ssm/emp/search" method="post">
		员工姓名：<input type="text" name="name"><br>
		员工职位：<input type="text" name="position">
		<input type="submit" value="查询">
	</form>
	<c:if test="${not empty empList}">
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
				</tr>
			</thead>
			<tbody >
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
						</tr>
					</c:forEach>
					<tr> 
						<td colspan = 10>
						当前页:${current}	总页数: ${pageCount} 
						<a href="/ttms_ssm/emp/search">首页</a>
						<c:if test="${current == 1}">上一页</c:if><c:if test="${current > 1}"><a href="/ttms_ssm/emp/search?current=${current}&dir=pre">上一页</a></c:if>
						<c:if test="${current == pageCount}">下一页</c:if><c:if test="${current < pageCount}"><a href="/ttms_ssm/emp/search?current=${current}&dir=next">下一页</a></c:if>
						<a href="/ttms_ssm/emp/search?current=${pageCount}">尾页</a>
						<td>
					</tr>				
			</tbody>
		</table>
	</c:if>
	<%-- 当前页:${current}	总页数: ${pageCount} 
	<a href="/ttms_ssm/emp/search?current=${1}">首页</a>
	<c:if test="${current == 1}">上一页</c:if><c:if test="${current > 1}"><a href="/ttms_ssm/emp/search?current=${current}&dir=pre">上一页</a></c:if>
	<c:if test="${current == pageCount}">下一页</c:if><c:if test="${current < pageCount}"><a href="/ttms_ssm/emp/search?current=${current}&dir=next">下一页</a></c:if>
	<a href="/ttms_ssm/emp/search?current=${pageCount}">尾页</a> --%>
	
</body>
</html>