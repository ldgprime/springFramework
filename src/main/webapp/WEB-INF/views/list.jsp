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
					<td><a class="read" href="${board.bno }">${board.title }(${ board.replecount})</a></td>
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
	
	<form id="searchForm" action="/dbs/list" method="get">
		<select name='type'>
			<option value=""
				<c:out value="${pageMaker.criteria.type == null ? 'selected' : '' }"/>>--</option>
			<option value="T"
				<c:out value="${pageMaker.criteria.type == 'T' ? 'selected' : '' }"/>>제목</option>
			<option value="C"
				<c:out value="${pageMaker.criteria.type == 'C' ? 'selected' : '' }"/>>내용</option>
			<option value="W"
				<c:out value="${pageMaker.criteria.type == 'W' ? 'selected' : '' }"/>>작성자</option>	
			<option value="TC"
				<c:out value="${pageMaker.criteria.type == 'TC' ? 'selected' : '' }"/>>제목 +내용</option>				
			<option value="TW"
				<c:out value="${pageMaker.criteria.type == 'TW' ? 'selected' : '' }"/>>제목+작성자</option>
			<option value="TCW"
				<c:out value="${pageMaker.criteria.type == 'TCW' ? 'selected' : '' }"/>>제목+내용+작성자</option>	
		</select>
		<input type="search" name="keyword" value="${pageMaker.criteria.keyword }"/>
		<input type="hidden" name="page" value="${pageMaker.criteria.page }"/>
		<input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum }"/>
		<button type="submit">검색</button>	
	</form>
	
	<form id="jobForm">
		<input type="hidden" name="page" value="${pageMaker.criteria.page}" />
		<input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">
		<input type="hidden" name="type" value="${pageMaker.criteria.type}">
		<input type="hidden" name="keyword" value="${pageMaker.criteria.keyword}">
	</form>

<script>
	var jobForm = $('#jobForm')
	var searchForm = $('#searchForm')
	
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
	
	$('#searchForm button').on('click',function(event){
		event.preventDefault();
		
		
 		if(!searchForm.find("option:selected").val()){
			alert("검색종류를 선택하세요");
			return false;
		} 
		

		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 선택하세요");
			return false;
		}
		 
		searchForm.find("input[name='page']").val(1);
		searchForm.submit();		
		
	})

</script>

</body>
</html>