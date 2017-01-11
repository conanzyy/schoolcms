var jobInfoTable;
$(document).ready(function() {
	loadTables();
	$('.button-submit').click(function() {
		$.ajax({
			url : "/cms/updateTeaJobInfo",
			type : "POST",
			data : $('form').serialize(),
			success : function(msg) {
				if (msg.rtnCode == '0') {
					layer.msg('编辑成功');
				} else {
					layer.msg('编辑失败');
				}
			}
		});
	});
	$('#checkAll').on('click', function(e) {
		$('input[name="detail"]').prop('checked', $(this).prop('checked'));
	});
	var jobId = [];
	$('.delete').on('click', function() {
		$('input[class="check"]:checked').map(function() {
			var id = $(this).attr('data-jobId');
			jobId.push(id)
		});
		$.ajax({
			url : "/cms/deleteTeaJobInfoAll",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify({
				'jobIds' : jobId
			}),
			success : function(msg) {
				if (msg.rtnCode == '0') {
					layer.msg('删除成功')
				} else {
					layer.msg('删除失败')
				}
			}
		})
	});
	$('.import').on('click', function() {
		var formData = new FormData();
		form.enctype = "multipart/form-data";
		formData.append('file', $('#file')[0].files[0]);
		$.ajax({
			url: '/cms/importTeaJob',
			type: 'post',
			processData: false,
            contentType: false,
			data: formData,
			success: function(msg) {
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

	if (jobInfoTable != null) {
		jobInfoTable.clear();
		jobInfoTable.destroy();
		jobInfoTable = null;
	}
	var id, n = 0;
	var colums = [
			{
				"data" : "jobId",
				"render" : function(data) {
					return "<input type='checkbox' name='detail' class='check' data-jobId='"
							+ data + "'>";
				},
				"orderable" : false
			},
			{
				"data" : "jobId",
				"render" : function() {
					++n;
					return n;
				}
			},
			{
				"data" : "stuName",
				"orderable" : false
			},
			{
				"data" : "proName",
				"orderable" : false
			},
			{
				"data" : "className",
				"orderable" : false
			},
			{
				"data" : "jobType",
				"orderable" : false
			},
			{
				"data" : "companyName",
				"orderable" : false
			},
			{
				"data" : "companyNature",
				"orderable" : false
			},
			{
				"data" : "address",
				"orderable" : false
			},
			{
				"data" : "phone",
				"orderable" : false
			},
			{
				"data" : "jobId",
				"render" : function(data) {
					return "<a href='jobDetail.html?jobId="
							+ data
							+ "'>查看详情</a> &nbsp;&nbsp;"
							+ "<a href='#myModal' data-toggle='modal' data-target='#myModal'onclick='edit("
							+ data + ")'>编辑</a> &nbsp;"
							+ "<a href='#' onclick='del(" + data
							+ ")'>删除</a> &nbsp;";

				},
				"orderable" : false
			} ];
	var tableSettings = $.fn.fnSetTableSettings({
		ajax : {
			url : "/cms/getTeaJobList",
			type : "POST",
			dataType : "json"
		},
		"columns" : colums
	});
	jobInfoTable = $('#jobInfoTable').DataTable(tableSettings);

}
function edit(data) {
	$('form')
			.prepend('<input type="hidden" name="jobId" value="' + data + '">');
	$.ajax({
		url : "/cms/getTeaJob",
		type : "POST",
		dataType : "json",
		data : {
			'jobId' : data
		},
		success : function(msg) {
			for ( var i in msg.data) {
				$('input[name="' + i + '"]').val(msg.data[i]);
			}
		}
	})
}

function del(data) {
	$.ajax({
		url : "/cms/deleteTeaJobInfo",
		type : "POST",
		datatype : 'json',
		data : {
			'jobId' : data
		},
		success : function(msg) {
			if (msg.rtnCode == "0") {
				layer.msg('删除成功');
			} else {
				layer.msg('删除失败');
			}
		}
	});
}