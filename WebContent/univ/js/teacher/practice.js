var noticeTables;
$(document).ready(function() {
	
	loadTables();
	$('#checkAll').on('click',function(e){
		$('input[name="detail"]').prop('checked',$(this).prop('checked'));
	})
	$('.delete').on('click',function(){
		var practiceId = [];
		$('input[class="check"]:checked').map(function(){
			var id = $(this).attr('data-practiceId');
			practiceId.push(id);
		})
		$.ajax({
			url		 : "/cms/deletePracticeAll",
			type	 : "POST",
			dataType : "json",
			contentType:"application/json",
			data	 : JSON.stringify({'practiceIds':practiceId}),
			success	 :function(msg){
				if(msg.rtnCode == '0'){
					layer.msg('删除成功');
					setTimeout(function(){
						location.reload();
					},3000);
				}else{
					layer.msg('删除失败')
				}
			}
		})
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
		 		{ 'data': 'practiceId'		,'orderable': false , 'render':function(a){ return '<input type="checkbox" name="detail" class="check" data-practiceId="'+a+'"/>'; },'width': '5%'	},
		 		{ "data": "practiceId"		,'orderable': true	, 'render':function(){ ++n ;return n }},
		 		{ "data": "stuName" 		,'orderable': false	},
	            { "data": "stuNum"			,'orderable': false	},
	            { "data": "className" 		,'orderable': false	},
	            { "data": "proName"  		,'orderable': false },
	            { 'data': 'emType'			,'orderable': false },
	            { 'data': 'workCompany'		,'orderable': false },
	            { 'data': 'companyNature'	,'orderable': false },
	            { 'data': 'workAddress'		,'orderable': false },
	            { 'data': 'workPhone'		,'orderable': false ,'width':'10%'},
	            { 'data': 'workPhone'		,'orderable': false ,'render':function(a){ return '<img src="'+a+'">'}},
	            { 'data': 'text'			,'orderable': false , 'render':function(a,b,c){ return '<a href="practiceDetail.html?userId='+c.practiceId+'">查看详情</a>'} }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url		 : "/cms/getTPracticeList",
			type	 : "POST",
			dataType : "json",
			autoWidth: "true"
		},
		"columns":colums,
	});
	
	noticeTables = $('#studentList').DataTable(tableSettings);
}
