var bonusMgTable;
var rows_selected;//选中的行的数据
$(document).ready(function() {
	loadTables();
} );


function loadTables(){
	
	if(bonusMgTable !=null){
		bonusMgTable.clear();
		bonusMgTable.destroy();
		bonusMgTable=null;
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
	            {
	            	"data":"text",
	            	"render":function(value){
	            		return "<a href='#' onclick='apply(this)'>在线申报</a>";
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
	bonusMgTable = $('#bonusMgTable').DataTable(tableSettings);
	
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
//		type: 'POST',
//        url: '/cms/',
//        async: false,
//        data: $('#form').serialize(),
//        success: function (msg) {
//          if (msg.rtnCode == '0') {
//        	  layer.msg('申报成功');
//        	  location.reload();
//          }
//        }
//	})
	layer.msg('申报成功');
}
