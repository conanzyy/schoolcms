var noticeTables;
$(document).ready(function() {
	
	loadTables();
	$('#checkAll').on('click',function(e){
		$('input[name="detail"]').prop('checked',$(this).prop('checked'));
	})
	
	$('.delete').on('click',function(){
		var userId = [];
		$('input[class="check"]:checked').map(function(){
			var id = $(this).attr('data-userId');
			userId.push(id);
		})
		$.ajax({
			url		 : "/cms/delectStudentInfoAll",
			type	 : "POST",
			dataType : "json",
			contentType:"application/json", 
			data	 : JSON.stringify({'userIds':userId}),
			success	 :function(msg){
				if(msg.rtnCode == '0'){
					layer.msg('删除成功')
				}else{
					layer.msg('删除失败')
				}
			}
		})
		$('input[class="check"]:checked').parent().parent().remove();
	})
} );


function loadTables(){
	
	if(noticeTables !=null){
		noticeTables.clear();
		noticeTables.destroy();
		noticeTables=null;
	}
	var id,n=0;
	 var colums=[
		 		{ 'data': 'userId'		,'orderable': false, 'render':function(a){ return '<input type="checkbox" name="detail" class="check" data-userId="'+a+'"/>'; },'width': '5%'	},
		 		{ "data": "userId"		,'orderable': true	, 'render':function(){ ++n ;return n; }},
		 		{ "data": "stuName" 	,'orderable': false	},
		 		{ "data": "sex" 		,'orderable': false	, 'render':function(a){ if(a == '0'){ return '女' }else{ return '男' }}},
	            { "data": "dateBirth" 	,'orderable': false , 'render':function(a){ var enterTime = a.split(' ')[0]; return(enterTime)},'width': '10%'},
	            { "data": "stuNum"		,'orderable': false	},
	            { "data": "className" 	,'orderable': false	},
	            { "data": "proName"  	,'orderable': false },
	            { "data": "medical" 	,'orderable': false , 'render':function(a){ if(a == '1'){ return '是' }else{ return '否' }}},
	            { "data": "enterTime" 	,'orderable': false , 'render':function(a){ var enterTime = a.split(' ')[0]; return(enterTime);},'width': '10%'},
	            { "data": "dormitory" 	,'orderable': false	, 'render':function(a){ if(a == '1'){ return '城市' }else{ return '农村' }}},            
	            { 'data': 'text'		,'orderable': false , 'render':function(a,b,c){ return '<a href="studentInfoDetail.html?userId='+c.userId+'">查看详情</a>&nbsp;&nbsp;<a href="studentInfoDetail.html?userId='+c.userId+'&isedit='+1+'">编辑</a>&nbsp;&nbsp;<a href="#" onclick="delete_this(this,'+c.userId+')">删除</a>'},'width': '15%'}
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getStudentList",
			type:"POST",
			dataType:"json",
			autoWidth:"true"
		},
		"columns":colums,
	});
	
	noticeTables = $('#studentList').DataTable(tableSettings);

	
}
function delete_this(obj,userId){
	$('table').prepend('<form id="form"><input type="hidden" name="userId" value="'+userId+'"></form>');
	$.ajax({
		url:"/cms/delectStudentInfo",
		type:"POST",
		data:$('#form').serialize(),
		success:function(data){
			if(data.rtnCode == '0'){
				layer.msg('删除成功');
				setTimeout(function(){
  					location.reload();
  				},3000);
			}else{
				layer.msg('删除失败');
				setTimeout(function(){
  					location.reload();
  				},3000);
			}
		}
	})
	
}
