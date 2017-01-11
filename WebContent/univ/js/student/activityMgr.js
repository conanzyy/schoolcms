var activityMgTables;
var joinedActivityTables;
$(document).ready(function() {
	loadTables1();
	loadTables2();
} );


function loadTables1(){
	
	if(activityMgTables !=null){
		activityMgTables.clear();
		activityMgTables.destroy();
		activityMgTables=null;
	}
	var id;
	 var colums=[
	            { "data":"checkbox",
	              "render":function(value){
	            		return "<input type='checkbox' name='checkList'>";
	            	},
	            	"orderable":false
	            },
	            { "data": "practiceId"},
	            { "data": "emType","orderable":false},
	            { "data": "workCompany","orderable":false },
	            { "data": "companyNature","orderable":false },
	            { "data": "status","visible":false},
	            { "data": "workPhone","orderable":false},
	            { "data": "superName","orderable":false },
	            { "data": "superPhone" ,"orderable":false},
	            { "data": "workAddress" ,"orderable":false},
	            { "data": "practiceRecord" ,"orderable":false},
	            {
	            	"data":"text",
	            	"render":function(value){
	            		return "<a href='#'>查看详情</a> &nbsp;"+
	            				"<a href='#'>编辑</a> &nbsp;" +
	            				"<a href='#'>打印</a>";
	            	},
	            	"orderable":false
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
//		ajax:{
//			url:"/cms/getPracticeList",
//			type:"post",
//			dataType:"json"
//		},
		ajax:"data/project.txt",
		"columns":colums
	});
	activityMgTables = $('#activityMgTable').DataTable(tableSettings);
	$('#activityMgTables_filter').hide();
	
}

function loadTables2(){
	
	if(joinedActivityTables !=null){
		joinedActivityTables.clear();
		joinedActivityTables.destroy();
		joinedActivityTables=null;
	}
	var id;
	 var colums=[
	            { "data":"checkbox",
	              "render":function(value){
	            		return "<input type='checkbox' name='checkList'>";
	            	},
	            	"orderable":false
	            },
	            { "data": "practiceId"},
	            { "data": "emType","orderable":false},
	            { "data": "workCompany","orderable":false },
	            { "data": "companyNature","orderable":false },
	            { "data": "status","visible":false},
	            { "data": "workPhone","orderable":false},
	            { "data": "superName","orderable":false },
	            { "data": "superPhone" ,"orderable":false},
	            { "data": "workAddress" ,"orderable":false},
	            { "data": "practiceRecord" ,"orderable":false},
	            {
	            	"data":"text",
	            	"render":function(value){
	            		return "<a href='#'>查看详情</a> &nbsp;"+
	            				"<a href='#'>编辑</a> &nbsp;" +
	            				"<a href='#'>打印</a>";
	            	},
	            	"orderable":false
	            }
	        ];
	var tableSettings=$.fn.fnSetTableSettings({
		ajax:{
			url:"/cms/getPracticeList",
			type:"POST",
			dataType:"json"
		},
		"columns":colums
	});
	joinedActivityTables = $('#joinedActivityTable').DataTable(tableSettings);
	$('#joinedActivityTable_filter').hide();
	
	$("#checkAll").on("click", function () {
        if ($(this).prop("checked") === true) {
            $("input[name='checkList']").prop("checked", $(this).prop("checked"));
        } else {
            $("input[name='checkList']").prop("checked", false);
        }
    });
}