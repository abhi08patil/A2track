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
<title>Summary Grid</title>
<script src="js/betapage.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet">
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap.js"></script>
<link href="css/dashboard.css" rel="stylesheet">
<style>
table,thead,tr,tbody,th,td {
	text-align: center !important;
}
</style>
</head>
<spring:htmlEscape defaultHtmlEscape="true" />
<body>
	<jsp:include page="../views/header.jsp"></jsp:include>
	<div class="container">
		<div class="bs-example">
			<ul class="pager">
				<li class="previous"><a href='<c:url value="/welcome.html"/>'><strong
						style="font-weight: bold;">&larr; Back </strong></a></li>
			</ul>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-left">
			<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
				role="navigation">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview</a></li>
					<li><a href="<c:url value='downloadReport.html'/>">Reports</a></li>
					<li><a href="#">Analytics</a></li>
					<li><a href="#">Export</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item</a></li>
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href="">More navigation</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
				</ul>

			</div>
			<!--/span-->
			<div class="col-sm-9 col-md-10 main">
				<!--toggle sidebar button-->
				<p class="visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">
						<i class="glyphicon glyphicon-chevron-left"></i>
					</button>
				</p>
				<h1 class="page-header">Dashboard</h1>
				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder text-center">
						<img src="images/fff_002.gif"
							class="center-block img-responsive img-circle"
							alt="Generic placeholder thumbnail" />
						<div class="wrapper">
							<div class="caption post-content">
								<h3>
									Open Ticket:
									<p>${countActive}
								</h3>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder text-center">
						<img src="images/fff_002.gif"
							class="center-block img-responsive img-circle"
							alt="Generic placeholder thumbnail">
						<div class="wrapper">
							<div class="caption post-content">
								<h3>
									Resolved Ticket:
									<p>${countResolved}
								</h3>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder text-center">
						<img src="images/fff_002.gif"
							class="center-block img-responsive img-circle"
							alt="Generic placeholder thumbnail">
						<div class="wrapper">
							<div class="caption post-content">
								<h3>
									Suspended Ticket:
									<p>${countSuspended}
								</h3>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder text-center">
						<img src="images/fff_002.gif"
							class="center-block img-responsive img-circle"
							alt="Generic placeholder thumbnail">
						<div class="wrapper">
							<div class="caption post-content">
								<h3>
									Unassigned Ticket:
									<p>${countNotAssigned}
								</h3>
							</div>
						</div>

					</div>
				</div>
				<br> <br> <br> <br>
				<hr>

				<h2 class="sub-header">Summary</h2>
				<div class="table-responsive">
					<table id="example"
					class="table table-striped table-bordered table-hover"
					cellspacing="0" width="100%">
						<thead class="tableHeading"
							style="font-weight: bold; font-size: 19px;">
							<tr>
								<th>#</th>
								<th>Ticket Name</th>
								<th>Environment</th>
								<th>Current Status</th>
								<th>Priority</th>
								<th>Assigned To</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ticketDetailsList}" var="ticketDetails">
								<tr>
									<td>${ticketDetails.id}</td>
									<td>${ticketDetails.name}</td>
									<td>${ticketDetails.environment}</td>
									<td>${ticketDetails.active}</td>
									<td>${ticketDetails.priority}</td>
									<td>${ticketDetails.userId.userName}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
			<!--/row-->
		</div>
	</div>
	<!--/.container-->
	<footer>
	<p class="pull-right">©2014 Company</p>
	</footer>
	<script type="text/javascript">
		$(document).ready(function() {
			$('[data-toggle=offcanvas]').click(function() {
				$('.row-offcanvas').toggleClass('active');
			});
			$('#example').dataTable();
		});
	</script>
</body>
</html>