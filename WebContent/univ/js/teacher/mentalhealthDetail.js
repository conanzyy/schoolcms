$(document).ready(function() {

	var otherData = window.location.href.split("?")[1];
	console.log(otherData);
	var index =  otherData.indexOf('&');
	if(index == '-1'){
		var id = window.location.href.split('=')[1];
	}else{
		var id 	   = otherData.split('&')[0].split('=')[1];
		var isedit = otherData.split('&')[1].split('=')[1];
	}
	loadStudentInfo(id);
	if(!isedit){
		$('input').attr('readonly','readonly');
		$('#change').css('display','none');
	}
	$('#change').click(function(){
		$.ajax({
			url:'/cms/updateMentalHealth',
			type:'post',
			data:$('form').serialize(),
			success:function(data){
				console.log(data);
				if(data.rtnCode=='0'){
					layer.msg('修改成功');
					setTimeout(function(){
						location.reload();
					},3000);	
				}else{
					layer.msg('修改失败');
				}	
			}
		})
	})
} );

function loadStudentInfo(id){
	$('form').prepend('<input type="hidden" name="healthId" value="'+id+'">');
	$.ajax({
		url:"/cms/getMentalHealthInfo",
		type:"post",
		data: $('form').serialize(),
		success:function(data){
			if(data.rtnCode=="0"){
				for(var i in data.data){
					if( i == 'createTime'){
						var time = data.data[i].split(' ')[0];
						$('input[name='+i+']').val(time);
						continue;
					}
					if(i == 'record'){
						$('textarea[name='+i+']').val(data.data[i]);
						continue;
					}
					$('input[name='+i+']').val(data.data[i]);
				}
			}else{
					layer.msg('未获取到学生信息');
			}
		}
	});
}

