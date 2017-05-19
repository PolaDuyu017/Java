<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String servletPath = request.getRequestURI(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>테스트 코드</title>
</head>
<body>
<form:form action="/Spring2/jsp/article/${article.id}" commandName="article" method="delete">
<input type="submit" value="삭제">
</form:form>
<form:form action="/Spring2/jsp/article/${article.id}" commandName="article" method="put">
<input type="submit" value="수정">
</form:form>
<form:form action="/Spring2/jsp/article/${article.id}" commandName="article" method="get">
<input type="submit" value="읽기">
</form:form>
<form:form action="/Spring2/jsp/article" commandName="article" method="post">
<input type="submit" value="생성">
<br/>
${article.id}
</form:form>
</body>
</html>