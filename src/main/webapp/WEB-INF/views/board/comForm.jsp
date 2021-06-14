<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div class="container" style="margin-top:80px">

<h1>커뮤니티</h1>
<p>게시글 입력하기</p>

<form>
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" placeholder="Enter title" id="title">
		</div>
		
		<div class="form-group">
			<label for="content">Content</label>
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>

	</form>
	<button id="btn-save" class="btn btn-primary btn-sm">글쓰기 완료</button>

</div>

<script>
  $('.summernote').summernote({
    tabsize: 2,
    height: 300
  });
</script>
<script src="/js/board.js"></script>

<%@ include file="../includes/footer.jsp" %>