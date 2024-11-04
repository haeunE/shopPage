<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp" %>
<input type = "hidden" id = "id" value="${userInfo.id}">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">아이디</span>
  <input id = "userid" type="text" class="form-control" value="${userInfo.userid}" placeholder="ID" aria-label="Username" aria-describedby="basic-addon1" disabled="disabled">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">비밀번호</span>
  <input id="password" type="password" class="form-control"  placeholder="Password" aria-label="password" aria-describedby="basic-addon1" >
</div>

<div class="input-group mb-3">
  <input id="email" type="text" class="form-control" value="${userInfo.email.split('@')[0]}" placeholder="Email" aria-label="Email">
  <span class="input-group-text">@</span>
  <input id="server" type="text" class="form-control" value="${userInfo.email.split('@')[1]}" placeholder="Server" aria-label="Server">
</div>

<button id="modify-btn" type="button" class="btn btn-warning">정보수정</button>
<button id="delete-btn" type="button" class="btn btn-danger">회원탈퇴</button>
<script src="/js/User.js"></script>
<%@ include file ="../layout/footer.jsp" %>