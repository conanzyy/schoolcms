var id = window.location.href.split("=")[1];
$(document).ready(function() {
	$.ajax({
		url:"/cms/getTNoticeInfo",
		type:"post",
		data:{"noticeId":id},
		dataType:"json",
		success:function(data){
			if(data){
				var content = data.content;
				$("#content").html(content);
			}
		}
	});
} );


