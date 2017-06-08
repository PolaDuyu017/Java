<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.*, com.DH.spring4.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>main</title>
</head
>
<body>
<form  method="post" action="insert">
	<table border="1">
		<tr>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td></td>
		</tr>

		<tr>
			<td><input type="text" name="name" id="name"></td>
			<td><input type="text" name="email" id="email"></td>
			<td><input type="text" name="phone" id="phone"></td>
			<td colspan="2" align="center">
			<input type="submit" value="추가">
			</td>

		</tr>
		<c:forEach items="${result}" var="member">
			<tr>
				<td>${member._name}</td>
				<td>${member._email}</td>
				<td>${member._phone}</td>
				<td><input type="button" value="수정" onclick=""> <input
					type="button" value="삭제"></td>
			</tr>
		</c:forEach>
	</table>

</form>
</body>
</html>