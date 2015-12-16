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
<script src="js/bootbox.min.js"></script>
<script src="js/ajax.js"></script>
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
    $('#example').dataTable();
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
	$('input[type=file]').bootstrapFileInput();
	$('.file-inputs').bootstrapFileInput();
$( "#doneBy" ).change(function() {
		var x = $(this).val();
		$("#userIdValue").val(x);
});
$("#updateBtn" ).click(function() {
		var x = $("#doneBy").val();
		$("#userIdValue").val(x);
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
		<div class="bs-example">
			<ul class="pager">
				<li class="previous"><a href='<c:url value="/welcome.html"/>'><strong
						style="font-weight: bold;">&larr; Back </strong></a></li>
			</ul>
		</div>
	</div>
	<input type="hidden" id="deleteId" name="deleteId" />
	<input type="hidden" id="userId" name="userId" value=""/>
	<form:form action="updateTicket.html" modelAttribute="reportDTO"
		method="post" enctype="multipart/form-data" acceptCharset="UTF-8"
		id="searchForm">
		<c:forEach items="${ticketDetailsList}" var="ticketDetailsOne">
			<div class="bs-example">
				<!-- Modal HTML -->
				<div id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Edit Ticket</h4>
							</div>
							<div class="modal-body">
								<input type="hidden" id="ticketId" name="ticketId" />
								<input type="hidden" id="userIdValue" name="userIdValue" />
								<p>
									<input type="text" class="form-control" name="name" id="name"
										placeholder="Name Of Issue" value="" style="width: 70%;"
										data-toggle="tooltip"
										data-original-title="Enter Name Of Issue">
								</p>
								<br>
								<p>
									<textarea rows="4" cols="50" name="description"
										id="description" placeholder="Enter Description" value=""
										class="form-control" style="width: 70%;" data-toggle="tooltip"
										data-original-title="Description of Issue"></textarea>
								</p>
								<br>
								<p>
									<input type="text" class="form-control" name="requestedBy"
										id="requestedBy" value="" style="width: 70%;" readonly="true"
										data-toggle="tooltip" data-original-title="Raised By">
								</p>
								<br>
								<p>
									<select class="form-control" style="width: 50%;"
										name="priority" id="dropdown1" data-toggle="tooltip"
										data-original-title="Priority Of Issue">
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
									name="statusEdit" id="statusEdit" onchange="selectDropdown();"
									data-toggle="tooltip" title="Please Select Status">
									<option value="">Please Select Status</option>
									<option value="Inactive">INACTIVE</option>
									<option value="Active">ACTIVE</option>
									<option value="Pending">PENDING</option>
									<option value="Suspended">SUSPENDED</option>
									<option value="Resolved">RESOLVED</option>
								</select>
								</p>
								<br>
								<p>
									<select class="form-control" style="width: 50%;" id="doneBy"
										name="doneBy" data-toggle="tooltip"
										data-original-title="Please Select Assignee" >
										<option value="">Please Select Assignee</option>
										<c:forEach var="usersList" items="${usersList}">
											<option value="${usersList.userName}">${usersList.userName}</option>
										</c:forEach>
									</select>
								</p>
								<br> <span class="btn btn-default btn-file"
									data-toggle="tooltip" data-original-title="Please Upload file">
									<img alt="140x140" src="images/ATTACHMENT-GRAY_12.png"> <input
									type="file" name="file" id="file">
								</span> 
								<a href="${pageContext.request.contextPath}/download/${ticketDetailsOne.id}.html"><img
									src="${pageContext.request.contextPath}/images/save_icon.gif"
									border="0" title="Download this document" id="download"
									name="download" /></a> <a
									href="${pageContext.request.contextPath}/remove/${ticketDetailsOne.id}.html"
									onclick="return confirm('Are you sure you want to delete this document?')"><img
									src="${pageContext.request.contextPath}/images/delete_icon.gif"
									border="0" title="Delete this document" id="remove"
									name="remove" /></a> <br> <br>
								<p class="text-warning">
									<small>If you don't save, your changes will be lost.</small>
								</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal" data-toggle="tooltip" title="Close">Close</button>
								<button type="Submit" id= "updateBtn" class="btn btn-primary"
									data-toggle="tooltip" title="Update">Update</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</form:form>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table id="example"
					class="table table-striped table-bordered table-hover"
					cellspacing="0" width="100%">
					<thead class="tableHeading"
						style="font-weight: bold; font-size: 19px;">
						<tr>
							<th>S.No</th>
							<th>Subject</th>
							<th>Status</th>
							<th>Assigned To</th>
							<th>Requested By</th>
							<th>Environment</th>
							<th>Details</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ticketDetailsList}" var="ticketDetails">
							<tr>
								<td>${ticketDetails.id}</td>
								<td>${ticketDetails.name}</td>
								<td>${ticketDetails.active}</td>
								<td>${ticketDetails.userId.userName}</td>
								<td>${ticketDetails.requestedBy}</td>
								<td>${ticketDetails.environment}</td>
								<td><a
									href="javascript:showPopup('${ticketDetails.id}','${ticketDetails.name}','${ticketDetails.description}','${ticketDetails.priority}','${ticketDetails.requestedBy}','${ticketDetails.userId.userName}','${ticketDetails.active}')"
									class="open-modal dobOfUser" title="EDIT" data-toggle="tooltip"
									name="edit">Edit</a> 
									<sec:authorize access="hasRole('ROLE_ADMIN')">
									/<a title="DELETE" name="delete" style="cursor: pointer;" data-toggle="tooltip"
											onclick="return deleteTicket(${ticketDetails.id});">Delete</a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function showPopup(id,name, description, priority,requestedBy,userName, status) {
			$('#ticketId').val(id);
			$('#name').val(name);
			$('#description').val(description);
			//$('#dropdown2').val(environment);
			$("#dropdown1").val(priority);
			$("#requestedBy").val(requestedBy);
			$("#doneBy").val(userName);
			$('#statusEdit').val(status);
		};
</script>
	<div class="beta"></div>
	<div id="footer">
		<div class="copyr">
			&copy; 2014 <img src="images/liftofflogo.png" class="liftoff" />
		</div>
	</div>
</body>
</html>