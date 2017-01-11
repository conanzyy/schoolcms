var leaveMgTable;
$(document).ready(function() {
	loadTables();
	$('.btn-pass').click(function(){
		$.ajax({
			url:'/cms/updateTeaLeaveInfo',
			type:'post',
			data:{'leaveId':$('input[type="hidden"]').val(),'audit':'1'},
			success:function(msg){
				if(msg.rtnCode=='0'){
					layer.msg('审批成功');
				}else{
					layer.msg('销假失败');
				}
				
			}
		});
	});
	$('.btn-nopass').click(function(){
		$.ajax({
			url:'/cms/updateTeaLeaveInfo',
			type:'post',
			data:{'leaveId':$('input[type="hidden"]').val(),'audit':'2'},
			success:function(msg){
				if(msg.rtnCode=='0'){
					layer.msg('审批成功');
				}else{
					layer.msg('销假失败');
				}
				
			}
		});
	});
	
	$('#checkAll').on('click',function(e){
		$('input[name="detail"]').prop('checked',$(this).prop('checked'));
	})
	
	$('.delete').on('click',function(){
		var leaveId = [];
		$('input[class="check"]:checked').map(function(){
			var id = $(this).attr('data-leaveId');
			leaveId.push(id);
		});
		$.ajax({
			url		 : "/cms/deleteTeaLeaveAll",
			type	 : "POST",
			dataType : "json",
			contentType:"application/json",
			data	 : JSON.stringify({'leaveIds':leaveId}),
			success	 :function(msg){
				if(msg.rtnCode == '0'){
					layer.msg('删除成功');
					setTimeout(function(){
						location.reload();
					},3000);
				}else{
					layer.msg('删除失败');
				}
			}
		})
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
	            { "data":"leaveId",
	            	'orderable': false , 
	            	'render':function(a){ return '<input type="checkbox" name="detail" class="check" data-leaveId="'+a+'"/>'; },'width': '5%'
	            },
	            { "data": "leaveId","render":function(){
	            	++n;
	            	return n;
	            }},
	            { "data": "stuName","orderable":false},
	            { "data": "stuNum","orderable":false,'visible':false},
	            { "data": "className","orderable":false,'visible':false},
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
	            { "data": "status" , "orderable":false, "render": function(data){
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
	            		var deal='';
	            		if(c.status=='0'){
	            			deal="<a href='#myModal' data-toggle='modal' data-target='#myModal' onclick='hide("+data+")'>审批</a> &nbsp;&nbsp;";
	            		}
	            		return "<a href='leaveDetail.html?leaveId="+data+"'>查看详情</a> &nbsp;&nbsp;"+
	            		deal+"<a href='#'>打印</a> &nbsp;";
	            		
	            	},
	            	"orderable":false
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getTeaLeaveList",
			type:"POST",
			dataType:"json"
		},
		"columns":colums
	});
	leaveMgTable = $('#leaveMgTable').DataTable(tableSettings);
}

function hide(data){
	$('input[type="hidden"]').val(data);
}