<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>



<div title="查看数据" class="easyui-dialog" id='view_reslut_div'
	style="padding: 5px; width: 600px; height: 400px;"
	buttons="#view_reslut_div_buttons">
	
	<form id="search_rs_form"><input type="hidden" id="search_rs_bill_uuid" name="bill_uuid"></form>
	
	<!-- 布局 -->
	<div class="easyui-layout" fit="true" style="padding:5px;">
	<div data-options="region:'north',border:true,iconCls:'icon-tip'"
			style="height: 60px; padding: 0px;" title="">
			<!------------------ 在这里填写你的搜索条件（FORM） -------------------->
			<h3>根据查询要求，已经查出以下记录，点击下载Excel文件</h3>
		</div>
		<div data-options="region:'center',border:false"
			style="padding: 0px;" >
			<!------------------ 在这里填写你的datagrid -------------------->
			<table id="search_rs_table" style="width: 100%;">
			</table>

		</div>
	</div>
</div>

<div id='view_reslut_div_buttons'>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#view_reslut_div').dialog('close')"
		iconCls="icon-ok">关闭</a>
</div>



<script type='text/javascript'>

	function view_result_init(bill_uuid,object){
		//console.log("enter");

		$('#search_rs_bill_uuid').val(bill_uuid);
		
		dialog_init('view_reslut_div');
			//初始化，加载
			var gridOpts = $('#search_rs_table').datagrid('options');   
			gridOpts.url="../bills/get_search_result.action";
			
			gridOpts.queryParams=$('#search_rs_form').serializeObject();
			//console.log(gridOpts.queryParams);
			$("#search_rs_table").datagrid("load");
			//console.log("load");
			$('#view_reslut_div').dialog('open');
			//console.log("open");
			
		
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
								field : 'account_name',
								title : '户名'
							},
							{
								field : 'rows_count',
								title : '记录数'
							},

							{
								field : 'opt',
								title : '操作',
								width : '180px',
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


	 easyui_ajax_div_clean('view_reslut_div');
	 
	 dialog_init('view_reslut_div');
	 }

function download_detail_xls(bank_code,business_code,custom_id){
	//console.log(business_code);
	 var table_name,filter_cols,filter_orders;
		switch(business_code)
		{
		case "0001":
		  //对公查询
		  table_name="data_core_public_account_trade_detail";
		  filter_cols="public_account_id,bank_code";
		  filter_orders="public_trade_dat,public_trade_seq";
		  break;
		case "0002":
			
			table_name="data_core_private_account_trade_detail";
			filter_cols="private_account_id,bank_code";
			filter_orders="private_trade_dat,private_trade_seq";
			break;
		default:
		  //n 与 case 1 和 case 2 不同时执行的代码
		}
		window.open('../data_export/get_table_to_excel2.action?table_name='+table_name+'&filter_ops==,=&filter_cols='+filter_cols+'&filter_values='+custom_id+','+bank_code+'&filter_orders='+filter_orders);

		
}


 function download_account_xls(bank_code,business_code,custom_id){
	 var table_name,filter_cols,filter_orders;
		switch(business_code)
		{
		case "0001":
		  //对公查询
		  table_name="data_core_public_account_info";
		  filter_cols="public_account_id,bank_code";
		  filter_orders="public_account_id";
		  break;
		case "0002":
			table_name="data_core_private_account_info";
			filter_cols="private_account_id,bank_code";
			 filter_orders="private_account_id";
			break;
		default:
		  //n 与 case 1 和 case 2 不同时执行的代码
		}
		window.open('../data_export/get_table_to_excel2.action?table_name='+table_name+'&filter_ops==,=&filter_cols='+filter_cols+'&filter_values='+custom_id+','+bank_code+'&filter_orders='+filter_orders);

		
 }
function download_custom_xls(bank_code,business_code,custom_id){
	
	var table_name,filter_cols,filter_orders;
	
	switch(business_code)
	{
	case "0001":
	  //对公查询
	  table_name="data_core_public_custom_base";
	  filter_cols="public_custom_id,bank_code";
	  filter_orders="public_custom_id";
	  break;
	case "0002":
		table_name="data_core_private_custom_base";
		filter_cols="private_custom_id,bank_code";
		filter_orders="private_custom_id";
		break;
	default:
	  //n 与 case 1 和 case 2 不同时执行的代码
	}
	window.open('../data_export/get_table_to_excel2.action?table_name='+table_name+'&filter_ops==,=&filter_cols='+filter_cols+'&filter_values='+custom_id+','+bank_code+'&filter_orders='+filter_orders);

	
}
</script>
