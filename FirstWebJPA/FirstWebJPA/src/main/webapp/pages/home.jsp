<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome</h1>
	<form action="add">
	<label>Id</label><br /><input type="text" name="id"><br>
	<label>Name</label><br /><input type="text" name="name"><br>	
	<input type="Submit">
	</form>
	
	<form action="fetch">
	<label>Id</label><br /><input type="text" name="id"><br>
	<input type="Submit">
	</form>
	
	
	<form action="delete">
	<label>Id</label><br /><input type="text" name="id"><br>
	<input type="Submit">
	</form>
</body>
</html>