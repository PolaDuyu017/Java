<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css">
<c:if test="${errCode==null}">
	<c:set var="errCode" value="\"\""></c:set>
</c:if>
<script type="text/javascript">
	function checkErrCode(){
		var errCode = ${errCode};
		if(errCode!=null || errCode!=""){			
			switch(errCode){
				case 1:
					alert("가입된 이메일 주소가 아닙니다.");
					break;
				case 2:
					alert("비밀번호가 일치하지 않습니다.");
					break;
				case 3:
					alert("회원가입 처리가 완료되었습니다. 로그인 해 주세요.");
					location.href="<%= request.getContextPath() %>/login.do";
					break;
			}
		}
	}
</script>
</head>
<body onload="checkErrCode()">
<div class="wrapper">
<h3>스프링 게시판</h3>
	<spring:hasBindErrors name="LoginModel" />
	<form:errors path="LoginModel" />
	<form action="login.do" method="post">
		<fieldset>
			<label for="userId">메일주소 : </label>
			<input type="text" id="userId" name="userId" class="loginInput" value="${userId}" />
			<span class="error"><font color="red"><form:errors path="LoginModel.userId" /></font></span><br />
			<label for="userPw">비밀번호 : </label>
			<input type="password" id="userPw" name="userPw" class="loginInput"/>
			<span class="error"><font color="red"><form:errors path="LoginModel.userPw" /></font></span><br /><br />
			<center>
			<input type="submit" value="로그인" class="submitBt"/><br /><br />
			<a href="<%=request.getContextPath()%>/member/join.do">회원가입</a>		
		</fieldset>			
	</form>
</div>
</body>
</html>