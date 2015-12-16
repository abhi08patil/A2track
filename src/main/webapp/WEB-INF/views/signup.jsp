<!DOCTYPE html>
<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Sign up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/halflings.css">
<link rel="stylesheet" href="css/style.css">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>
<body>
  <div id="fullBg"></div>
  
<div class="container">
	<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<form name="signUpDTO" id="signUpDTO" method="post" class="form-signup"  action="<c:url value='signUpForm.html' />" >
				<h1 class="form-signup-heading">Sign Up</h1>
					<div class="form-group">
						<label for="username" class="control-label">UserId:</label> 
						<input type="text" name="username" id="username" placeholder="Username" autofocus class="form-control textwidth" onblur="doAjaxPostForUsername()">
						<span id="infoForUsername" class="success"></span>
						<span id="infoForUsernameError" class=" error"></span> 
					</div>
					<div class="form-group">
						<label for="name" class="control-label">Name:</label> 
						<input type="text" name="name" id="name" placeholder="Name" autofocus class="form-control textwidth"> 
					</div>					
					<div class="form-group">
						<label for="email" class="control-label">Email:</label>
						 <input type="email" name="email" id="email" placeholder="Email"  autofocus class="form-control textwidth" onblur="doAjaxPostForEmailId()">
						 <span id="infoForemail" class="success"></span>
						 <span id="infoForemailerror" class="error"></span>
					</div>
					<div class="form-group">
						<label for="dateofbirth" class="control-label">DOB:</label>
						<input type="text" name="dateofbirth" id="dateofbirth" placeholder="Date Of Birth" class="form-control textwidth">
					</div>
					<div class="form-group">
                                <label for="password" class="control-label">Password:</label>
                                
                                    <input type="password" id="password" placeholder="Password" class="form-control textwidth" name="password" />
                     
                    </div>
					 <div class="form-group ">
                                <label for="confirmPassword" class="control-label" >Confirm password:</label>
                                    <input type="password" class="form-control textwidth" placeholder="ConfirmPassword" name="confirmPassword " id="confirmPassword" />
				
					</div>
					<div class="form-group ">
					<input type="submit" value="Sign up" class="btn btn-large btn-primary btn-block">
					</div>
				</form>
				<a class="text-center sign-up"
					href="<c:url value='initSignin.html'/>">
					<p class="text-center sign-up">
						<strong>Already register then Sign In</strong>
					</p>
				</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/angular.js"></script>
	<script src="js/script.js"></script>
	<script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrapValidator.js"></script>
    <script src="js/validation.js"></script>
    <script src="js/ajax.js"></script>
</body>
</html>