<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css" media="screen">
<link rel="stylesheet" href="css/bootswatch.css">
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
			<!-- <img src="images/user_sm.png" width="16" height="22"/> -->
			<img class="media-object img-circle" src="https://s3.amazonaws.com/uifaces/faces/twitter/ademilter/128.jpg" style="height: 63px;">
				<span class="navbar-brand"> User:</span> 
				<span class="navbar-brand"><a href='<c:url value="/viewProfileDetails.html"/>' > ${author}</a></span> 
				
				<img class="media-object img-circle" src="image/userAvatar" style="height: 63px;">
				
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
				<li><span class="navbar-brand"><a href='logout.html'>Logout</a></span></li>
				</ul>
			</div>
      </div>
    </div>
</body>
</html>