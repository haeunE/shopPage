<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp" %>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">아이디</span>
  <input id = "userid" type="text" class="form-control" placeholder="ID" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">비밀번호</span>
  <input id="password" type="password" class="form-control" placeholder="Password" aria-label="password" aria-describedby="basic-addon1">
</div>
<button id="login-btn" type="button" class="btn btn-dark">로그인</button>

<script src="/js/User.js"></script>
<%@ include file ="../layout/footer.jsp" %>