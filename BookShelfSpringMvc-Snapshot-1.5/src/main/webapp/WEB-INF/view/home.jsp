<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bookshelf-home-page</title>
</head>
<body>
	<h1>Welcome Bookshelf home-page!</h1>
	<hr>
	
	
	<!-- display user name and role -->
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role: <security:authentication property="principal.authorities" /> 
	
	</p>
	
	
	
	<p>Personalize Your bookshelf Stay Read and Share! </p>
	
	<hr>
	
	<security:authorize access="hasRole('MANAGER') ">
		<p>
			<a href="${pageContext.request.contextPath}/leaders" >Leadership meetings</a>
			(this is available only for managers!)
		</p>
		
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN') ">
		<p>
			<a href="${pageContext.request.contextPath}/systems" >Administrator Maintenance</a>
			(this is available only for Administrator!)
		</p>
	</security:authorize>
	
	
	<!-- logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		
		<input type="submit" value="Logout" />
	
	</form:form>

</body>
</html>