$(document).ready(function(){
	var leaveId = window.location.href.split("=")[1];
	$.ajax({
		url:"/cms/getTeaLeave",
		type:"POST",
		dataType:"json",
		data:{'leaveId':leaveId,},
		success:function(msg){
			for(var i in msg.data[0]){
				if(i=="cause"){
					$('textarea').html(msg.data[0][i]);
					continue;
				}
				if(i=="type"){
					if(msg.data[0][i]=='0'){
						$('input[name="type"]').val('课假');
					}else{
						$('input[name="type"]').val('离校假');
					}
					continue;
				}
				$('input[name="'+i+'"]').val(msg.data[0][i]);
			}
			
		}
	})
})