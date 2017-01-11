(function($){
    $.fn.extend({

    //pass the options variable to the function
    accordion: function(options) {
        
		var defaults = {
			accordion: 'true',
			speed: 300,
			closedSign: 'glyphicon glyphicon-triangle-left',
			openedSign: 'glyphicon glyphicon-triangle-bottom'
		};

		// Extend our default options with those provided.
		var opts = $.extend(defaults, options);
		//Assign current element to variable, in this case is UL element
 		var $this = $(this);
 		
 		//增加箭头图标
 		$this.find("li").each(function() {
 			if($(this).find("ul").length != 0){
 				//add the multilevel sign next to the link
 				$(this).find("a:first").append("<span></span>").find("span:first").addClass(opts.closedSign);
 				
 				//avoid jumping to the top of the page when the href is an #
 				if($(this).find("a:first").attr('href') == "#"){
 		  			$(this).find("a:first").click(function(){return false;});
 		  		}
 			}
 		});

 		//open active level
 		$this.find("li.active").each(function() {
 			$(this).parents("ul").slideDown(opts.speed);
 			$(this).parent("li").find("span:first").removeClass();
 			$(this).parents("ul").parent("li").find("span:first").addClass(opts.openedSign);
 		});

  		$this.find("li a").click(function() {
  			if($(this).parent().find("ul").length != 0){
  				if(opts.accordion){
  					//Do nothing when the list is open
  					if(!$(this).parent().find("ul").is(':visible')){
  						parents = $(this).parent().parents("ul");
  						visible = $this.find("ul:visible");
  						visible.each(function(visibleIndex){
  							var close = true;
  							parents.each(function(parentIndex){
  								if(parents[parentIndex] == visible[visibleIndex]){
  									close = false;
  									return false;
  								}
  							});
  							if(close){
  								if($(this).parent().find("ul") != visible[visibleIndex]){
  									$(visible[visibleIndex]).slideUp(opts.speed, function(){
  										$(this).parent("li").find("span:first").removeClass();
  										$(this).parent("li").find("span:first").addClass(opts.closedSign);
  									});
  									
  								}
  							}
  						});
  					}
  				}
  				if($(this).parent().find("ul:first").is(":visible")){
  					$(this).parent().find("ul:first").slideUp(opts.speed, function(){
  						$(this).parent("li").find("a:first").removeClass("active");
  						$(this).parent("li").find("span:first").removeClass();
  						$(this).parent("li").find("span:first").delay(opts.speed).addClass(opts.closedSign);
  					});
  					
  					
  				}else{
  					$(this).parent().find("ul:first").slideDown(opts.speed, function(){
  						$(this).parent("li").find("a:first").addClass("active");
  						$(this).parent("li").find("span:first").removeClass();
  						$(this).parent("li").find("span:first").delay(opts.speed).addClass(opts.openedSign);
  					});
  				}
  			}else{
  				var path=$(this).parent().find("a").data("path");
  				$("#rightContent").attr("src",path);
  				//操作保存到浏览器缓存
  				$.cookie("lastVisitNew",path,{expire:3,path:"/"});
  				//保存到本地缓存
  				if(window.localStorage)
  				{
  					localStorage.localStorage=path;
  				}
  			}
  		});
    }
});
})(jQuery);