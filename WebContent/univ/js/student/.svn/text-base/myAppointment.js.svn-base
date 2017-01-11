var myAppointTables;
$(document).ready(function() {
	loadTables();
} );

function loadTables(){
	
	if(myAppointTables !=null){
		myAppointTables.clear();
		myAppointTables.destroy();
		myAppointTables=null;
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
	            { "data": "appointId" ,"visible":false},
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
	            { "data": "i" },
	            { "data": "ige" },
	            { "data": "operate",
	              "render":function(value){
            		return '<a href="#">取消预约</a>';
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
	
	myAppointTables = $('#myAppointTable').DataTable(tableSettings);
}