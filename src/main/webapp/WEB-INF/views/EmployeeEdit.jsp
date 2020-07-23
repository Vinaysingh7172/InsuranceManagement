<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Employee Edit Page</h2>
<form action="update" method="post" modelAttribute="employee">
<pre>
Employee Id:
<input type="text" name="id" readonly="true"/>
Employee Name:
<input type="text" name="empName"/>
EMAIL:
<input type="text" name="email"/>
MOBILES:
<input type="text" name="empMbl"/>
ROLES:
<input type=checkbox name="roles" value="ADMIN"/>ADMIN
<input type="checkbox" name="roles" value="Employee"/>Employee
Address#1:
<input type="text" name="addr1"/>
Address#2:
<input type="text" name="addr2"/>
Address#3:
<input type="text" name="addr3"/>
ID Type:
<select name="idtype">
<option value="AADHAR">AADHAR</option>
<option value="VOTERID">VOTERID</option>
<option value="DRIVINGLICENSE">DRIVINGLICENSE</option>
<option value="PANCARD">PANCARD</option>
<option value="PASSPORT">PASSPORT</option>
</select>
ID NUMBER:
<input type="text" name="idnum">
DOCUMENT:
<input type="file" name="fileOb"/>
	<input type="submit" value="Update"/>
</pre>
</form>
</body>
</html>