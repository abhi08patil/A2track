<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sign in Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<script src="js/bootbox.min.js"></script>
<link href="css/form.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$(".container span").tooltip({
			placement : 'right'
		});
		$(".container button").tooltip({
			placement : 'bottom'
		});
		$(".container input").tooltip({
			placement : 'right'
		});
	});
</script>
<body>

	<div id="fullBg"></div>
	<div class="container">
		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				<strong>Your login attempt was not successful, try again.<br />
					Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</strong>
			</div>
		</c:if>
		<c:if test="${sessionTimeout=='true'}">
			<div class="alert alert-danger">
				<strong>Session time out.</strong>

			</div>
		</c:if>
		<c:if test="${logout=='true'}">
			<div class="successblock" style="color: white;">
				<strong>You have been logged out.</strong>
			</div>
		</c:if>
		<form class="form-signin" name='f'
			action="<c:url value='j_spring_security_check' />" method='POST'>
			<h1 class="form-signin-heading">Please Sign In</h1>
			<input type='text' name='j_username' value='' class="form-control"
				placeholder="Email address" data-toggle="tooltip"
				title="Please Enter Email address"> 
			<input type='password' name='j_password' class="form-control"
				 placeholder="Password"  data-toggle="tooltip" 
				 title="Please Enter Password" />
		<!-- 	<%
				ReCaptcha c = ReCaptchaFactory.newReCaptcha(
						"6LeTIPwSAAAAAJa3wa6GEXiFdHQkTiJ7veQLUgO9",
						"6LeTIPwSAAAAAFeTwqtGhejeeAdZC67bdcE0q2Ya", false);
				out.print(c.createRecaptchaHtml(null, null));
			%>styles -->
			<button class="btn btn-large btn-primary btn-block" type="submit"
				data-toggle="tooltip" title="Please Sign in">Sign in</button>
		</form>
		<a class="text-center sign-up"
			href="<c:url value='initSignup.html' />">
			<p class="text-center sign-up">
				<strong>Sign up</strong> for a new account
			</p>
		</a>
	</div>
</body>
</html>