<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
게시글 쓰기 입력 폼:
<form method="post">
	<input type="hidden" name="parentId" value="0"/>
	제목 : <input type="text" name="title"/><br/>
	내용 : <textarea name="content"></textarea><br/>
	<input type="submit"/>
</form>
</body>
</html>