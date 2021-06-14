<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div class="container" style="margin-top:80px">

<h1>커뮤니티</h1>
<p>게시글 상세보기</p>

<h3>${board.writer }의 글보기</h3>
	<div class="form-group">
		<label for="num">글번호:</label> <input type="text" class="form-control"
			id="num" name="num" value="${board.num }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title" name="title" value="${board.title }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="pwd">글쓴이:</label> <input type="text" class="form-control"
			id="writer" name="writer" value="${board.writer }"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea class="form-control" rows="5" id="content" name="content"
			readonly="readonly">${board.content }</textarea>
	</div>
	<c:if test="${sessionScope.sMember.id == board.writer}">
		<div class="form-group text-right">
			<button type="button" class="btn btn-secondary btn-sm" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-danger btn-sm" id="btnDelete">삭제</button>
		</div>
</c:if>
	<br>
	<br>
	<div align="center">
		<textarea rows="3" cols="50" id="msg"></textarea>
		<input type="button" value="댓글쓰기" class = "btn btn-secondary btn-sm" id="commentBtn">
	</div>
	<hr/>
	<div id="replyResult"></div>
</div>
<script>
var init = function(){
	$.ajax({
	    type:"get",
	    url : "/reply/list",
	    data : {"bnum" : $("#num").val()}
	})
	.done(function(resp){
		//alert(resp.length);
		var str = "";
		$.each(resp, function(key, val){
			str += val.userid +"  "
			str += val.content +"  "
			str += val.regdate.split("T")[0]+" "
			str +="<a href='javascript:fdel("+val.cnum+")'>삭제</a><br>"
		})
		 $("#replyResult").html(str);
	})
	.fail(function(e){
	    alert("실패");
	})
}
//댓글쓰기
$("#commentBtn").click(function(){
	if($("#msg").val()==""){
		alert("댓글을 적으세요");
		return;
	}
	data ={
			"bnum" : $("#num").val(),
			"content" : $("#msg").val()
	}
	$.ajax({
		type:"post",
		url : "/reply/insert/"+$("#num").val(),
		contentType:"application/json;charset=utf-8",
		data : JSON.stringify(data)
     	})
     	.done(function(){
     		alert("댓글 추가 성공");
     		$("#msg").val('');
     		init();
     	})
     	.fail(function(){
     		alert("댓글 추가 실패")
     	})
})
//수정
$("#btnUpdate").click(function() {
	if (!confirm('정말 수정할까요?'))
		return false;
	location.href = "board/update/${board.num}"
})
//삭제
$("#btnDelete").click(function() {
	if (!confirm('정말 삭제할까요?'))
		return false;
	$.ajax({
		type : "delete",
		url : "board/delete/${board.num}",
		success : function(resp) {
			if (resp == "success") {
				alert("삭제성공");
				location.href = "board/list";
			}
		} //success
	}) //ajax
})// btnDelete

//댓글 삭제
function fdel(cnum){
$.ajax({
	    type:"DELETE",
	    url: "/reply/del/"+cnum
	})
	.done(function(resp){
	   alert(resp  +" 번 글 삭제 완료")
	   init();
	})
	.fail(function(e){
		alert("댓글 삭제 실패")
	})
}
init()
</script>
<%@ include file="../includes/footer.jsp" %>