<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
    </head>
    <body>
        <form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">
        
			<table>
			    <tr>
			        <td><form:label path="username">Usuario:</form:label></td>
			        <td><form:input id="username" name="username" path="username" /></td>
			    </tr>
			    <tr>
            		<td><form:label path="username">Please enter your password</form:label></td>
            		<td><form:password id="password" name="password" path="password" /></td>
			    </tr>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Log in" />
			        </td>
			    </tr>
			</table> 
        </form:form>
    </body>
</html>