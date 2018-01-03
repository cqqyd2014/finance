<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<script type="text/javascript">
function page_init() {
	var gridOpts = $('#users_table').datagrid('options');   
	gridOpts.url="../system/get_users.action";
	
	//gridOpts.queryParams=$('#search_rs_form').serializeObject();
	//console.log(gridOpts.queryParams);
	$("#users_table").datagrid("load");
	
		
	
	

}
function dept_manage_ready(){


	$('#dept_id').combobox({
		required : true,
		multiple : false, //多选
		editable : false, //是否可编辑
		valueField : 'dept_uuid',
		textField : 'dept_name'
	});

	
	$('#role_id').combobox({
		required : true,
		multiple : false, //多选
		editable : false, //是否可编辑
		valueField : 'role_id',
		textField : 'role_name'
	});

	$.getJSON("../system/get_depts.action", {
		
	}, function(result) {

		var field = result.rows;

		
			
			$("#dept_type").combobox("loadData", field);
			//var data = $('#search_par_code').combobox('getData');
			$('#dept_type').combobox('select', field[0].dept_uuid);

		

	});
$.getJSON("../system/get_roles.action", {
		
	}, function(result) {

		var field = result.rows;

		
			
			$("#role_id").combobox("loadData", field);
			//var data = $('#search_par_code').combobox('getData');
			$('#role_id').combobox('select', field[0].role_id);

		

	});

	
	$('#user_table')
	.datagrid(
			{
				//border:false,  
				fitColumns : true,
				singleSelect : true,
				title : '人员列表',
				rownumbers : true,
				columns : [ [
						{
							field : 'user_login_name',
							title : '登录用户'
						},
						{
							field : 'user_name',
							title : '姓名'
						},
						{
							field : 'dept_name',
							title : '处室'
						},
						{
							field : 'effective_print',
							title : '状态'
						},
						{
							field : 'role_name',
							title : '角色'
						},
						{
							field : 'tell',
							title : '电话'
						},
						{
							field : 'last_online_dat_print',
							title : '最后上线时间'
						},

						{
							field : 'opt',
							title : '操作',
							width : '200px',
							align : 'center',
							formatter : function(
									value, rec) {
								var btn = '<a class="effective" onclick="effective(\''
										+ rec.dept_uuid
										+'\')" href="javascript:void(0)">启/停用</a><a class="user_detail" onclick="user_detail(\''
										+ rec.dept_uuid
										+'\')" href="javascript:void(0)">查看详情</a><a class="del_dept" onclick="del_dept(\''
										+ rec.dept_uuid
										+'\')" href="javascript:void(0)">添加用户</a>';
								return btn;
							}
						} ] ],
				onLoadSuccess : function(data) {
					$('.effective').linkbutton({
						text : '启/停用',
						plain : true,
						iconCls : 'icon-reload'
					});
					$('.user_detail').linkbutton({
						text : '添加用户',
						plain : true,
						iconCls : 'icon-search'
					});
					

					$('#user_table').datagrid(
							'fixRowHeight')

				}
			});

	
}

	

</script>
<script>


function add_user(){
	var password1=$('#password1').textbox('getValue');
	var password2=$('#password2').textbox('getValue');
	if (password1!=password2){
		$.messager.alert("操作提示", "两次输入的密码不一致！","error");
		 return;
		}
	var value=easyui_textbox_tirm('user_login');
	if (value==''){
		 $.messager.alert("操作提示", "新建登录名不能为空！","error");
		 return;

		}
	else{
		

		$.getJSON("../system/add_user.action", $('#new_user_form').serializeObject()
				, function(result) {

			var field = result.msg;

			if (field.success) {
				page_init();
				$.messager.alert("操作提示", "添加成功！", "info");

			} else {
				$.messager.alert("操作提示", "添加出错！" + field.body, "error");

			}

		});

		}
}

					function center_load_ready() {
						dept_manage_ready();
						page_init();
					}



					$.parser.onComplete = function(){
						
						center_load_ready();
					};	
</script>





<div class="easyui-layout" fit="true" style="background: red;" >
        <!-- 搜索条件 -->
        <div id="head_panel" data-options="region:'north',border:true"
	style="height: 140px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
            <h2>人员管理</h2>
            <p>有数据的人员不能删除。</p>
            
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
            <!------------------ 在这里填写你的datagrid -------------------->
            <table id="users_table">
		
	</table>

        </div>    
        <div id="tools_panel" data-options="region:'south',border:true" title='新增用户'
	style="height: 140px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
           
            <div>
            <form id="new_user_form">
            <table>
            	<tr>
            		<td>登录名</td>
            		<td><input id='user_login' name='user_login' class="easyui-textbox" style="width:100px;"/></td>
            		<td>姓名</td>
            		<td><input id='user_name' name='user_name' class="easyui-textbox" style="width:100px;"/></td>
            		<td>处室</td>
            		<td><input id='dept_id' name='dept_id'  style="width:100px;"/></td>
            	</tr>
            	<tr>
            		<td>密码</td>
            		<td><input id='password1' name='password1' class="easyui-passwordbox" style="width:100px;"/></td>
            		<td>确认密码</td>
            		<td><input id='password2' name='password2' class="easyui-passwordbox" style="width:100px;"/></td>
            		<td>角色</td>
            		<td><input id='role_id' name='role_id' style="width:100px;"/></td>
            	</tr>
            	<tr>
            		<td colspan='6' align='right'><a ref="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:add_user()"
								iconCls="icon-add" >点击新增处室</a></td>
            	</tr>
            </table>
            
            
            </form>
            </div>
            

        </div>         
    </div>
