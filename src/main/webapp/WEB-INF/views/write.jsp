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
<h1>write page</h1>


<br/>

<form action="writeProc" method="POST">
<label>글제목:</label><br/>
<input type="text" name="title"/><br/>
<label>글내용:</label><br/>
<textarea cols="30" rows="3" name="content"></textarea><br/>
<label>작성자:</label><br/>
<input type="text" name="writer"/><br/>
<br/>
<button type="submit">글작성</button>
<button type="reset">초기화</button>
</form>


<br/><br/><br/><br/><br/>

<button onclick="location.href='list'" type="button">목록</button>




</body>
</html>