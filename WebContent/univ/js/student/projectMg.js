var projectMgTable;
var rows_selected;//选中的行的数据
$(document).ready(function() {
	loadTables();
} );


function loadTables(){
	
	if(projectMgTable !=null){
		projectMgTable.clear();
		projectMgTable.destroy();
		projectMgTable=null;
	}
	var id;
	 var colums=[
	            { "data":"checkbox",
	              "render":function(value){
	            		return "<input type='checkbox' name='checkList'>";
	            	},
	            	"orderable":false
	            },
	            { "data": "grantId"},
	            { "data": "name","orderable":false},
	            { "data": "proId","orderable":false },
	            { "data": "classId","orderable":false },
	            { "data": "grantType","orderable":false},
	            { "data": "applyTime","orderable":false},
	            { "data": "overTime","orderable":false },
	            { "data": "description","orderable":false },
	            { "data": "other","orderable":false },
	            {
	            	"data":"text",
	            	"render":function(value){
	            		return "<a href='#' onclick='apply(this)'>项目申报</a> &nbsp;";
	            	},
	            	"orderable":false
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
//		ajax:{
//			url:"/cms/getPracticeList",
//			type:"POST",
//			dataType:"json"
//		},
		"columns":colums
	});
	projectMgTable = $('#projectMgTable').DataTable(tableSettings);	
	$("#checkAll").on("click", function () {
        if ($(this).prop("checked") === true) {
            $("input[name='checkList']").prop("checked", $(this).prop("checked"));
        } else {
            $("input[name='checkList']").prop("checked", false);
        }
    });
}

function apply(){
//	$.ajax({
//		type:'POST',
//		url："/cms/",
//		data:{},
//		type:"json"
//	});
	layer.msg('申报成功');
}