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
<h1>read page</h1>


<br/>

<form action="writeProc" method="POST">
<label>글제목:</label><br/>
<input type="text" name="title" readonly="readonly" value="${board.title }"/><br/>
<label>글내용:</label><br/>
<textarea cols="30" rows="3" name="content" readonly="readonly">${board.content }</textarea><br/>
<label>작성자:</label><br/>
<input type="text" name="writer" readonly="readonly" value="${board.writer }"/><br/>

</form>
<br/><br/><br/><br/><br/>


<button onclick="location.href='update?bno=${board.bno}'" type="button">글수정</button>
<button onclick="location.href='delete?bno=${board.bno}'" type="button">글삭제</button>
<button onclick="location.href='list'" type="button">목록</button>



</body>
</html>