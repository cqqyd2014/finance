<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<script type="text/javascript">
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


function save_items(){

	var rows=$('#pg').datagrid('getRows');
	for (var i=0;i<rows.length;i++){
		var row=rows[i];
		$.getJSON("../system/save_user_par_item.action", {
			"code" : row.name,
			"value" : row.value
		}, function(result) {

			var field = result.msg;

			if (field.success) {
				//成功登录
				$.messager.alert('操作提示', "更新用户自定义设置成功："+row.name+"="+row.value, 'info');
				
			} else {

				$.messager.alert('操作提示', "更新用户自定义设置出错："+field.body, 'error');

			}

		});
		}
}
	function page_init() {


		$('#pg').propertygrid({
		    url: '../system/get_user_set.action',
		    showGroup: false,
		    scrollbarSize: 0
		});
		$('#user_name').text('<s:property value="#request.user_name" />');

		$('#tell').textbox('setValue','<s:property value="#request.su.tell" />');
		
		$('#email').textbox('setValue','<s:property value="#request.su.email" />');

	}
	function save_user_base(){

		$.getJSON("../system/save_user_base.action", $('#base_form').serializeObject(), function(result) {

			var field = result.msg;

			if (field.success) {
				//成功登录
				$.messager.alert('操作提示', "更新用户基本设置成功!", 'info');
				
			} else {

				$.messager.alert('操作提示', "更新用户基本设置出错："+field.body, 'error');

			}

		});

		}



	
	function user_set_ready() {


		
		
	}
</script>
<script>
	

	function center_load_ready() {
		
		user_set_ready();
		page_init();
	}

	$.parser.onComplete = function() {

		center_load_ready();
		//console.log('${request.user_id}');
	};
</script>





<div class="easyui-layout" fit="true" style="background: red;">
	<!-- 搜索条件 -->
	<div id="head_panel" data-options="region:'north',border:true"
		style="height: 100px; padding: 5px;">
		<!------------------ 在这里填写你的搜索条件（FORM） -------------------->

		<h2>用户设置</h2>
		<p>当前用户为：<span id="user_name"></span></p>


	</div>

	<!-- 查询结果 -->
	<div data-options="region:'center',border:false" style="padding: 0px;" >
		<!------------------ 在这里填写你的datagrid -------------------->
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',collapsed:false" style="width:50%"  title="基本信息">
			<form id="base_form">
			<p>联系方式<p>
			<div>联系电话：<input class="easyui-textbox" id="tell" name="tell">一般为手机</div>
			<div>EMAIL：<input class="easyui-textbox" id="email" name="email">一般为XX@cqaudit.gov.cn</div>
			<input id="user_id" name="user_id"  type="hidden" value="${request.user_id}">
			</form>
			<a ref="javascript:void(0)" style="width:100%"
							class="easyui-linkbutton" onclick="javascript:save_user_base()"
							iconCls="icon-save">保存对基本信息的修改</a>
			</div>
			<div data-options="region:'center'"  title="自定义属性">
			<table id="pg">

		</table>
		<a ref="javascript:void(0)" style="width:100%"
							class="easyui-linkbutton" onclick="javascript:save_items()"
							iconCls="icon-save">保存对属性的修改</a>
			</div>
		</div>
		
		
		
		

	</div>
	<div id="tools_panel" data-options="region:'south',border:true"
		title='修改基本信息' style="height: 100px; padding: 5px;">
		<!------------------ 在这里填写你的搜索条件（FORM） -------------------->


		<div>
			<form id="change_password_form">
				<table>
					<tr>
						<td>请输入原始密码</td>
						<td><input id='user_password' name='user_password'
							class="easyui-passwordbox" style="width: 100px;" /></td>
						<td>请输入新密码</td>
						<td><input id='new_password1' name='new_password1'
							class="easyui-passwordbox" style="width: 100px;" /></td>
						<td>请再次输入密码</td>
						<td><input id='new_password2' name='new_password2' 
						class="easyui-passwordbox" style="width: 100px;" /></td>
						
					
						<td ><a ref="javascript:void(0)"
							class="easyui-linkbutton" onclick="javascript:change_password()"
							iconCls="icon-save">点击更新密码</a>
							<input id="user_id" type="hidden" name="user_id" value="${request.user_id}"></td>

					</tr>

				</table>


			</form>
		</div>


	</div>
</div>

