var adviserTables;
var idList =[];//咨询师的Id
$(document).ready(function() {
	loadTables();
} );

function loadTables(){
	
	if(adviserTables !=null){
		adviserTables.clear();
		adviserTables.destroy();
		adviserTables=null;
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
	            { "data": "operate",
	              "render":function(value){
            		return '<a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="delCounselor(this)">删除</a>';
            	  },
            	  "className":'dt-body-center',
            	  "orderable":false,
	              "searchable":false
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getCounselorList",
			type:"POST",
			dataType:"json"
		},
		"columns":colums,
		"lengthChange":false,
		"fnDrawCallback": function(){
			this.api().column(2).nodes().each(function(cell, i){
				cell.innerHTML =  i + 1;
	        });
	     }
	});
	
	adviserTables = $('#adviserTable').DataTable(tableSettings);
	//追加三个个按钮到表格
	$(".dataTables_wrapper").prepend("<a id='addAdviserBtn' class='btn btn-default btn-insight tabindex='0'><span onclick='addAdviser()'>添加咨询师</span></a>")
	$(".dataTables_paginate").before("<a id='selectBtn' class='btn btn-default btn-insight' style='margin-top:15px;' tabindex='0'><span onclick='selAll()'>全选</span></a>")
	$(".dataTables_paginate").before("<a id='delBtn' class='btn btn-default btn-insight ' style='margin-top:15px;' tabindex='0'><span onclick='delBatch()'>删除</span></a>")
}

function addAdviser(){
	var fileInputSettings = $.fn.initFileInput({
		showUpload:true
	});
	$('#imageInput').fileinput(fileInputSettings);
	$("#counselorPanel").modal("show");
}

function submitBtn(){
	var teaNum = $("#teaNum").val();
	var teaName = $("#teaName").val();
	var researchArea = $("#researchArea").val();
	var consultingArea = $("#consultingArea").val();
	var image = 'aaa';
	var obj={
			"teaNum":teaNum,
			"teaName":teaName,
			"researchArea":researchArea,
			"consultingArea":consultingArea,
			"image":image		
	};
	$.ajax({
		url:"/cms/createCounselor",
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

//删除该咨询师
function delCounselor(obj)
{
	//清空数据
	idList = []
	var $row=$(obj).closest('tr');
    var rows_selected=adviserTables.row($row).data();
    var counselorId = rows_selected.counselorId;
	idList.push(counselorId);
	$('#execAlertContent').html("确认删除该咨询师吗？");
	$('#execAlert').modal("show");
}

function delSubmitBtn()
{
	if(idList.lenght>0)
	{
		var obj = {
				"counselorId":idList
		}
		$.ajax({
			url:"/cms/deleteCounselor",
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
}


//批量删除咨询师
function delBatch()
{
	//清空数据
	idList = []
	$("input[name='counselor']").each(function(){
		if($(this).prop("checked"))
		{
			var $row=$(this).closest('tr');
			var rows_selected=adviserTables.row($row).data();
			var counselorId = rows_selected.counselorId;
			idList.push(counselorId);
		}
	});
	if(idList.length > 0)
	{
		$('#execAlertContent').html("确认删除这些咨询师吗?");
	}else{
		$('#execAlertContent').html("请先选择需要删除的咨询师.");
	}
	$('#execAlert').modal("show");
}
//全选
function selAll()
{
	$("input[name='counselor']").prop("checked",true);
}
