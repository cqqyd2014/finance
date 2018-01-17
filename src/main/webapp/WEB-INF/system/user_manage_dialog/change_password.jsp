<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>



<div title="重置密码" class="easyui-dialog" id='change_password_div'
	style="padding: 5px; width: 600px; height: 400px;"
	buttons="#change_password_div_buttons">
	
	<form id="change_password_form">
	<input type="hidden" id="user_id" name="user_id">
	
	
			
			<table style="width: 100%;">
			<tr>
				<td>用户</td><td><span id="user_name_span"></span></td>
			</tr>
			<tr>
				<td>请输入密码</td><td><input  class="easyui-passwordbox" style="width:150px;" id='new_password1' name='new_password1'/></td>
			</tr>
			<tr>
				<td>请确认密码</td><td><input  class="easyui-passwordbox" style="width:150px;" id='new_password2' name='new_password2'/></td>
			</tr>
			</table>
			

		
	</form>
</div>

<div id='change_password_div_buttons'>
<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:change_password()"
		iconCls="icon-ok">确定修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#change_password_div').dialog('close')"
		iconCls="icon-cancel">放弃修改关闭</a>
</div>



<script type='text/javascript'>

function change_password(){
	var password1=$("#new_password1").passwordbox('getValue');
	var password2=$("#new_password2").passwordbox('getValue');
	if (password1==password2){
		$.getJSON("../system/change_password.action", $('#change_password_form').serializeObject(), function(result) {

			var field = result.msg;

			if (field.success) {
				//成功登录
				$.messager.alert('操作提示', "更新用户密码成功成功", 'info');
				
			} else {

				$.messager.alert('操作提示', "更新用户密码出错", 'error');

			}

		});
		
		}
	else{
		$.messager.alert('操作提示', "两次输入密码不同", 'error');
		return ;
		}

	
}

	function change_password_init(user_uuid,user_name){
		//console.log("enter");

		$('#user_id').val(user_uuid);
		$('#user_name_span').text(user_name);
		//console.log(user_name);
		
		dialog_init_little('change_password_div');
			
			$('#new_password1').textbox('setValue','');
			$('#new_password1').textbox('setValue','');


			$('#change_password_div').dialog('open');
		
		}
	

	



	
	</script>

<script type='text/javascript'>
/*
 *初始化 

 
 */
 function view_change_passowrd_ready(){
	 easyui_ajax_div_clean('change_password_div');
	 $('#change_password_div').dialog('close');
	
	 }



 

</script>
