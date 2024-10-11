<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
      <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">SHOP</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">HOME</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/new-products">NEW</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/signup">BEST</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/signup">SHOP</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/signup">SALE</a>
        </li>
        <c:if test = "${sessionScope.principal == null}">
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            회원
	          </a>
	          <ul class="dropdown-menu">
		        <li class="nav-item">
		          <a class="nav-link" href="/auth/signup">Sign up</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/auth/login">Log in</a>
		        </li>
		       </ul>
		    </li>
        </c:if>
	    <c:if test = "${sessionScope.principal != null}">
	    	<li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            ${sessionScope.principal.userid.toUpperCase()}님
	          </a>
	          <ul class="dropdown-menu">
		        <li class="nav-item">
		          <a class="nav-link" href="/auth/userinfo">Information</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/auth/logout">Log out</a>
		        </li>
		       </ul>
		    </li>
	    </c:if>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>