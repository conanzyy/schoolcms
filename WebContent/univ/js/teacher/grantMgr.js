var grantTables;
$(document).ready(function() {
	loadTables();
	
	$.ajax({
		url: '/cms/getGrantList',
		type: 'post',
		success: function(data) {
			console.log(data);
		}
	});
	$("#biuuu_button").click(function() {
		$(".top-box-body").printArea();
	});
} );

function loadTables(){
	
	if(grantTables !=null){
		grantTables.clear();
		grantTables.destroy();
		grantTables=null;
	}
	
	 var colums=[
	            { "data":"checkbox",
	              "render":function(value){
	            		return "<input type='checkbox' name='counselor'>";
	            	},
	            	"className":'dt-body-center',
	            	"orderable":false,
	            	"searchable":false,
	            	"width":"5%"
	            },
	            { "data": "counselorId" ,"visible":false},
	            { "data": null,
	                "width":"8%",
	                "className":'dt-body-center',
	                "orderable":false,
	                "searchable":false},
	            { "data": "teaNum" },
	            { "data": "teaName" },
	            { "data": "researchArea" },
	            { "data": "consultingArea" },
	            { "data": "image" },
	            { "data": "image" },
	            { "data": "image" },
	            { "data": "operate",
	              "render":function(value){
            		return '<a href="#myModal" data-toggle="modal" data-target="#myModal" >查看详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="delCounselor(this)">审核</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="delCounselor(this)">打印</a>';
            	  },
            	  "className":'dt-body-center',
            	  "orderable":false,
	              "searchable":false,
	              "width":"20%"
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
//		ajax:{
//			url:"/cms/getCounselorList",
//			type:"POST",
//			dataType:"json"
//		},
		"columns":colums,
		"lengthChange":false,
		"fnDrawCallback": function(){
			this.api().column(2).nodes().each(function(cell, i){
				cell.innerHTML =  i + 1;
	        });
	     }
	});
	
	grantTables = $('#grantTable').DataTable(tableSettings);
	//追加三个个按钮到表格
	$(".dataTables_paginate").before("<a id='selectBtn' class='btn btn-default btn-insight' style='margin-top:15px;' tabindex='0'><span onclick='selAll()'>全选</span></a>")
	$(".dataTables_paginate").before("<a id='delBtn' class='btn btn-default btn-insight ' style='margin-top:15px;' tabindex='0'><span onclick='delBatch()'>删除</span></a>")
}