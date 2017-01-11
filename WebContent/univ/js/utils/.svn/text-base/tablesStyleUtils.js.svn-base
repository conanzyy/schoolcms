(function($){      
$.fn.extend({      
	fnSetTableSettings:function(options){
		var defaults={
				ajax:"",
				"aaSorting":[],
				"order":[],
				"sDom":'Rfrtlip',
				"bProcessing":false,
				"pageingType":"full_numbers",
				"oLanguage": {
					 	"sProcessing": "<i class='loading'></i>正在加载中...",
					 	"sLoadingRecords":"",
			            "sLengthMenu":"每页显示 _MENU_ 条",     
			            "sZeroRecords":"表中无数据存在!", 
			            "sEmptyTable":"表中无数据存在!",
			            "sInfo":"共 _TOTAL_ 条",
			            "sSearchPlaceholder":"输入搜索",
			            "sInfoFiltered":"",
			            "sInfoEmpty":"", 
			            "sSearch":"",
			            "oPaginate": {   
			                "sFirst": "首页",     
			                "sPrevious": "上一页",     
			                "sNext": "下一页",     
			                "sLast": "末页"    
			            }     
			        },
		}
		
		var options = $.extend({},defaults, options);
		
		return options;
	}
})      
})(jQuery); 