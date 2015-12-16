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
<link rel="stylesheet" type="text/css" href="css/style_new.css" />
<script src="js/betapage.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
	
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet">
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap.js"></script>
<script src="js/bootstrap.file-input.js"></script>
<style>
 table,thead,tr,tbody,th,td
	{
        text-align: center !important;
    }
</style>
</head>
<spring:htmlEscape defaultHtmlEscape="true" />
<script type="text/javascript">
	$(document).ready(function() {
		$('.open-modal').click(function() {
			$('#myModal').modal('show');
		});
		$("#myModal").on('hidden.bs.modal', function() {
		});
		$('.open-modal-user').click(function() {
			$('#myModal-user').modal('show');
		});
		$("#myModal-user").on('hidden.bs.modal', function() {
		});
		$('.open-modal-userEdit').click(function() {
			$('#myModal-userEdit').modal('show');
		});
		$("#myModal-userEdit").on('hidden.bs.modal', function() {
		});
		$('#example').dataTable();
		$("select ").tooltip({
			placement : 'right'
		});
		$(".bs-example input ").tooltip({
			placement : 'right'
		});
		$(".bs-example button ").tooltip({
			placement : 'top'
		});
		$(".bs-example textarea ").tooltip({
			placement : 'right'
		});
		$(".bs-example span ").tooltip({
			placement : 'right'
		});
		$(".container input ").tooltip({
			placement : 'top'
		});
		$(".container a").tooltip({
			placement : 'top'
		});
		$('input[type=file]').bootstrapFileInput();
		$('.file-inputs').bootstrapFileInput();
	});
</script>
<body>
	<jsp:include page="../views/header.jsp"></jsp:include>
	<hr>
	<br>
	<br>
	<br>
   <div class="message green">${message}</div>
   
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<input type="button" class="btn btn-primary open-modal"
					value="Report Ticket" data-toggle="tooltip" title="Report Ticket">
				<a href='<c:url value="/manageTicket.html"/>'
					class="btn btn-primary" title="ManageTicket" name="ManageTicket"
					data-toggle="tooltip">Manage Ticket</a>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<input type="button" class="btn btn-primary open-modal-user"
						value="Add User" data-toggle="tooltip" title="Add User">
				</sec:authorize>
				<a href='<c:url value="/viewSummaryGrid.html"/>'
					class="btn btn-primary" title="Summary Grid" name="summaryGrid"
					data-toggle="tooltip">Summary Grid</a>
			</div>
		</div>
	</div>
	<form:form action="initReportTicket.html" modelAttribute="reportDTO"
		method="post" enctype="multipart/form-data" acceptCharset="UTF-8"
		id="reportDTO">
		<div class="bs-example">
			<!-- Modal HTML -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Report Ticket</h4>
						</div>
						<div class="modal-body">
							<p>
								<input type="text" class="form-control" name="name" id="name"
									placeholder="Enter Name Of Issue" value="" style="width: 70%;"
									data-toggle="tooltip" title="Enter Name Of Issue">
							</p>
							<br>
							<p>
								<textarea rows="4" cols="50" name="description" id="description"
									placeholder="Enter Description" value="Enter Description"
									class="form-control" style="width: 70%;" data-toggle="tooltip"
									title="Enter Description"></textarea>
							</p>
							<br>
							<p>
								<select class="form-control" style="width: 50%;" name="priority"
									id="dropdown1" onchange="selectDropdown();"
									data-toggle="tooltip" title="Please Select Priority">
									<option value="">Please Select Priority</option>
									<option value="High">High</option>
									<option value="Low">Low</option>
									<option value="Medium">Medium</option>
									<option value="Complex">Complex</option>
								</select>
							</p>
							<br>
							<p>
								<select class="form-control" style="width: 50%;"
									name="environment" id="dropdown2" onchange="selectDropdown();"
									data-toggle="tooltip" title="Please Select Environment">
									<option value="">Please Select Environment</option>
									<option value="Local">Local</option>
									<option value="Testing">Testing</option>
									<option value="UAT">UAT</option>
									<option value="Production">Production</option>
								</select>
							</p>
							<br> <span class="btn btn-default btn-file"
								data-toggle="tooltip" title="Please Upload file"> <img
								alt="140x140" src="images/ATTACHMENT-GRAY_12.png"> <input
								type="file" name="file" id="file">
							</span> <br> <br>
							<p class="text-warning">
								<small>If you don't save, your changes will be lost.</small>
							</p>
						</div>
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
	</form:form>
	<br>
	<form:form action="addUser.html" modelAttribute="userDTO" method="post"
		enctype="multipart/form-data" acceptCharset="UTF-8" id="userDTO">
		<div class="bs-example">
			<!-- Modal HTML -->
			<div id="myModal-user" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true" data-toggle="tooltip" title="Close">&times;</button>
							<h4 class="modal-title">Add User</h4>
						</div>
						<div class="modal-body">
							<p>
								<input type="text" class="form-control" name="userName"
									id="userName" placeholder="Enter Name Of User" value=""
									style="width: 50%" data-toggle="tooltip"
									title="Enter Name Of User">
							</p>
							<br>
							<p>
								<input type="text" class="form-control" name="emailId"
									id="emailId" placeholder="Enter Email Address" value=""
									style="width: 50%;" data-toggle="tooltip"
									title="Enter Email Address">
							</p>
							<br>
							<p>
								<select class="form-control" style="width: 50%;" name="userType"
									id="userType" onchange="selectDropdown();"
									data-toggle="tooltip" title="Please Select Role">
									<option value="">Please Select Role</option>
									<option value="Admin">ADMIN</option>
									<option value="Reporter">REPORTER</option>
									<option value="Developer">DEVELOPER</option>
								</select>
							</p>
							<br>
							<p>
								<select class="form-control" style="width: 50%;"
									name="userStatus" id="userStatus" onchange="selectDropdown();"
									data-toggle="tooltip" title="Please Select Status">
									<option value="">Please Select Status</option>
									<option value="Inactive">INACTIVE</option>
									<option value="Active">ACTIVE</option>
									<option value="Pending">PENDING</option>
									<option value="Suspended">SUSPENDED</option>
								</select>
							</p>
							<br> 
							<span class="btn btn-default btn-file"
								data-toggle="tooltip" title="Please Upload profile pic"> <img
								alt="140x140" src="images/ATTACHMENT-GRAY_12.png"> <input
								type="file" name="file" id="file">
							</span>
							<br> <br>
							<p class="text-warning">
								<small>If you don't save, your changes will be lost.</small>
							</p>
						</div>
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
	</form:form>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table id="example"
						class="table table-striped table-bordered table-hover"
						cellspacing="0" width="100%">
						<thead class="tableHeading" style="font-weight: bold; font-size: 19px;">
							<tr>
								<th>#</th>
								<th>User Name</th>
								<th>Email Address</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${usersList}" var="usersList">
								<tr>
									<td>${usersList.userId}</td>
									<td>${usersList.userName}</td>
									<td>${usersList.email}</td>
									<td>${usersList.status}</td>
									<td><a
										href="javascript:showPopup('${usersList.userName}','${usersList.email}','${usersList.roleAdmin}','${usersList.status}')"
										class="open-modal-userEdit dobOfUser" data-toggle="tooltip"
										title="EDIT" name="edit">Edit</a>/<a title="DELETE"
										name="delete" data-toggle="tooltip" class='delete' onclick=""
										style="cursor: pointer;">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr>
				</div>
			</div>
		</div>
	</sec:authorize>
	<form:form action="updateUser.html" modelAttribute="editUserDetailsDTO"
		method="post" enctype="multipart/form-data" acceptCharset="UTF-8"
		id="editUserDetailsDTO">
		<div class="bs-example">
			<!-- Modal HTML -->
			<div id="myModal-userEdit" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Add User</h4>
						</div>
						<div class="modal-body">
							<p>
								<input type="text" class="form-control" name="userNameEdit"
									id="userNameEdit" value="" style="width: 50%" readonly="true"
									data-toggle="tooltip" title="Name Of User">
							</p>
							<br>
							<p>
								<input type="text" class="form-control" name="emailIdEdit"
									id="emailIdEdit" value="" style="width: 50%;"
									data-toggle="tooltip" title="Email Address Of User">
							</p>
							<br>
							<p>
								<select class="form-control" style="width: 50%;"
									name="userTypeEdit" id="userTypeEdit"
									onchange="selectDropdown();" data-toggle="tooltip"
									title="Role Of User">
									<option value="">Please Select Role</option>
									<option value="Admin">ADMIN</option>
									<option value="Reporter">REPORTER</option>
									<option value="Developer">DEVELOPER</option>
								</select>
							</p>
							<br>
							<p>
								<select class="form-control" style="width: 50%;"
									name="userStatusEdit" id="userStatusEdit"
									onchange="selectDropdown();" data-toggle="tooltip"
									title="Status Of User">
									<option value="">Please Select Status</option>
									<option value="Inactive">INACTIVE</option>
									<option value="Active">ACTIVE</option>
									<option value="Pending">PENDING</option>
									<option value="Suspended">SUSPENDED</option>
								</select>
							</p>
							<br> <br>
							<p class="text-warning">
								<small>If you don't save, your changes will be lost.</small>
							</p>
						</div>
						
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
	</form:form>
	<div class="beta"></div>
	<div id="footer">
		<div class="copyr">
			&copy; 2014 <img src="images/liftofflogo.png" class="liftoff" />
		</div>
	</div>
	<script type="text/javascript">
		function selectDropdown() {
			var dropdownValue = "";
			dropdownValue = document.getElementById("dropdown1").value;
			document.getElementById("dropdown1").value = dropdownValue;
		}

		function showPopup(userName, email, roleAdmin, status) {
			$('#userNameEdit').val(userName);
			$('#emailIdEdit').val(email);
			$('#userTypeEdit').val(roleAdmin);
			$('#userStatusEdit').val(status);
		};
	</script>
	<footer>
	<p class="pull-right">©2014 Company</p>
	</footer>
</body>
</html>