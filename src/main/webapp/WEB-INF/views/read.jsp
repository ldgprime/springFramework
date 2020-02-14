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
<h1>read page</h1>


<br/>

<form action="writeProc" method="POST">
<input type="hidden" id="bno" name="bno" value="${board.bno}" />
<input type="hidden" id="page" name="page" value="${criteria.page}" />
<input type="hidden" id="type" name="type" value="${criteria.type}">
<input type="hidden" id="keyword" name="keyword" value="${criteria.keyword}">
<input type="hidden" id="perPageNum" name="perPageNum" value="${criteria.perPageNum}">
<label>글제목:</label><br/>
<input type="text" name="title" readonly="readonly" value="${board.title }"/><br/>
<label>글내용:</label><br/>
<textarea cols="30" rows="3" name="content" readonly="readonly">${board.content }</textarea><br/>
<label>작성자:</label><br/>
<input type="text" name="writer" readonly="readonly" value="${board.writer }"/><br/>

</form>
<br/><br/>


<%-- <button onclick="location.href='update?bno=${board.bno}&page=${criteria.page}&perPageNum=${criteria.perPageNum }'" type="button">글수정</button>
<button onclick="location.href='delete?bno=${board.bno}'" type="button">글삭제</button>
<button onclick="location.href='list'" type="button">목록</button> --%>


<button id="update">글수정</button>
<button id="delete">글삭제</button>
<button id="list">목록</button>

<script>

	var bno = $('#bno').val();
	var page = $('#page').val();
	var perPageNum = $('#perPageNum').val();
	var type = $('#type').val();
	var keyword = $('#keyword').val();
	
	
	
	$('#list').on('click',function(){
		
		location.href= 'list?page='+page+'&perPageNum='+perPageNum+'&type='+type+'&keyword='+keyword;	
	
	})
	
	$('#update').on('click',function(){
		
		location.href= 'update?page='+page+'&perPageNum='+perPageNum+'&bno='+bno+'&type='+type+'&keyword='+keyword;	
	
	})
	
	$('#delete').on('click',function(){
		
		location.href= 'delete?page='+page+'&perPageNum='+perPageNum+'&bno='+bno+'&type='+type+'&keyword='+keyword;	
	
	})
	
	

</script>





</body>
</html>