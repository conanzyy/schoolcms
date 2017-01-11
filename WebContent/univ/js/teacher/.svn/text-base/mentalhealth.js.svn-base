var noticeTables;
$(document).ready(function() {

	loadTables();
	$('#checkAll').on('click', function(e) {
		$('input[name="detail"]').prop('checked', $(this).prop('checked'));
	})

	$('.delete').on('click', function() {
		var healthId = [];
		$('input[class="check"]:checked').map(function() {
			var id = $(this).attr('data-healthId');
			healthId.push(id);
		});
		$.ajax({
			url : "/cms/deleteMentalHealthAll",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify({
				'healthIds' : healthId
			}),
			success : function(msg) {
				if (msg.rtnCode == '0') {
					layer.msg('删除成功');
					setTimeout(function() {
						location.reload();
					}, 3000);
				} else {
					layer.msg('删除失败')
				}
			}
		})
	})
	$('.import').on('click', function() {
		var formData = new FormData();
//		form.enctype = "multipart/form-data";
		formData.append('file', $('#file')[0].files[0]);
		$.ajax({
			url : '/cms/importMentalHealth',
			type : 'post',
			processData : false,
			contentType : false,
			data : formData,
			success : function(msg) {
				if (msg.rtnCode == '0') {
					layer.msg('导入成功，若导入数据量过多请稍后再刷新页面。');
				} else {
					layer.msg(msg.errMsg);
				}
			}
		});
	})
});

function loadTables() {

	if (noticeTables != null) {
		noticeTables.clear();
		noticeTables.destroy();
		noticeTables = null;
	}
	var id, n = 0;
	var colums = [
			{
				'data' : 'healthId',
				'orderable' : false,
				'render' : function(a) {
					return '<input type="checkbox" name="detail" class="check" data-healthId="'
							+ a + '"/>';
				},
				'width' : '5%'
			},
			{
				"data" : "healthId",
				'orderable' : true,
				'render' : function() {
					++n;
					return n
				}
			},
			{
				"data" : "stuName",
				'orderable' : false
			},
			{
				"data" : "stuNum",
				'orderable' : false
			},
			{
				"data" : "className",
				'orderable' : false
			},
			{
				"data" : "proName",
				'orderable' : false
			},
			{
				"data" : "result",
				'orderable' : false,
				'width' : '10%'
			},
			{
				"data" : "createTime",
				'orderable' : false,
				'render' : function(a) {
					var time = a.split(' ')[0];
					return time
				},
				'width' : '10%'
			},
			{
				"data" : "way",
				'orderable' : false,
				'width' : '10%'
			},
			{
				"data" : "record",
				'orderable' : false,
				'width' : '10%'
			},
			{
				"data" : "step",
				'orderable' : false,
				'width' : '10%'
			},
			{
				'data' : 'text',
				'orderable' : false,
				'render' : function(a, b, c) {
					return '<a href="mentalhealthDetail.html?healthId='
							+ c.healthId
							+ '">查看详情</a>&nbsp;&nbsp;<a href="mentalhealthDetail.html?userId='
							+ c.healthId
							+ '&isedit='
							+ 1
							+ '">编辑</a>&nbsp;&nbsp;<a href="#" onclick="delete_this(this,'
							+ c.healthId + ')">删除</a>'
				},
				'width' : '15%'
			} ];
	var tableSettings = $.fn.fnSetTableSettings({
		ajax : {
			url : "/cms/getMentalHealthList",
			type : "POST",
			dataType : "json",
			autoWidth : "true"
		},
		"columns" : colums,
	});

	noticeTables = $('#studentList').DataTable(tableSettings);

}
function delete_this(obj, healthId) {
	$.ajax({
		url : "/cms/deleteMentalHealth",
		type : "POST",
		data : {
			'healthId' : healthId
		},
		success : function(data) {
			if (data.rtnCode == '0') {
				layer.msg('删除成功');
			} else {
				layer.msg('删除失败');
			}
		}
	})

}
