<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

	<h1>List page</h1>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="board" items="${list }">
				<tr>
					<td>${board.bno }</td>
					<td><a class="read" href="${board.bno }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdate }" /></td>
					<td>${board.readcount }</td>
				</tr>
			</c:forEach>
		</tbody>

		<tr>
			<td id="pagenate" colspan="5" align="center">
				<c:choose>
					<c:when test="${pageMaker.prev }">
						<a href="${pageMaker.startPage-1 }">이전</a>
					</c:when>
					<c:otherwise>
 						 이전
					</c:otherwise>
				</c:choose> 
				<c:forEach begin="${pageMaker.startPage }" end="${ pageMaker.endPage}" var="i">
					<c:choose>
						<c:when test="${pageMaker.criteria.page == i }">
							${i }
						</c:when>
						<c:otherwise>
							<a href="${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:choose>
					<c:when test="${pageMaker.next }">
						<a href="${pageMaker.endPage+1 }">다음</a>
					</c:when>
					<c:otherwise>
  						다음
					</c:otherwise>
				</c:choose></td>
		</tr>

	</table>




	<br />
	<br />

	<button onclick="location.href='write'" type="button">글쓰기</button>
	
	
	
	<form id="jobForm">
		<input type="hidden" name="page" value="${pageMaker.criteria.page}" />
		<input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">
	</form>

<script>
	var jobForm=$("#jobForm")
	
	$('#pagenate a').on("click",function(event){
		event.preventDefault();
		
		var targetPage=$(this).attr("href");		
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action","/dbs/list").attr("method","get");
		jobForm.submit();		
		
	})

	$(".read").on("click",function(event){
		event.preventDefault();
		
		var bno = $(this).attr("href");	
		var page = jobForm.find("[name='page']").val();
		var perpageNum= jobForm.find("[name='perPageNum']").val();
		
		jobForm.append("<input type='hidden' name = 'bno' value='"+bno+"'/>")
		jobForm.attr("action","/dbs/read").attr("method","get");
		jobForm.submit();
	})

</script>

</body>
</html>