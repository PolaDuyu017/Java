<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>리포트 제출</title>
</head>
<body>
<h3>@RequestParam 사용</h3>
<form action="submitReport1.do" method="post" enctype="multipart/form-data">
	학번: <input type="text" name="studentNumber"/>
	<br/>
	리포트파일: <input type="file" name="report"/>
	<br/>
	<input type="submit" value="upload"/>
</form>

<h3>MultipartHttpServletRequest 사용</h3>
<form action="submitReport2.do" method="post" enctype="multipart/form-data">
	학번: <input type="text" name="studentNumber"/>
	<br/>
	리포트파일: <input type="file" name="report"/>
	<br/>
	<input type="submit" value="upload"/>
</form>

<h3>커맨드 객체 사용</h3>
<form action="submitReport3.do" method="post" enctype="multipart/form-data">
	학번: <input type="text" name="studentNumber"/>
	<br/>
	리포트파일: <input type="file" name="report"/>
	<br/>
	<input type="submit" value="upload"/>
</form>
</body>
</html>