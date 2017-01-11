$(document).ready(function(){
	var jobId = window.location.href.split("=")[1];
	$.ajax({
		url:"/cms/getTeaJob",
		type:"POST",
		dataType:"json",
		data:{'jobId':jobId},
		success:function(msg){
			for(var i in msg.data){
				$('input[name="'+i+'"]').val(msg.data[i]);
			}
		}
	})
})