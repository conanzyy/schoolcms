var scheduleTables;
$(document).ready(function() {
	loadTables();
} );

function loadTables(){
	
	if(scheduleTables !=null){
		scheduleTables.clear();
		scheduleTables.destroy();
		scheduleTables=null;
	}
	
	 var colums=[
	            { "data":"checkbox",
	              "render":function(value){
	            		return "<input type='checkbox'>";
	            	},
	            	"className":'dt-body-center',
	            	"orderable":false,
	            	"searchable":false,
	            	"width":"5%"
	            },
	            { "data": "scheduleId" ,"visible":false},
	            { "data": null,
	                "width":"8%",
	                "className":'dt-body-center',
	                "orderable":false,
	                "searchable":false},
	            { "data": "stuName" },
	            { "data": "teaName" },
	            { "data": "consultingArea" },
	            { "data": "problemDesc" },
	            { "data": "consultTime" },
	            { "data": "status" },
	            { "data": "cancleRemark" },
	            { "data": "operate",
	              "render":function(value){
            		return '<a href="#">查看档期</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="cancelSche()">取消档期</a>';
            	  },
            	  "className":'dt-body-center',
            	  "orderable":false,
	              "searchable":false,
	              "width":"20%"
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getOrderScheduleList",
			type:"POST",
			dataType:"json"
		},
		"columns":colums,
		"lengthChange":false,
		"searching":false,
		"fnDrawCallback": function(){
			this.api().column(2).nodes().each(function(cell, i){
				cell.innerHTML =  i + 1;
	        });
	     }
	});
	
	scheduleTables = $('#scheduleTable').DataTable(tableSettings);
	//追加三个个按钮到表格
	$(".dataTables_paginate").before("<a id='selectBtn' class='btn btn-default btn-insight' style='margin-top:15px;' tabindex='0'><span onclick='selAll()'>全选</span></a>")
	$(".dataTables_paginate").before("<a id='delBtn' class='btn btn-default btn-insight ' style='margin-top:15px;' tabindex='0'><span onclick='delAll()'>删除</span></a>")
}

function cancelSche()
{
	$('input[type=radio]').iCheck({
	    radioClass: 'iradio_square-green',
	    increaseArea: '20%' // optional
	  });
	//$('input[type=radio]').iCheck('toggle');
	$('#execAlert').modal("show");
}

//添加档期
function addSchedule()
{
	$("#schedulePanel").modal("show");
}

function submitBtn(){
	var addBgTime = $("#addBgTime").val();
	var addEdTime = $("#addEdTime").val();
	var place = $("#place").val();
	var obj={
			"addBgTime":addBgTime,
			"addEdTime":addEdTime,
			"place":place
	};
	$.ajax({
		url:"/cms/createOrderSchedule",
		type:"POST",
		data:JSON.stringify(obj),
		dataType:"json",
		contentType: "application/json",
		success:function(data, textStatus)
		{
			//0表示增加成功
			if(data.rtnCode == "0")
			{
				loadTables();
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown)
		{
			
		}
	})
}