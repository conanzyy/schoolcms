var dataCountTables;
$(document).ready(function() {
	loadTables();
} );
function loadTables(){
	
	if(dataCountTables !=null){
		dataCountTables.clear();
		dataCountTables.destroy();
		dataCountTables=null;
	}
	
	 var colums=[
	            { "data": "id" ,"visible":false},
	            { "data": "roleName" },
	            { "data": "status" },
	            { "data": "createTime" },
	            { "data": "createBy" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName" },
	            { "data": "roleName",
            	  "render":function(value){
            		return '<a href="#">查看汇总数据详情</a>';
            	  },
            	  "className":'dt-body-center',
            	  "orderable":false,
	              "searchable":false
	            }
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
	
	dataCountTables = $('#dataCountTable').DataTable(tableSettings);
	drawPie('pie_1','事务统计报表',[{name:'全院参与',y:1000},{name:'我院参与',y:750}]);
	drawPie('pie_2','活动统计报表',[{name:'全院参与',y:1000},{name:'我院参与',y:750}]);
	drawPie('pie_3','学生成绩统计报表',[{name:'良好',y:60},{name:'优秀',y:10},{name:'及格',y:25},{name:'不及格',y:5}]);
}

function drawPie(area,title,graph_data)
{
	$("#"+area).highcharts({
		colors:['#6eb3dc','#7acfae','#d95ed2','#eebf78','#8ead96',"#f2aeb9",'#5dbbc5','#d5a8c9','#c5998e'],
		chart:{
			plotBackgroundColor:null,
			plotBorderWidth:null,
			plotShadow:false,
			type:'pie'
		},
		credits:{
			enabled:false
		},
		exporting:{
			enabled:false
		},
		title:{
			text:""
		},
		tooltip:{
			pointFormat:'<b>{series.name}</b>:<br/>{point.percentage:.1f}%<br/>({point.y:,.0f}名)'
		},
		legend:{
			enabled:true,
			floating:true,
			verticalAlign:'bottom',
			y:10,
			align:'center',
			itemStyle:{
				fontFamily:'微软雅黑',
				fontWeight:'normal'
			}
		},
		plotOptions:{
			pie:{
				size:120,
				innerSize:'80%',
				allowPointSelect:true,
				showInLegend:true,
				center:['50%','35%'],
				cursor:'pointer',
				dataLables:{
					enabled:true,
					format:'{point.name}:{point.percentage:.1f}%<br/>({point.y:,.0f}名)',
					style:{
						color:'#666',
						fontSize:'9px',
						fontWeight:'normal',
						fontFamily:'微软雅黑'
					}
				}
			}
		},
		series:[{
			name:'比例',
			colorByPoint:true,
			data:graph_data
		}]
	})
}

function percentage(arrayobj,size){
	for(var idx in arrayobj)
	{
		arrayobj[idx].y=arrayobj[idx].y*1.0/size
	}
	return arrayobj;
}