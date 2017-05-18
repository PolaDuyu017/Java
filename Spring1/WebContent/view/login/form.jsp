<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form:form commandName="loginCommand">
<form:errors element="div"/>
	아이디: <form:input path="userId"/>
	<form:errors path="userId"/>	
	<br/>
	암호: <form:input path="password" showPassword="false"/>
	<form:errors path="password"/>
	<br/>
	<input type="submit" value="로그인">
</form:form>
</body>
</html>