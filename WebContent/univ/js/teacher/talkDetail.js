$(document).ready(function(){
	var orderRecordId = window.location.href.split("=")[1];
	$.ajax({
		url:"/cms/getOrderRecordInfo",
		type:"POST",
		dataType:"json",
		data:{'orderRecordId':orderRecordId,},
		beforeSend: function () {
            $("body").append('<div id="pload" style="position:fixed;top:30%;z-index:1200;background:url(/wap/images/loading.gif) top center no-repeat;width:100%;height:140px;margin:auto auto;"></div>');
        },
        complete: function () {
            $("#pload").remove();
        },
		success:function(msg){
			if(msg.rtnCode=="0"){
				for(var i in msg.data){
					$('input[name="'+i+'"]').val(msg.data[i]);
				}
			}
			
		}
	})
})