<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div class="container" style="margin-top:80px">

<h1>커뮤니티</h1>
<p>회원들과 자유롭게 소통할 수 있는 커뮤니티 게시판입니다.</p>

<div class="input-group mb-3">					
  <input type="text" class="form-control" placeholder="Search" aria-label="Search Challenge" aria-describedby="button-addon2">
  <button class="button primary mr-2" type="button" id="button-addon2">검색</button>
  <div class="form-group text-right">
		<button type="button" class="button button-secondary" id="writeBtn">글쓰기</button>
	</div>
</div>

<h3>게시글 수 : (${count })</h3>
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

<%@ include file="../includes/footer.jsp" %>