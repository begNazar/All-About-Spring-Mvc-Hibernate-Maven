<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
	.error{
		color: red;
	}

</style>

<title>user - login</title>
</head>
<body>
	<h3>Custom login - page.</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<c:if test="${param.error != null }">
			<i class="error">Sorry! your entered invalid username or password.</i>
		</c:if>

		<table>
			<tr>
				<td>
					<p>
						User name: <input type="text" name="username" />
					</p>
				</td>
			</tr>

			<tr>
				<td>
					<p>
						Password: <input type="password" name="password" />
					</p>
				</td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>

