function doAjaxPostForUsername() {

	// get the form values  
	var username = $('#username').val();
	$
	.ajax({
		type : "POST",
		url : "/SpringApplication/isUsernameAlreadyExists.html",
		data : "username=" + username,
		success : function(response) {
			// we have the response  
			if (response == 'Someone already has that username. Try another?') {
				$('#infoForUsernameError').html(response);
				document.getElementById("infoForUsername").style.visibility = "hidden";
				document.getElementById("infoForUsernameError").style.visibility = "visible";
				document.getElementById("errorclassusername").style.visibility = "hidden";
			} else {
				$('#infoForUsername').html(response);
				document.getElementById("infoForUsername").style.visibility = "visible";
				document.getElementById("infoForUsernameError").style.visibility = "hidden";
				document.getElementById("errorclassusername").style.visibility = "hidden";
			}

			$('#username').val(username);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function doAjaxPostForEmailId() {
	// get the form values  
	var email = $('#email').val();
	$
	.ajax({
		type : "POST",
		url : "/SpringApplication/isEmailIdAlreadyExists.html",
		data : "email=" + email,
		success : function(response) {
			// we have the response  
			if (response == 'Someone already has that Email Id. Try another?') {
				$('#infoForemailerror').html(response);
				document.getElementById("infoForemail").style.visibility = "hidden";
				document.getElementById("infoForemailerror").style.visibility = "visible";
				document.getElementById("emailerror").style.visibility = "hidden";
			} else {
				$('#infoForemail').html(response);
				document.getElementById("infoForemail").style.visibility = "visible";
				document.getElementById("infoForemailerror").style.visibility = "hidden";
				document.getElementById("emailerror").style.visibility = "hidden";
			}
			$('#email').val(email);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function deleteTicket(deleteId) {
            bootbox.confirm("Are you sure, you want to delete this Ticket ?", function(result) {
	 if (result==true)
	 { 
		$.ajax({
		type : "POST",
		url : "/SpringApplication/deleteTicket.html",
		data : "deleteId=" + deleteId,
		success : function(response) {
			window.location.reload();
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
  	}else
  	{	
	return false;
  	}
});
};