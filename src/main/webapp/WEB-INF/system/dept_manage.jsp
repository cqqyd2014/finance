<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<script type="text/javascript">
function page_init() {
	//获取数据
	show_dept_table("../trans/get_trans_download_bills.action",check_all);

		
	
	

}
function dept_manage_ready(){


	$('#dept_type').combobox({
		required : true,
		multiple : false, //多选
		editable : false, //是否可编辑
		valueField : 'code',
		textField : 'value'
	});
	$('#dept_table')
	.datagrid(
			{
				//border:false,  
				fitColumns : true,
				singleSelect : true,
				title : '查询结果',
				rownumbers : true,
				columns : [ [
						{
							field : 'bank_name',
							title : '银行'
						},
						{
							field : 'business_name',
							title : '业务类型'
						},
						{
							field : 'search_par_name',
							title : '查询要素'
						},
						{
							field : 'search_value',
							title : '查询条件'
						},
						{
							field : 'account_id',
							title : '账号'
						},
						{
							field : 'rows_count',
							title : '记录数'
						},

						{
							field : 'opt',
							title : '操作',
							width : '250px',
							align : 'center',
							formatter : function(
									value, rec) {
								var btn = '<a class="download_custom_xls" onclick="download_custom_xls(\''
										+ rec.bank_code
										+'\',\''
										+rec.business_code
										+'\',\''
										+rec.custom_id
										+ '\')" href="javascript:void(0)">客户</a><a class="download_account_xls" onclick="download_account_xls(\''
										+ rec.bank_code
										+'\',\''
										+rec.business_code
										+'\',\''
										+rec.account_id
										+ '\')" href="javascript:void(0)">客户</a><a class="download_detail_xls" onclick="download_detail_xls(\''
										+ rec.bank_code
										+'\',\''
										+rec.business_code
										+'\',\''
										+rec.account_id
										+ '\')" href="javascript:void(0)">客户</a>';
								return btn;
							}
						} ] ],
				onLoadSuccess : function(data) {
					$('.download_custom_xls').linkbutton({
						text : '客户',
						plain : true,
						iconCls : 'icon-excel'
					});
					$('.download_account_xls').linkbutton({
						text : '账户',
						plain : true,
						iconCls : 'icon-excel'
					});
					$('.download_detail_xls').linkbutton({
						text : '流水',
						plain : true,
						iconCls : 'icon-excel'
					});

					$('#search_rs_table').datagrid(
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
		$('#new_dept_form').serializeObject()

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
            <form id="new_dept_form">
            <input id='dept_name' name='dept_name' class="easyui-textbox" style="width:300px;"/>,处室类型：
            <input id='dept_type' name='dept_type' style='width:100px;'/> 
            </form>
            <a ref="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:add_dept()"
								iconCls="icon-add" >点击新增处室</a></div>
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
            <!------------------ 在这里填写你的datagrid -------------------->
            <table id="dept_table">
		
	</table>

        </div>          
    </div>

