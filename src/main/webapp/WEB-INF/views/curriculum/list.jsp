<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container" style="margin-top: 80px">

	<h1>챌린지 목록</h1>
	<p>원하는 챌린지에 참여하거나 직접 개설할 수 있습니다.</p>


	<div class="input-group mt-3 mb-3">
		<input type="text" class="form-control" placeholder="챌린지 검색">
		<button class="button primary mr-2" type="button" id="button-addon2">검색</button>
		<a href="/challenge/insertForm" class="button secondary">챌린지 개설</a>
	</div>

	<div class="card m-2" style="width: 500px">
		<img class="card-img-top" src="img_avatar1.png" alt="Card image">
		<div class="card-body">
			<h4 class="card-title">커리큘럼 명</h4>
			<p class="card-text">커리큘럼 간단 설명</p>
			<a href="#" class="btn btn-primary">상세보기 버튼</a>
		</div>

	</div>

</div>

<%@ include file="../includes/footer.jsp"%>