<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">document.write(new Date())</script>
<H3>WELCOME TO Employee Register PAGE</H3>


<form action="upload" method="post" enctype="multipart/form-data">
<pre>
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
	<input type="submit" value="Register"/>
</pre>
</form>
${ msg }
</body>
</html>