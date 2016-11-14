$(document).ready(function() {
	var show = null;
	$.ajax({
		type : "POST",
		url : "instructor"
	}).done(function(result) {
		show = result[0];
		console.log(show);
		$("#showInstructor").html(JSON.stringify(show));
	});

});