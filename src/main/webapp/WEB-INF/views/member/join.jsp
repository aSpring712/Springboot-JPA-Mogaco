<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div class="container" style="margin-top:80px">

<h2>회원가입 하기</h2>
  <form action="/member/join" method="post">
  	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
    <div class="form-group">
      <label for="userId">아이디:</label>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" id="userId" placeholder="Enter userid" name="userId">
				</div>
				<div class="col">
					<button type="button" class="btn btn-primary form-inline" id="idCheckBtn">중복확인</button>
					<span id="idcheck"></span>
				</div>
			</div>
		</div>
    <div class="form-group">
      <label for="password">비밀번호:</label>
      <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
    </div>
    <div class="form-group">
      <label for="pass_check">비밀번호 확인:</label>
      <input type="password" class="form-control" id="pass_check" name="pass_check" placeholder="Enter Password for check">
    </div>
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
    </div>
    <button type="button" class="btn btn-secondary" id="btnJoin">회원가입</button>
  </form>
</div>

<script>
// 유효성 검사
$("#btnJoin").click(function(){
	if($("#user_Id").val() == "") {
		alert("id를 입력하세요.")
		$("#user_Id").focus();
		return false;
	}
	if($("#password").val() == "") {
		alert("비밀번호를 입력하세요.")
		$("#password").focus();
		return false;
	}
	if($("#pass_check").val() != $("#password").val()) {
		alert("비밀번호가 일치하지 않습니다.")
		$("#pass_check").val('');
		$("#pass_check").focus();
		return false;
	}
	if($("#email").val() == "") {
		alert("이메일을 입력하세요.")
		$("#email").focus();
		return false;
	} // 다 맞다면
	var data = { // data 전달
			"userId" : $("#userId").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val()
	}
	$.ajax({
		type : "post",
		url : "/member/join",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data)
	})
	.done(function(resp) {
		if(resp=="success") {
			alert("회원가입을 축하합니다.");
			location.href="member/login";
		} else if(resp=="fail") {
			alert("아이디 중복확인하세요.");
			$("#userId").val("");
		}
	})
	.fail(function(e) {
		alert("회원가입 실패");		
	})
})

// id 중복 검사
$("#idCheckBtn").click(function(){
	if($("#userId").val() == "") { // id를 입력하지 않은 경우
		alert("id를 입력하세요.");
		$("#userId").focus();
		return false;
	} // if
	$.ajax({ // id 전달해서 중복 검사하기
		type : "get",
		url : "/member/idCheck",
		data : {"userId" : $("#userId").val()}
	})
	.done(function(resp){
		if(resp == 0) {
			$("#idcheck").html("<b style='color:blue'>사용가능한 아이디입니다.</b>");
		} else {
			$("#idcheck").html("<b style='color:red'>사용 불가능한 아이디입니다.</b>");
			$("#userId").val("");
			$("#userId").focus();
		}
	})
})
</script>

<%@ include file="../includes/footer.jsp" %>