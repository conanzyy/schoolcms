(function($){      
$.fn.extend({      
	getCookie:function(name){
		var arr=document.cookie.match(new RegExp("(^|)"+name+"=([^;]*)(;|$)"));
		if(arr!=null)
		{
			return unescape(arr[2]);
		}
		else
		{
			return "";
		}
	},
    
	delCookie:function(name){
		var exp = new Date();
		exp.setTime(exp.getTime()-1);
		var cval=$.fn.getCookie(name);
		if(cval!=null)
		{
			document.cookie=name+"="+cval+";expires="+exp.toGMTString();
		}
		
	},
	
	setCookie:function(name,value,expiredays){
		if(expiredays)
		{
			var exdate =new Date();
			exdate.setDate(exdate.getDate()+expiredays);
			document.cookie=name+"="+escape(value) +(expiredays?"":";expires="+exdate.toGMTString());
		}
		else
		{
			document.cookie=name+"="+escape(value)+";";
		}
	}
})      
})(jQuery);  