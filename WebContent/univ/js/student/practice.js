var practiceTable;
$(document).ready(function () {
  loadTables();
  $('#form').bootstrapValidator(valid);
  $('input').focus(function () {
    $('.button-submit').removeAttr('disabled');
  });
  $('.btn-self1').click(function(){
	  $('input[type="hidden"]').remove();
  });
  $('button[type="button"]').click(function () {
    $('#form').data('bootstrapValidator').resetForm(true);
    $('.modal-footer').show();
    $('input[type="text"]').removeAttr('readonly','readonly');
  });
  $('.button-submit').click(function () {
    if ($('input[type="text"]').val() == '') {
    } else {
    	if($('input[type="hidden"]').val()==undefined){
          $.ajax({
	          type: 'POST',
	          url: '/cms/createPractice',
	          async: false,
	          data: $('#form').serialize(),
	          success: function (data) {
	            if (data.rtnCode == '0') {
	              location.reload();
	            }
	          }
          })    		
    	}else{
    		$.ajax({
  	          type: 'POST',
  	          url: '/cms/updatePractice',
  	          async: false,
  	          data: $('#form').serialize(),
  	          success: function (data) {
	            if (data.rtnCode == '0') {
	              location.reload();
	            }
	          }
            })
    	}
    }
  })
});
function loadTables() {
  if (practiceTable != null) {
    practiceTable.clear();
    practiceTable.destroy();
    practiceTable = null;
  }
  var id,n=0;
  var colums = [
    {
      'data': 'checkbox',
      'render': function (value) {
        return '<input type="checkbox" name="checkList">';
      },
      'orderable': false
    },
    {
      'data': 'practiceId',
      'render': function(){
    	  ++n;
    	  return n;
      }
    },
    {
      'data': 'emType',
      'orderable': false
    },
    {
      'data': 'workCompany',
      'orderable': false
    },
    {
      'data': 'companyNature',
      'orderable': false
    },
    {
      'data': 'status',
      'visible': false
    },
    {
      'data': 'workPhone',
      'visible': false
    },
    {
      'data': 'superName',
      'orderable': false
    },
    {
      'data': 'superPhone',
      'visible': false
    },
    {
      'data': 'workAddress',
      'visible':false
    },
    {
      'data': 'practiceRecord',
      'orderable': false
    },
    {
      'data': 'practiceId',
      'render': function (practiceId) {
        return '<a href="practiceDetail.html?practiceId='+practiceId+'">查看详情</a> &nbsp;' +
        '<a onclick="editInfo(this,'+practiceId+')" data-toggle="modal" href="#myModal"  data-target="#myModal">编辑</a> &nbsp;' +
        '<a href="#">打印</a>';
      },
      'orderable': false
    }
  ];
  var tableSettings = $.fn.fnSetTableSettings({
    ajax: {
      url: '/cms/getPracticeList',
      type: 'POST',
      dataType: 'json'
    },
    'columns': colums
  });
  practiceTable = $('#practiceTable').DataTable(tableSettings);
  $('#checkAll').on('click', function () {
    if ($(this).prop('checked') === true) {
      $('input[name="checkList"]').prop('checked', $(this).prop('checked'));
    } else {
      $('input[name="checkList"]').prop('checked', false);
    }
  });
}
function getDetail(el,data) {
	$('.modal-footer').hide();
	$.ajax({
	  url: '/cms/getPracticeInfo',
	  type: 'post',
	  data: {
	     'practiceId': data
	  },
	  dataType: 'json',
	  success: function (msg) {
		if(msg.rtnCode=='0'){
			for(var i in msg.data){
				$("input[name="+i+"]").val(msg.data[i]);
			}
		}
	}
  });
}

function editInfo(el,data) {
  if($('input[type="hidden"]').val()==undefined){
	  $('#form').prepend('<input type="hidden" name="practiceId">');
  }
  $.ajax({
	  url: '/cms/getPracticeInfo',
	  type: 'post',
	  data: {
	     'practiceId': data
	  },
	  dataType: 'json',
	  success: function (msg) {
		if(msg.rtnCode=='0'){
			for(var i in msg.data){
				$("input[name="+i+"]").val(msg.data[i]);
			}
			$('input[type="hidden"]').val(data);
		}
	}
  });
}
var valid = {
  message: 'This value is not valid',
  feedbackIcons: {
    valid: 'glyphicon glyphicon-ok',
    invalid: 'glyphicon glyphicon-remove',
    validating: 'glyphicon glyphicon-refresh'
  },
  fields: {
    emType: {
      validators: {
        notEmpty: {
          message: '就业类别不能为空'
        },
        regexp: {
          regexp: /^[\u4e00-\u9fa5]*$/,
          message: '就业类别只能是汉字'
        }
      }
    },
    workCompany: {
      validators: {
        notEmpty: {
          message: '工作(升学)单位名称不能为空'
        }
      }
    },
    companyNature: {
      validators: {
        notEmpty: {
          message: '单位性质不能为空'
        }
      }
    },
    workPhone: {
      validators: {
        notEmpty: {
          message: '单位电话不能为空'
        },
        regexp: {
          regexp: /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/,
          message: '电话号码格式错误'
        }
      }
    },
    superName: {
      validators: {
        notEmpty: {
          message: '部门主管姓名不能为空'
        }
      }
    },
    superPhone: {
      validators: {
        notEmpty: {
          message: '主管电话不能为空'
        },
        regexp: {
          regexp: /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/,
          message: '电话号码格式错误'
        }
      }
    },
    workAddress: {
      validators: {
        notEmpty: {
          message: '单位地址不能为空'
        }
      }
    },
    practiceRecord: {
      validators: {
        notEmpty: {
          message: '实习诚信记录不能为空'
        }
      }
    }
  }
};


