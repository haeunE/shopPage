<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class = "row m-5 gap-3 justify-content-md-center">N E W</div>
	<div class = "row m-5 gap-3 justify-content-md-center">
	<c:forEach var="product" items = "${products}">
		<div class="card h-100" style="width: 18rem;">
		  <img src="..${product.productPicture}.jpg" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">${product.productName}</h5>
		    <p class="card-text">${product.content}</p>
		    <a href="#" class="btn btn-primary">Go somewhere</a>
		  </div>
		</div>
	</c:forEach>
		<div class="card" style="width: 18rem;">
		  <img src="/img/니트2.jpg" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		    <a href="#" class="btn btn-primary">Go somewhere</a>
		  </div>
		</div>
		
		<div class="card" style="width: 18rem;">
		  <img src="/img/니트3.jpg" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		    <a href="#" class="btn btn-primary">Go somewhere</a>
		  </div>
		</div>
		
		<div class="card" style="width: 18rem;">
		  <img src="/img/니트4.jpg" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		    <a href="#" class="btn btn-primary">Go somewhere</a>
		  </div>
		</div>
	</div>

<%@ include file="../layout/footer.jsp" %>