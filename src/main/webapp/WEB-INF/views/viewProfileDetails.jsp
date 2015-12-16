<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Issue Tracker System</title>
<script src="js/betapage.js" type="text/javascript"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" type="text/css" href="css/style_new.css" />
<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
<link rel="stylesheet" href="css/datepicker.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/bootstrap.css" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<spring:htmlEscape defaultHtmlEscape="true" />
<script type="text/javascript">
	$(document).ready(function() {
		$('.open-modal').click(function() {
			$('#myModal').modal('show');
		});
		$("#myModal").on('hidden.bs.modal', function() {
		});
		$('#dateofbirth').datepicker({
			format : "dd/mm/yyyy",
			autoclose : true,
			clearBtn : true,
			todayHighlight : true,
			showOnFocus : true
		});
		$(".bs-example input ").tooltip({
			placement : 'right'
		});
		$(".bs-example select ").tooltip({
			placement : 'right'
		});
		$(".bs-example textarea ").tooltip({
			placement : 'right'
		});
		$(".bs-example img").tooltip({
			placement : 'right'
		});
		$(".bs-example span").tooltip({
			placement : 'right'
		});
		$(".bs-example button").tooltip({
			placement : 'top'
		});
		$("a").tooltip({
			placement : 'top'
		});
	});
</script>
<body>
	<jsp:include page="../views/header.jsp"></jsp:include>
	<hr>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="bs-example ">
			<ul class="pager">
				<li class="previous"><a href='<c:url value="/welcome.html"/>'
					data-toggle="tooltip" data-original-title="Back"> <strong
						style="font-weight: bold;">&larr; Back </strong>
				</a></li>
			</ul>

		</div>
		<form:form action="updateProfile.html" modelAttribute="editUserDetailsDTO"
			method="post" enctype="multipart/form-data" acceptCharset="UTF-8"
			id="userDTO">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-5 col-md-3">
						<div class="form-login">
							<h4>
								Update your Profile.<i class="fa fa-sign-in"></i>
							</h4>
							<input type="text" class="form-control input-sm chat-input"
								name="nameEdit" id="userNameEdit" placeholder="UserName"
								value="${userDetails.name}" data-toggle="tooltip"
								data-original-title="Enter Username"> 
								</br> 
								<input type="text" class="form-control input-sm chat-input"
								name="emailIdEdit" id="emailIdEdit"
								placeholder="Email Address" value="${userDetails.email}"
								data-toggle="tooltip" data-original-title="Enter Email Address">
								</br>
							 <input type="text" name="dateOfBirth" id="dateOfBirth"
								class="form-control input-sm chat-input"
								placeholder="Date Of Birth" value="${userDetails.dateOfBirth}"
								data-toggle="tooltip" data-original-title="Enter Date Of Birth">
								</br>
							<div class="wrapper">
								<span class="group-btn"> 
								<input type="Submit" class="btn btn-primary"
										data-toggle="tooltip" title="Submit"/>
								<a href="#" class="btn btn-primary btn-md open-modal">
								Change Password <i class="fa fa-sign-in"></i></a>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
		<br>
		<form:form action="" modelAttribute="userDTO" method="post"
			enctype="multipart/form-data" acceptCharset="UTF-8" id="userDTO">
			<div class="bs-example">
				<!-- Modal HTML -->
				<div id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true" data-toggle="tooltip" title="Close">&times;</button>
								<h4 class="modal-title">Change Password</h4>
							</div>
							<div class="modal-body">
								<p>
									<input type="password" class="form-control"
										name="currentPassword" id="currentPassword"
										placeholder="Current Password" value="" style="width: 60%;"
										data-toggle="tooltip"
										data-original-title="Enter Current Password">
								<p>
									<input type="password" class="form-control" name="newPassword"
										id="newPassword" placeholder="New Password" value=""
										style="width: 60%;" data-toggle="tooltip"
										data-original-title="Enter New Password">
								<p>
									<input type="password" name="confirmNewPassword"
										class="form-control" id="confirmNewPassword"
										placeholder="Confirm New Password" value=""
										style="width: 60%;" data-toggle="tooltip"
										data-original-title="Confirm New Password">
								</p>
								<br>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal" data-toggle="tooltip" title="Close">Close</button>
									<button type="Submit" class="btn btn-primary"
										data-toggle="tooltip" title="Submit">Submit</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
		<div class="beta"></div>
		<div id="footer">
			<div class="copyr">
				&copy; 2014 <img src="images/liftofflogo.png" class="liftoff" />
			</div>
		</div>
		<footer>
		<p class="pull-right">©2014 Company</p>
		</footer>
</body>
</html>