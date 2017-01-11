var noticeTables;
$(document).ready(function() {
	loadTables();
	$('thead').remove();
} );


function loadTables(){
	
	if(noticeTables !=null){
		noticeTables.clear();
		noticeTables.destroy();
		noticeTables=null;
	}
	var id;
	 var colums=[
	            { "data": "title",className:'title8',
            	"render":function(value,b,c){
            			$('.txt-l').css('cssText','text-align:left !important');
            			return '<a href="noticeContent.html?id='+c.noticeId+'">'+value+'</a>';
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
			url:"/cms/getNoticeList",
			type:"POST",
			dataType:"json",
			autoWidth:"true"
		},
		"columns":colums,
	});
	
	noticeTables = $('#noticeTable').DataTable(tableSettings);

}

