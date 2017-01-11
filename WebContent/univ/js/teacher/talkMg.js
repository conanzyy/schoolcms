var talkTables;
$(document).ready(function() {
	$('.form-group ').css('height','45px');
	loadTables();
	$('#checkAll').on('click',function(e){
		$('input[name="detail"]').prop('checked',$(this).prop('checked'));
	});
	$('.button-submit').click(function(){
		$.ajax({
			url:'/cms/createOrderRecord',
			type:'post',
			data:$('form').serialize(),
			success:function(msg){
				if(msg.rtnCode=="0"){
					layer.msg('添加成功');
				}else{
					layer.msg('添加失败');
				}
			}
		})
	});
	$('.delete').on('click',function(){
		var orderRecordId = [];
		$('input[class="check"]:checked').map(function(){
			var id = $(this).attr('data-orderRecordId');
			orderRecordId.push(id);
		});
		$.ajax({
			url		 : "/cms/deleteOrderRecordAll",
			type	 : "POST",
			dataType : "json",
			contentType:"application/json",
			data	 : JSON.stringify({'orderRecordIds':orderRecordId}),
			success	 :function(msg){
				if(msg.rtnCode == '0'){
					layer.msg('删除成功');
					setTimeout(function(){
						location.relaod(),3000
					})
				}else{
					layer.msg('删除失败')
				}
			}
		})
	})
} );


function loadTables(){
	
	if(talkTables !=null){
		talkTables.clear();
		talkTables.destroy();
		talkTables=null;
	}
	var id,n=0;
	 var colums=[
		 		{ 'data': 'orderRecordId'		,'orderable': false , 'render':function(a){ return '<input type="checkbox" name="detail" class="check" data-orderRecordId="'+a+'"/>'; },'width': '5%'	},
		 		{ "data": "orderRecordId"		,'orderable': true	, 'render':function(){ ++n ;return n }},
		 		{ "data": "stuName" 		,'orderable': false	},
	            { "data": "stuNum"			,'orderable': false	},
	            { "data": "proName"  		,'orderable': false },
	            { 'data': 'talkTime'			,'orderable': false , "render":function(data){
	            	var talkTime = data.split(" ")[0];
	            	return talkTime;
	            }},
	            { 'data': 'talkBackground'		,'orderable': false },
	            { 'data': 'prombleType'	,'orderable': false },
	            { 'data': 'talkCount'		,'orderable': false },
	            { 'data': 'talkEffect'		,'orderable': false ,'width':'10%'},
	            { 'data': 'text'			,'orderable': false , 'render':function(a,b,c){ return '<a href="talkDetail.html?RecordId='+c.orderRecordId+'">查看详情</a>'} }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url		 : "/cms/getOrderRecordList",
			type	 : "POST",
			dataType : "json"
		},
		"columns":colums,
	});
	
	talkTables = $('#talkMgTable').DataTable(tableSettings);
}
