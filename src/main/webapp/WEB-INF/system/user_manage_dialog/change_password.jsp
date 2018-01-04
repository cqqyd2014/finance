<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>



<div title="重置密码" class="easyui-dialog" id='change_password_div'
	style="padding: 5px; width: 600px; height: 400px;"
	buttons="#change_password_div_buttons">
	
	<form id="change_password_form">
	<input type="hidden" id="user_uuid" name="user_uuid">
	
	<!-- 布局 -->
	<div class="easyui-layout" fit="true" style="padding:5px;">
	<div data-options="region:'north',border:true,iconCls:'icon-tip'"
			style="height: 60px; padding: 0px;" title="">
			<!------------------ 在这里填写你的搜索条件（FORM） -------------------->
			<h3>重置密码</h3>
		</div>
		<div data-options="region:'center',border:false"
			style="padding: 0px;" >
			<!------------------ 在这里填写你的datagrid -------------------->
			<table style="width: 100%">
			<tr>
				<td>请输入密码</td><td><input  class="easyui-textbox" style="width:100px;" id='change_password1' name='change_password1'/></td>
			</tr>
			<tr>
				<td>请确认密码</td><td><input  class="easyui-textbox" style="width:100px;" id='change_password2' name='change_password2'/></td>
			</tr>
			</table>

		</div>
	</div>
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

	function change_password_init(user_uuid){
		//console.log("enter");

		$('#user_uuid').val(user_uuid);
		
		dialog_init_little('change_password_div');
			
			$('#change_password1').textbox('setValue','');
			$('#change_password1').textbox('setValue','');


			$('#change_password_div').dialog('open');
		
		}
	

	



	
	</script>

<script type='text/javascript'>
/*
 *初始化 

 
 */
 function view_reslut_ready(){

	
	 }



 function change_password(){
		
 }

</script>
