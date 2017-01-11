$(document).ready(function() {
	
	loadStudentInfo();

	$('#change').click(function(){
		if(!valid()){
			
		}else{
			$.ajax({
				url:'/cms/updateStudentInfo',
				type:'post',
				data:$('#studentform').serialize(),
				success:function(data){
					if(data.rtnCode=='0'){
						layer.msg('修改成功');
						setTimeout(function(){
							location.reload();
						},3000);	
					}else{
						layer.msg('修改失败');
						setTimeout(function(){
							location.reload();
						},3000);
					}
							
				}
			})
		}
	})
} );

function loadStudentInfo(){
	$.ajax({
		url:"/cms/getStudentInfo",
		type:"post",
		dataType:"json",
		success:function(studentInfo){
			if(studentInfo.rtnCode=="0"){
				for(var i in studentInfo.studentInfo){
					if(i=='sex'){
						if(studentInfo.studentInfo[i]=="1"){
							$('#man').attr("checked",true);
						}else{
							$('#women').attr("checked",true);
						}
						continue;
					}
					if(i=="dateBirth"){
						var dataBirth=studentInfo.studentInfo[i].split(' ');
						$("#birth").val(dataBirth[0]);
						continue;
					}
					if(i=="enterTime"){
						var enterTime=studentInfo.studentInfo[i].split(' ');
						$("#in-school").val(enterTime[0]);
						continue;
					}
					if(i=='studentType'){
						if(studentInfo.studentInfo[i]=="1"){
							$('#city').attr("checked",true);
						}else{
							$('#rural').attr("checked",true);
						}
						continue;
					}
					if(i=='oneChild'){
						if(studentInfo.studentInfo[i]=="1"){
							$('#oneChildrenYse').attr("checked",true);
						}else{
							$('#oneChildrenNo').attr("checked",true);
						}
						continue;
					}
					if(i=='medical'){
						if(studentInfo.studentInfo[i]=="1"){
							$('#medicalYse').attr("checked",true);
						}else{
							$('#medicalNo').attr("checked",true);
						}
						continue;
					}
					if(i=='prizeInfo'){
						$('#prizeInfo').html(studentInfo.studentInfo[i]);
					}
					if(i=='collegeId'||i=='departId'||i=='proId'||i=='classId'){
						$('form').prepend("<input type='hidden' name='"+i+"' value='"+studentInfo.studentInfo[i]+"'>");
					}
					$('input[name='+i+']').val(studentInfo.studentInfo[i]);
				}
			}else{
					layer.msg('未获取到学生信息');
				}
			}
	});
}

function valid(){
	if(!(/^1[34578]\d{9}$/.test($('#phone').val()))){
		layer.msg('手机格式不对');
		return false;
	}
	if(!(/^1[34578]\d{9}$/.test($('#familyPhone1').val()))){
		layer.msg('家庭成员一手机格式不对');
		return false;
	}
	if($('#familyPhone2').val()){
		if(!(/^1[34578]\d{9}$/.test($('#familyPhone2').val()))){
			layer.msg('家庭成员二手机格式不对');
			return false;
		}
	}
	if(!(/^[1-9][0-9]{5}$/.test($('#familyZipCode1').val()))){
		layer.msg('家庭成员一邮编不正确');
		return false;
	}
	if($('#familyZipCode2').val()){
		if(!(/^[1-9][0-9]{5}$/.test($('#familyZipCode2').val()))){
			layer.msg('家庭成员二邮编不正确');
			return false;
		}
	}
	
	return true;
}


