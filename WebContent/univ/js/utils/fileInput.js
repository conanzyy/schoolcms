(function($){      
$.fn.extend({      
	initFileInput:function(options){
		var defaults={
				language: 'zh', //设置语言
		        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
		        showUpload: false, //是否显示上传按钮
		        showCaption: false,//是否显示标题
		        browseClass: "btn btn-default", //按钮样式             
		        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
		}
		
		var options = $.extend({},defaults, options);
		
		return options;
	}
})      
})(jQuery); 