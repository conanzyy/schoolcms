$(document).ready(function(){
	var leaveId = window.location.href.split("=")[1];
	$.ajax({
		url:"/cms/getLeaveInfo",
		type:"POST",
		dataType:"json",
		success:function(msg){
			for(var i in msg.data){
				if(leaveId==msg.data[i].leaveId){
					for(var j in msg.data[i]){
						if(j=="applyTime"||j=="comeTime"||j=="leaveTime"){
							$('input[name="'+j+'"]').val(msg.data[i][j].split(' ')[0]);
							continue;
						}
						if(j=="cause"){
							$('textarea').html(msg.data[i][j]);
							continue;
						}
						$('input[name="'+j+'"]').val(msg.data[i][j]);
					}
				}
			}
		}
	})
})