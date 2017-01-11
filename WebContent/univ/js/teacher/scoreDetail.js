$(document).ready(function(){
	var scoreId = window.location.href.split("=")[1];
	$.ajax({
		url:'/cms/getTeaStuScoreInfo',
		type:'POST',
		data:{'scoreId':scoreId},
		success:function(msg){
			if(msg.rtnCode=="0"){
				for(var i in msg.studentInfo){
					if(i=="courseType"){
						if(msg.studentInfo[i]=="0"){
							$('input[name="'+i+'"]').val('必修');
						}else{
							$('input[name="'+i+'"]').val('选修');
						}
						continue;
					}
					$('input[name="'+i+'"]').val(msg.studentInfo[i]);
				}
			}
			
		}
	})
})