<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>



<div title="查看数据" class="easyui-dialog" id='view_reslut_div'
	style="padding: 5px; width: 600px; height: 400px;"
	buttons="#view_reslut_div_buttons">
	
	<form id="search_rs_form"><input type="hidden" name="search_rs_uuid"></form>
	
	<!-- 布局 -->
	<div class="easyui-layout" fit="true">
	<div data-options="region:'south',border:true,iconCls:'icon-tip'"
			style="height: 100px; padding: 5px 0px 0px 0px;" title="">
			<!------------------ 在这里填写你的搜索条件（FORM） -------------------->
			<h3>根据查询要求，已经查出一下记录，点击下载Excel文件</h3>
		</div>
		<div data-options="region:'center',border:false"
			style="padding-top: 4px;" fit="true">
			<!------------------ 在这里填写你的datagrid -------------------->
			<table id="search_rs_table" style="width: 100%;">
			</table>

		</div>
	</div>
</div>

<div id='view_reslut_div_buttons'>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#view_reslut_div').dialog('close')"
		iconCls="icon-ok">没想好先关闭</a>
</div>



<script type='text/javascript'>

	function view_reslut(bill_uuid,object){

		$('#search_rs_uuid').val(bill_uuid);
		
			dialog_init('view_reslut_div');
			//初始化，加载
			var gridOpts = $('#search_rs_table').datagrid('options');   
			gridOpts.url=rowaction;
			gridOpts.queryParams=$('#search_bill_pars').serializeObject();
			//console.log(gridOpts.queryParams);
			$("#search_bill_list_table").datagrid("load");

			$('#AMS_dialog').dialog('open');
			
		
		}
	

	



	
	</script>

<script type='text/javascript'>
/*
 *初始化 

 
 */
 function view_reslut_ready(){

	 $('#search_rs_table')
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
								field : 'business_code_name',
								title : '业务类型'
							},
							{
								field : 'search_par_code_name',
								title : '查询要素'
							},
							{
								field : 'search_par_value',
								title : '查询条件'
							},
							{
								field : 'account_id',
								title : '账号'
							},
							{
								field : 'detail_count',
								title : '记录数'
							},

							{
								field : 'opt',
								title : '操作',
								width : '100px',
								align : 'center',
								formatter : function(
										value, rec) {
									var btn = '<a class="download_xls" onclick="download_xls(\''
											+ rec.detail_uuid
											+ '\')" href="javascript:void(0)">下载Excel</a>';
									return btn;
								}
							} ] ],
					onLoadSuccess : function(data) {
						$('.download_xls').linkbutton({
							text : '下载Excel',
							plain : true,
							iconCls : 'icon-cancel'
						});

						$('#rs_table').datagrid(
								'fixRowHeight')

					}
				});



	 
	 dialog_init('view_reslut_div');
	 }

</script>
