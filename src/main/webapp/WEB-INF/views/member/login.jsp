<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div class="container" style="margin-top:80px">
	<h2>로그인</h2>
	  <div class="form-group">
	    <label for="id">아이디:</label>
	    <input type="text" class="form-control" placeholder="Enter Userid" id="id" name="username">
	  </div>
	  <div class="form-group">
	    <label for="password">비밀번호:</label>
	    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
	  </div>
      <button type="button" class="btn btn-primary" id="loginBtn">LOGIN</button>
</div>

<script> // 밑에 적어줬기 때문에 document Ready 안씀 , webapp/resources 아래에 .js만 따로 빼도 됨
// 로그인
$("#loginBtn").click(function(){
	if($("#id").val()=="") {
		alert("아이디를 입력하세요");
		$("#id").focus();
		return false;
	}
	if($("#pass").val()=="") {
		alert("비밀번호를 입력하세요");
		$("#pass").focus();
		return false;
	}
	$.ajax({ // id, pass 가져가서 로그인 하기
		type : "post",
		url : "/member/login",
		data : {"id" : $("#id").val(),
				"pass" : $("#pass").val()}
	})
	.done(function(resp){
		if(resp == "no") {
			alert("회원이 아닙니다. 회원가입하세요.");
			location.href="join";
		} else if(resp == "success") {
			alert("로그인 성공");
			location.href="/"
		} else {
			alert("비밀번호를 확인하세요.");
		}
	})
	
})
</script>


<%@ include file="../includes/footer.jsp" %>