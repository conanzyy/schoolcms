var noticeTables;
$(document).ready(function() {
	
	loadTables();
	$('thead').remove();
	$('#form').bootstrapValidator(valid);
	$('input').focus(function () {
		$('.button-submit').removeAttr('disabled');
	});
	$('button[type="button"]').click(function () {
		$('#form').data('bootstrapValidator').resetForm(true);
		$('.modal-footer').show();
		$('input[type="text"]').removeAttr('readonly','readonly');
	});
	$('.button-submit').click(function () {
		var data = $('#form').serialize();
		if(data){
			$.ajax({
				type:'POST',
				url: '/cms/createNotice',
				async: false,
				data: data,
				success: function(datas){
					if(datas.rtnCode == '0'){
						location.reload();
					}
				}
			})
		}
	})
} );


function loadTables(){
	
	if(noticeTables !=null){
		noticeTables.clear();
		noticeTables.destroy();
		noticeTables=null;
	}
	var id;
	 var colums=[
	            { "data": "title",
            	"render":function(a,b,c){
            		$('.txt-l').css('cssText','text-align:left !important');
            			return '<a href="noticeContent.html?id='+c.noticeId+'">'+c.title+'</a>';
            		},
	            	'orderable': false,
	            	className:'txt-l',
            	},
            	{ "data": "createTime" , className:'createTime','orderable': false,"render":function(data){
	            	$('.createTime').css('cssText','text-align:right !important');
	            	var createTime=data.split(" ")[0];
	            	return createTime;
	            }}
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getTNoticeList",
			type:"POST",
			dataType:"json",
			autoWidth:"true"
		},
		"columns":colums,
	});
	noticeTables = $('#noticeTable').DataTable(tableSettings);

	$("#noticeTable_filter").append("<a id='createnotices' class='btn btn-default btn-insight' tabindex='0' data-toggle='modal' data-target='#myModal'><span>发布公告通知</span></a>")
	$('#noticeTable_filter label').hide();	
}
var valid = {
		  message: 'This value is not valid',
		  feedbackIcons: {
		    valid: 'glyphicon glyphicon-ok',
		    invalid: 'glyphicon glyphicon-remove',
		    validating: 'glyphicon glyphicon-refresh'
		  },
		  fields: {
		    title: {
		      validators: {
		        notEmpty: {
		          message: '标题不能为空'
		        }
		      }
		    },
		    content: {
		      validators: {
		        notEmpty: {
		          message: '内容不能为空'
		        }
		      }
		    }
		  }
		};



