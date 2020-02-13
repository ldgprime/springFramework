<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>update page</h1>


<br/>

<form action="updateProc" method="POST">
<input type="hidden" name="bno" value="${board.bno }" /><br/>
<label>글제목:</label><br/>
<input type="text" name="title" value="${board.title }" /><br/>
<label>글내용:</label><br/>
<textarea cols="30" rows="3" name="content">${board.content }</textarea><br/>
<label>작성자:</label><br/>
<input type="text" name="writer" value="${board.writer }"/><br/>
<br/>
<button type="submit">글수정</button>
<button type="reset">초기화</button>
</form>


<br/><br/><br/><br/><br/>

<a href="list" type="button">목록</a>

</body>
</html>