<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div class="container" style="margin-top:80px">

<h1>챌린지 목록</h1>
<p>원하는 챌린지에 참여하거나 직접 개설할 수 있습니다.</p>


<div class="input-group mt-3 mb-3">
  <input type="text" class="form-control" placeholder="챌린지 검색">
  <button class="button primary mr-2" type="button" id="button-addon2">검색</button>
  <a href="/challenge/insertForm" class="button secondary">챌린지 개설</a>
</div>

<div class="container mt-5">
  <div class="card-deck">
    <div class="card bg-primary">
      <div class="card-body text-center">
        <p class="card-text">Some text inside the first card</p>
        <p class="card-text">Some more text to increase the height</p>
        <p class="card-text">Some more text to increase the height</p>
        <p class="card-text">Some more text to increase the height</p>
      </div>
    </div>
    <div class="card bg-warning">
      <div class="card-body text-center">
        <p class="card-text">Some text inside the second card</p>
      </div>
    </div>
    <div class="card bg-success">
      <div class="card-body text-center">
        <p class="card-text">Some text inside the third card</p>
      </div>
    </div>
    <div class="card bg-danger">
      <div class="card-body text-center">
        <p class="card-text">Some text inside the fourth card</p>
      </div>
    </div>  
  </div>
</div>

</div>

<%@ include file="../includes/footer.jsp" %>