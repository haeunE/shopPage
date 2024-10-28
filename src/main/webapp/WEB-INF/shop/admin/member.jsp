<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class='row'>
	<div class="col-md-3 col-sm-3">
	<!-- 사이드 바 메뉴-->
	  <!-- 패널 타이틀1 -->
		<div class="panel panel-info p-3">
		    <div class="panel-heading">
		      <h3 class="panel-title">관리자 페이지</h3>
		    </div>
		    <!-- 사이드바 메뉴목록1 -->
		    <ul class="list-group">
		      <li class="list-group-item"><a href="/admin/member">회원관리</a></li>
		      <li class="list-group-item"><a href="/admin/product">게시물관리</a></li>
		      <li class="list-group-item"><a href="/admin/order">주문관리</a></li>
		    </ul>
		</div>
	</div>
	<div class='col-sm-9'>
		<div class='col-8 col'></div>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end p-3 col-4 col-sm-auto">
		  
		  <button class="btn btn-primary me-md-2 btn-success" type="button">주문내역</button>
		  <button class="btn btn-primary me-md-2" type="button">회원 수정</button>
		  <button class="btn btn-primary btn-danger" type="button">회원 탈퇴</button>
		</div>
	</div>
</div>
<div>
	<ul class="list-group">
	  <li class="list-group-item">
	    <input class="form-check-input me-1" type="checkbox" value="" id="firstCheckboxStretched">
	    <label class="form-check-label stretched-link" for="firstCheckboxStretched"><a>${mebers }</a></label>
	  </li>
	</ul>
</div>

<%@ include file ="../layout/footer.jsp" %>