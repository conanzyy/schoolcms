$(document).ready(function() {
	$.ajax({
		url : "/cms/getIndexNoticeList",
		type : "POST",
		dataType : "json",
		success : function(dataObj) {
			getNoticeListData(dataObj);
		}
	})
})
/**
 * 获取通知列表的信息
 * @param data
 */
function getNoticeListData(dataObj) {
	var temp;
	var data = dataObj.data;
	for (var i = 0; i < data.length; i++) {
		if(i==0){
			var titleName = data[0].title;
			var createTime = data[0].createTime;
			temp = "<a><li><span class='col-md-9 col-sm-9 col-xs-9 first_li'>"
					+ titleName
					+ "</span>"
					+ "<em class='col-md-3 col-sm-3 col-xs-3 '>"
					+ createTime
					+ "</em></li></a>";	
		}else{
			var titleName = data[i].title;
			var createTime = data[i].createTime;
			temp = "<a><li><span class='col-md-9 col-sm-9 col-xs-9'>"
				+ titleName
				+ "</span>"
				+ "<em class='col-md-3 col-sm-3 col-xs-3'>"
				+ createTime
				+ "</em></li></a>";
		}
		$("#noticeUL").append(temp);
	}
}