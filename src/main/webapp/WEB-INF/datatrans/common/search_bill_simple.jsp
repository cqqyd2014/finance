<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<script type='text/javascript'>

	var simple_current_page;
	var simple_url;

	
	function search_bill_simple_ready(simple_rowaction) {
		simple_url = simple_rowaction;
		$('#simple_bill_table')
		.datagrid(
				{
					//border:false,  
					fitColumns : true,
					singleSelect : false,
					title : '待下载列表',
					rownumbers : true,
					columns : [ [
						{field:'ck',checkbox:true},  
							{
								field : 'dept_name',
								title : '处室'
							},
							{
								field : 'contract_name',
								title : '联系人'
							},
							{
								field : 'contract_tell',
								title : '联系电话'
							},
							{
								field : 'create_dat_chinese_print',
								title : '创建时间'
							},
							{
								field : 'pro_name',
								title : '项目名称'
							},
							{
								field : 'search_reason',
								title : '查询原因'
							},
							
							] ],
					onLoadSuccess : function(data) {
						

					}
				});

		user_rows_in_page=<s:property value="#session.default_rows_in_page" />;
			datagrid_page_init('simple_bill_table',user_rows_in_page
					,function select_page_callback(pageNumber, pageSize){
				simple_current_page=pageNumber;
				$("#simple_bill_table").datagrid("load");
				});

		



	}
	var simple_rowaction_handler;
	var simple_pagesaction_handler;
	//获取明细记录
	function show_bill_simple_table() {
		


		var gridOpts = $('#simple_bill_table').datagrid('options'); 
		
		gridOpts.url=simple_url;
		
		
		$("#simple_bill_table").datagrid("load");
		

		
		
		
	}
	
</script>