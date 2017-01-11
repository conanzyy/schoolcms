var roleTables;
var rows_selected;//选中的行的数据
$(document).ready(function() {
	
	loadTables();
} );


function loadTables(){
	
	if(roleTables !=null){
		roleTables.clear();
		roleTables.destroy();
		roleTables=null;
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
	            { "data": "roleId" ,"visible":false},
	            { "data": "roleName" },
	            { "data": "status" },
	            { "data": "createTime" },
	            { "data": "createBy" }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getRoleList",
			type:"POST",
			dataType:"json"
		},
		"columns":colums
	});
	
	roleTables = $('#roleTable').DataTable(tableSettings);
	//追加三个个按钮到表格
	$(".dataTables_wrapper").prepend("<a id='delRoles' class='btn btn-default btn-insight disabled' tabindex='0'><span onclick='delPowerTree()'>删除角色</span></a>")
	$(".dataTables_wrapper").prepend("<a id='editRoles' class='btn btn-default btn-insight disabled' tabindex='0'><span onclick='editPowerTree()'>编辑角色</span></a>")
	$(".dataTables_wrapper").prepend("<a id='createRoles' class='btn btn-default btn-insight' tabindex='0'><span onclick='createPowerTree(this)'>创建角色</span></a>")
	
	$('#roleTable tbody').on( 'click', 'input[type="checkbox"]', function(){
		 //清空数据
		 rows_selected={}
		 //选中的行
		 var $row=$(this).closest('tr');
	     rows_selected=roleTables.row($row).data();
	     //只保持一个被选中
	     $("input[type='checkbox']").not(this).prop("checked",false);
	     
	     var $notRaw=$("input[type='checkbox']").not(this).closest('tr');
	     $notRaw.removeClass('selected');
	     if(this.checked)
	     {
	    	 $row.addClass('selected');
	    	 $('#delRoles').removeClass('disabled');
	    	 $('#editRoles').removeClass('disabled');
	     }
	     else
	     {
	    	 $row.removeClass('selected');
	    	 $('#delRoles').addClass('disabled');
	    	 $('#editRoles').addClass('disabled');
	     }
        
	 });
}

//更新
function editPowerTree(obj)
{
	var operaName="editPower";
	getTreeList(operaName);
	
}
//创建
function createPowerTree(obj)
{
	var operaName="createPower";
	getTreeList(operaName);
}
//删除
function delPowerTree()
{
	$('#execAlertContent').html("确认删除选中的角色吗？");
	$('#execAlert').modal("show");
}

function delSubmitBtn()
{
	var obj={
			"roleId":rows_selected.roleId
	};
	$.ajax({
		url:"/cms/deleteRole",
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
function submitBtn()
{
	if($('#sub_Btn').data("acion")=="editPower")
	{
		var roleName=$("input[type='text']").val();
		var authIds=getCheckedNodes();
		var roleId=rows_selected.roleId;
		var obj={
				"roleName":roleName,
				"authIds":authIds,
				"roleId":roleId
		}
		$.ajax({
			url:"/cms/updateRole",
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
	else
	{
		var roleName=$("input[type='text']").val();
		var authIds=getCheckedNodes();
		var obj={
				"roleName":roleName,
				"authIds":authIds
		}
		$.ajax({
			url:"/cms/createRole",
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

//获取权限列表数据
function getTreeList(action)
{
	$.ajax({
		url:"/cms/getAuthIds",
		type:"POST",
		dataType:"json",
		success:function(data, textStatus){
			$("input[type='text']").val("");
			if(action == "editPower")
			{	
				var roleName=rows_selected.roleName;
				$("input[type='text']").val(roleName);
			}
			loadPowerTree(data.authIds,action);
			$('#sub_Btn').data("acion",action);
			$("#myjsTree").modal('show');
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	})
}
//加载树列表
function loadPowerTree(dataTree,action){
	$.jstree.destroy(true);
	var config = {
			"core" : {
			    'data' :dataTree
			 },
			"checkbox" : {
		      "keep_selected_style" : false,
		      "tie_selection":false
		    },
		    "plugins" : [ "wholerow","checkbox" ]
	};
	
	var jsTreePower = $('#jsTreePower').jstree(config);
	
	jsTreePower.on("loaded.jstree",function(e,data){
		//默认展开所有节点
		$('#jsTreePower').jstree().open_all();
		//如果是编辑按钮，必须再去请求一次
		if(action == "editPower")
		{
			var obj = {
					"roleId":rows_selected.roleId,
			}
			$.ajax({
				url:"/cms/getRoleInfo",
				type:"POST",
				data:JSON.stringify(obj),
				dataType:"json",
				contentType: "application/json",
				success:function(data, textStatus)
				{
					//0表示增加成功
					if(data.rtnCode == "0")
					{
						$('#jsTreePower').jstree(true).check_node(data.roleInfo.authIds);
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown)
				{
					
				}
			})
		}
	});
}

function getCheckedNodes(){
	
	var nodes=$('#jsTreePower').jstree().get_checked();
	return nodes;
}