var id = window.location.href.split("=")[1];
$(document).ready(function() {
	$.ajax({
		url:"/cms/getNoticeInfo",
		type:"post",
		data:{"noticeId":id},
		dataType:"json",
		success:function(data){
			if(data){
				$(".content").html(data.content);
				$(".title").html(data.title);
				$(".title_other span").html(data.createBy);
				var time = data.createTime.split(' ')[0];
				$(".title_other em").html(time);
			}
		}
	});
} );


