<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<script type="text/javascript">
function page_init() {
	var gridOpts = $('#dept_table').datagrid('options');   
	gridOpts.url="../system/get_depts.action";
	
	//gridOpts.queryParams=$('#search_rs_form').serializeObject();
	//console.log(gridOpts.queryParams);
	$("#dept_table").datagrid("load");
	
		
	
	

}
function dept_manage_ready(){


	$('#dept_type').combobox({
		required : true,
		multiple : false, //多选
		editable : false, //是否可编辑
		valueField : 'code',
		textField : 'value'
	});

	$.getJSON("../system/get_sys_codes.action", {
		s_id:'dept_type'
	}, function(result) {

		var field = result.msg;

		if (field.success) {
			//有效
			var pars = field.o;
			//console.log(pars);
			$("#dept_type").combobox("loadData", pars);
			//var data = $('#search_par_code').combobox('getData');
			$('#dept_type').combobox('select', pars[0].code);

		} else {
			$.messager.alert("操作提示", "获取查询参数出错！" + field.body, "error");

		}

	});
	$('#dept_table')
	.datagrid(
			{
				//border:false,  
				fitColumns : true,
				singleSelect : true,
				title : '处室列表',
				rownumbers : true,
				columns : [ [
						{
							field : 'dept_name',
							title : '处室名称'
						},
						{
							field : 'dept_type_name',
							title : '类型'
						},
						{
							field : 'user_num',
							title : '用户数量'
						},
						

						{
							field : 'opt',
							title : '操作',
							width : '200px',
							align : 'center',
							formatter : function(
									value, rec) {
								var btn = '<a class="rename_dept" onclick="rename_dept(\''
										+ rec.dept_uuid
										+'\')" href="javascript:void(0)">更名</a><a class="add_user" onclick="add_user(\''
										+ rec.dept_uuid
										+'\')" href="javascript:void(0)">添加用户</a><a class="del_dept" onclick="del_dept(\''
										+ rec.dept_uuid
										+'\')" href="javascript:void(0)">添加用户</a>';
								return btn;
							}
						} ] ],
				onLoadSuccess : function(data) {
					$('.rename_dept').linkbutton({
						text : '更名',
						plain : true,
						iconCls : 'icon-reload'
					});
					$('.add_user').linkbutton({
						text : '添加用户',
						plain : true,
						iconCls : 'icon-add'
					});
					$('.del_dept').linkbutton({
						text : '删除',
						plain : true,
						iconCls : 'icon-cancel'
					});

					$('#dept_table').datagrid(
							'fixRowHeight')

				}
			});

	
}

	

</script>
<script>


function add_dept(){
	var value=easyui_textbox_tirm('dept_name');
	if (value==''){
		 $.messager.alert("操作提示", "新建处室名称不能为空！","error");
		 return;

		}
	else{
		

		$.getJSON("../system/add_dept.action", $('#new_dept_form').serializeObject()
				, function(result) {

			var field = result.msg;

			if (field.success) {
				page_init();
				$.messager.alert("操作提示", "添加成功！", "info");

			} else {
				$.messager.alert("操作提示", "获取查询参数出错！" + field.body, "error");

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
            
            <h2>处室管理</h2>
            <p>有人员的处室，不能删除。</p>
            <div>新建处室,新增处室中文名称
            
            </div>
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
            <!------------------ 在这里填写你的datagrid -------------------->
            <table id="dept_table">
		
	</table>

        </div> 
        <div id="tools_panel" data-options="region:'south',border:true" title='操作'
	style="height: 140px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
           
            <div>新增处室中文名称
            <form id="new_dept_form">
            <input id='dept_name' name='dept_name' class="easyui-textbox" style="width:200px;"/>,处室类型：
            <input id='dept_type' name='dept_type' style='width:100px;'/> 
            <a ref="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:add_dept()"
								iconCls="icon-add" >点击新增处室</a>
            </form>
            </div>
            

        </div>         
    </div>

