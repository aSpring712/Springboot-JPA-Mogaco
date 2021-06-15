2<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container" style="margin-top: 80px">

	<h2>회원가입 하기</h2>
	<form>
		<div class="form-group">
			<label for="username">아이디:</label>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" id="username" placeholder="Enter ID" name="username">
				</div>
				<div class="col">
					<button type="button" class="btn btn-primary form-inline" id="idCheckBtn">중복확인</button>
					<span id="idcheck"></span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
		</div>
		<div class="form-group">
			<label for="pass_check">비밀번호 확인:</label> <input type="password" class="form-control" id="pass_check" name="pass_check" placeholder="Enter Password for check">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label> <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
		</div>
	</form>
	<button class="btn btn-secondary" id="btn-save">회원가입</button>
</div>

<script src="js/user.js"></script>

<%@ include file="../includes/footer.jsp"%>