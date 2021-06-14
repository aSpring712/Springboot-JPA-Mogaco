<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div class="container" style="margin-top:80px">

<h1>공지사항</h1>
<p>주요 공지사항과 각종 이벤트 게시글을 확인하세요.</p>

<div class="input-group mb-3">					
  <input type="text" class="form-control" placeholder="Search" aria-label="Search Notice" aria-describedby="button-addon2">
  <button class="button primary mr-2" type="button" id="button-addon2">검색</button>
</div>

<h3>공지글 수 : (${count })</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists.content }" var="board" varStatus="st">
				<tr>
					<td> ${board.num }</td>
					<td><a href="view/${board.num }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd" /></td>
					<td>${board.hitcount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination pagination-sm">
		<c:choose>
			  <c:when test="${lists.first }"></c:when>
			  <c:otherwise>
			     <li class="page-item">
			     <a class ="page-link" href="?page=${lists.number-1 }">이전</a>
			     </li>
			  </c:otherwise>
		</c:choose>
		<c:choose>
			 <c:when test="${lists.last}"></c:when>
			  <c:otherwise>
			      <li class="page-item">
			      <a class ="page-link" href="?page=${lists.number+1 }">다음</a></li>
			  </c:otherwise>
		</c:choose>
	
	
	</ul>
</div>
<script>
$("#writeBtn").click(function(){
	location.href="/board/insertForm";
})
</script>

</div>

<%@ include file="../includes/footer.jsp" %>