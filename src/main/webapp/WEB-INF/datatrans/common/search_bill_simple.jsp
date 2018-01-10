<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<script type='text/javascript'>

	var simple_current_page;
	var simple_rows_in_page;

	
	function search_bill_simple_ready() {
		simple_current_page = 1;
		simple_rows_in_page = <s:property value="#session.default_rows_in_page" />;
		
		




	}
	var simple_rowaction_handler;
	var simple_pagesaction_handler;
	//获取明细记录
	function show_bill_simple_table(simple_rowaction) {
		

rowaction_handler = simple_rowaction;
$('#simple_bill_table').datagrid('getPager').pagination({  
    pageSize: 100,  
    pageNumber: 1,  
    pageList: [100,200],  
    
});  
		
		
		var gridOpts = $('#simple_bill_table').datagrid('options'); 
		
		gridOpts.url=simple_rowaction;
		gridOpts.pageSize=100;
		gridOpts.pageNumber=1;
		gridOpts.pageList=[100,200];
		//console.log(gridOpts);
		//gridOpts.queryParams=$('#search_bill_pars').serializeObject();
		//console.log(gridOpts.queryParams);
		$("#simple_bill_table").datagrid("load");
		//console.log('load ok');

		
		
		
	}
	
</script>