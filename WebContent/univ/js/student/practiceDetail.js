$(document).ready(function() {
	var practiceId = window.location.href.split("=")[1];
	$.ajax({
		url : "/cms/getPracticeInfo",
		type : "POST",
		dataType : "json",
		data : {
			'practiceId' : practiceId
		},
		success : function(msg) {
			for ( var i in msg.data) {
				console.log(i);
				$('input[name="' + i + '"]').val(msg.data[i]);
			}
		}
	})

	$(document).ready(function() {
		$("#biuuu_button").click(function() {
			$(".top-box-body").printArea();
		});
	});
})