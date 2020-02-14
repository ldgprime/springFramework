<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<h1>update page</h1>


<br/>

<form action="updateProc" method="POST">
<input type="hidden" id="page" name="page" value="${criteria.page}" />
<input type="hidden" id="perPageNum" name="perPageNum" value="${criteria.perPageNum}">
<input type="hidden" id="bno" name="bno" value="${board.bno }" /><br/>
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


<br/><br/>

<button id="list">목록</button>

<script type="text/javascript">

var bno = $('#bno').val();
var page = $('#page').val();
var perPageNum = $('#perPageNum').val();

$('#list').on('click',function(){
		
	location.href= 'list?page='+page+'&perPageNum='+perPageNum;	

})

</script>


</body>
</html>