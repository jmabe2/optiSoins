<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First JSP!</title>
</head>
<body>
	<header>
	<h1>First JSP</h1>
	</header>
	<FORM action="MyServlet" method="post">
		Name :<INPUT type="text" name="name" size="20"><BR>
		Id :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT type="text" name="ID" size="20"><BR>
		<BR><INPUT type="submit" name="Submit" value="Submit informations">
	</FORM>
</body>
</html>