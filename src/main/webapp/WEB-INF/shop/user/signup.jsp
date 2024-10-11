<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">아이디</span>
  <input id = "userid" type="text" class="form-control" placeholder="ID" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">비밀번호</span>
  <input id="password" type="password" class="form-control" placeholder="Password" aria-label="password" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <input id="email" type="text" class="form-control" placeholder="Email" aria-label="Email">
  <span class="input-group-text">@</span>
  <input id="server" type="text" class="form-control" placeholder="Server" aria-label="Server">
</div>

<button id="signup-btn"type="button" class="btn btn-secondary">가입하기</button>
<!-- <div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
  <span class="input-group-text" id="basic-addon2">@example.com</span>
</div> -->

<!-- <div class="mb-3">
  <label for="basic-url" class="form-label">Your vanity URL</label>
  <div class="input-group">
    <span class="input-group-text" id="basic-addon3">https://example.com/users/</span>
    <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3 basic-addon4">
  </div>
  <div class="form-text" id="basic-addon4">Example help text goes outside the input group.</div>
</div> -->

<!-- <div class="input-group mb-3">
  <span class="input-group-text">$</span>
  <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
  <span class="input-group-text">.00</span>
</div> -->


<!-- <div class="input-group">
  <span class="input-group-text">With textarea</span>
  <textarea class="form-control" aria-label="With textarea"></textarea>
</div> -->

<script src="/js/User.js"></script>
<%@ include file="../layout/footer.jsp" %>