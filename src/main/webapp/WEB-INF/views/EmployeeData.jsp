<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty list}">
			<table border="1">
				<tr>
					<th>Employee Name</th>
					<th>Email</th>
					<th>Mobile Number</th>
					
					<th>Address1</th>
					<th>Address2</th>
					<th>Address3</th>
					<th>IDType</th>
					<th>IDNUMBER</th>
					<th>FileName</th>
					<th>Image</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.empName}</td>
						<td>${ob.email}</td>
						<td>${ob.empMbl}</td>
						
						<td>${ob.addr1}</td>
						<td>${ob.addr2}</td>
						<td>${ob.addr3}</td>
						<td>${ob.idtype}</td>
						
						<td>${ob.idnum}</td>
	                    <td>${ob.fileName}</td>
	                    <td><img width="100" height="100" src="getEmployeePhoto/<c:out value='${ob.id }'/>" ></td>
	                    <td><a href="delete?id=${ob.id}">delete</a></td>
	                  	<td><a href="edit?id=${ob.id}"> 
									<!-- <img	src="../resources/images/edit.png" width="20" height="20" /> -->
									EDIT
									</a></td>
					</tr>

				</c:forEach>
			</table>

		</c:when>
		<c:otherwise>
		<h4>NO Data Found!</h4>
		</c:otherwise>
	   </c:choose>
		</body>
		</html>
		