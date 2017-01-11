var talkTables;
$(document).ready(function() {
	$('.form-group ').css('height','45px');
	loadTables();
	$('#checkAll').on('click',function(e){
		$('input[name="detail"]').prop('checked',$(this).prop('checked'));
	});
	$('.button-submit').click(function(){
		$.ajax({
			url:'/cms/updateTeaStuScoreInfo',
			type:'POST',
			data:$('form').serialize(),
			success:function(msg){
				if(msg.rtnCode=="0"){
					layer.msg('修改成功');
				}else{
					layer.msg('删除失败');
				}
			}
			
		})
	});
	$('.delete').on('click',function(){
		var scoreId = [];
		$('input[class="check"]:checked').map(function(){
			var id = $(this).attr('data-scoreId');
			scoreId.push(id);
		});
		$.ajax({
			url		 : "/cms/deleteTeaStuScoreInfoAll",
			type	 : "POST",
			dataType : "json",
			contentType:"application/json",
			data	 : JSON.stringify({'scoreIds':scoreId}),
			success	 :function(msg){
				if(msg.rtnCode == '0'){
					layer.msg('删除成功')
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
				{ 'data': 'scoreId','orderable': false , 'render':function(a){ return '<input type="checkbox" name="detail" class="check" data-scoreId="'+a+'"/>'}, 'width':'5%'},
				{ "data": "text",'orderable': true	, 'render':function(){ ++n ;return n }, 'width':'8%'},
				{ "data": "stuName" ,'orderable': false	, 'width':'8%'},
				{ "data": "stuNum",'orderable': false, 'width':'8%'},
				{ "data": "proName",'orderable': false },
				{ 'data': 'courseName','orderable': false },
				{ 'data': 'score','orderable': false },
				{ 'data': 'credit','orderable': false },
				{ 'data': 'courseType','orderable': false ,'render':function(data){
					if(data=="0"){
						return "必修";
					}else{
						return "选修";
					}
					
				}},
				{ 'data': 'teaName','orderable': false },
				{ 'data': 'semester','orderable': false },
				{ 'data': 'text','orderable': false , 'render':function(a,b,c){ 
					return '<a href="scoreDetail.html?courseId='+c.scoreId+'">查看详情</a> &nbsp;'+
					'<a data-toggle="modal" href="#myModal" data-target="#myModal" onclick="edit(this,'+c.scoreId+')">编辑</a> &nbsp;'+
					'<a href="#" onclick=delete_this(this,'+c.scoreId+')>删除</a>'
				} , 'width':'15%'} 
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url		 : "/cms/getTeaStuScoreList",
			type	 : "POST",
			dataType : "json"
		},
		"columns":colums,
	});
	
	talkTables = $('#ScoreTable').DataTable(tableSettings);
}
function edit(event,data){
	$('input[name="scoreId"]').val(data);
	$.ajax({
		url:'/cms/getTeaStuScoreInfo',
		type:'POST',
		data:{'scoreId':data},
		success:function(msg){
			if(msg.rtnCode=="0"){
				$('input[name="score"]').val(msg.studentInfo.score);
			}
			
		}
	})
}
 function delete_this(event,data){
	 $.ajax({
		 url:'/cms/deleteTeaStuScoreInfo',
		 type:'post',
		 data:{'scoreId':data},
		 success:function(msg){
			 if(msg.rtnCode=="0"){
				 layer.msg('删除成功');
			 }
			 setTimeout(function(){
				 location.reload();
			 },3000);
		 }
	 })
 }