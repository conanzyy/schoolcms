var appointTables;
$(document).ready(function() {
	loadTables();
} );
function loadTables(){
	
	if(appointTables !=null){
		appointTables.clear();
		appointTables.destroy();
		appointTables=null;
	}
	
	 var colums=[
	            { "data":"checkbox",
	              "render":function(value){
	            		return "<input type='checkbox'>";
	            	},
	            	"className":'dt-body-center',
	            	"orderable":false,
	            	"searchable":false
	            },
	            { "data": "id" ,"visible":false},
	            { "data": "roleName" },
	            { "data": "status" },
	            { "data": "createTime" },
	            { "data": "createBy" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName" }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
//		ajax:{
//			url:"/cms/getRoleList",
//			type:"POST",
//			dataType:"json"
//		},
		"columns":colums,
		"searching":false,
		"lengthChange":false,
		"info":false
	});
	
	appointTables = $('#appointTable').DataTable(tableSettings);
	
	$(".dataTables_paginate").before("<a id='selectBtn' class='btn btn-default btn-insight' tabindex='0'><span onclick='delPowerTree()'>全选</span></a>")
	$(".dataTables_paginate").before("<a id='delBtn' class='btn btn-default btn-insight ' tabindex='0'><span onclick='editPowerTree()'>删除</span></a>")
}
