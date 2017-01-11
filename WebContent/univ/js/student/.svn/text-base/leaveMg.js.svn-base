var leaveMgTable;
$(document).ready(function() {
	loadTables();
	$('.btn-self1').click(function(){
		$('input[type="hidden"]').val($(this).attr('val'));
		if($(this).attr('val')=='0'){
			$('#myModalLabel').text('新增课假');
		}else{
			$('#myModalLabel').text('新增离校假');
		}
	});
	$('.button-submit').click(function(){
		if($('input[type="hidden"]').val()=='0'){
			$('input[type="hidden"]').remove();
			console.log($('#form').serialize());
			$.ajax({
				url:'/cms/createCourseLeave',
				type:'POST',
		        async: false,
				data:$('#form').serialize(),
				success:function(msg){
					layer.msg('添加成功');
				}
			})
		}else{
			$('input[type="hidden"]').remove();
			$.ajax({
				url:'/cms/createSchoolLeave',
				type:'POST',
		        async: false,
				data:$('#form').serialize(),
				success:function(msg){
					layer.msg('添加成功');
				}
			})
		}
	})
} );


function loadTables(){
	
	if(leaveMgTable !=null){
		leaveMgTable.clear();
		leaveMgTable.destroy();
		leaveMgTable=null;
	}
	var id,n=0;
	 var colums=[
	            { "data":"checkbox",
	              "render":function(value){
	            		return "<input type='checkbox' name='checkList'>";
	            	},
	            	"orderable":false
	            },
	            { "data": "leaveId","render":function(){
	            	++n;
	            	return n;
	            }},
	            { "data": "stuName","orderable":false,'visible':false,},
	            { "data": "className","orderable":false,'visible':false,},
	            { "data": "applyTime","orderable":false,"render":function(data){
	            	var applyTime = data.split(' ')[0];
	            	return applyTime;
	            }},
	            { "data": "type", "orderable":false, "render":function(data){
	            	if(data=="0"){
	            		return "课假";
	            	}else{
	            		return "离校假";
	            	}
	            }},
	            { "data": "cause","orderable":false},
	            { "data": "leaveDays","orderable":false},
	            { "data": "leaveTime","orderable":false,"render":function(data){
	            	var leaveTime = data.split(' ')[0];
	            	return leaveTime;
	            }},
	            { "data": "comeTime","orderable":false,'visible':false},
	            { "data": "status","orderable":false,"render":function(data){
	            	if(data=="0"){
	            		return "未审批";
	            	}else if(data=="1"){
	            		return "审批通过";
	            	}else if(data=="2"){
	            		return "审批不通过";
	            	}else if(data=="3"){
	            		return "已销假";
	            	}
	            }},
	            {
	            	"data":"leaveId",
	            	"render":function(data,b,c){
	            		var status='';
	            		if(c.status=='1'){
	            			status="<a href='#' onclick='cancelLeave(this,"+data+")'>销假</a> &nbsp;";
	            		}
	            		return "<a href='leaveDetail.html?leaveId="+data+"'>查看详情</a> &nbsp;"+status;
	            	},
	            	"orderable":false
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getLeaveInfo",
			type:"POST",
			dataType:"json"
		},
		"columns":colums
	});
	leaveMgTable = $('#leaveMgTable').DataTable(tableSettings);
	
	$("#checkAll").on("click", function () {
        if ($(this).prop("checked") === true) {
            $("input[name='checkList']").prop("checked", $(this).prop("checked"));
        } else {
            $("input[name='checkList']").prop("checked", false);
        }
    });
}
function cancelLeave(event,data){
	console.log(data);
	$('table').prepend('<form><input type="hidden" name="leaveId" value="'+data+'"></form>')
	$.ajax({
		url:'/cms/updateLeaveInfo',
		type:'post',
		data:$('form').serialize(),
		success:function(){
			layer.msg('销假成功');
			setTimeout(function(){
				location.reload();
			},3000);
		}
	});
	
}