<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>




<!-- 搜索条件 -->
<div class="easyui-layout" fit="true" style="background: red;" >
<div id="head_panel" data-options="region:'north',border:true"
	style="height: 140px; padding: 5px;">
	<!------------------ 在这里填写你的搜索条件（FORM） -------------------->
	<h2>查询列表</h2>
	<p>查询单状态分为“起草申请”、“申请待审”、“打印代签”，“等待传单”，“等待返回”和“查看结果”六个状态。起草阶段，查询单可以重复修改。一旦提交审核之后，查询不可再修改。查询单由金融处先预审核。预审核通过之后，请将申请单打印并签字。签字完成后，请将审批单扫描为附件，作为图片附件上传。至少上传一个图片附件。上传完附件，提交“附件”，然后等待数据返回。金融处工作人员负责查询需求传输至银行系统再返回数据。</p>
	<div>
	<form id='search_bill_pars'>
		1、订单状态： <SELECT id="search_bill_bill_status" name='search_bill_bill_status'style="width: 100px">
			<option VALUE="0" SELECTED>所有申请</option>
			<option VALUE="起草申请">起草申请</option>
			<option VALUE="申请待审">申请待审</option>
			<option VALUE="打印待签">打印待签</option>
			<option VALUE="等待传单">等待传单</option>
			<option VALUE="等待返回">等待返回</option>
			<option VALUE="查看结果">查看结果</option>
		</SELECT> 2、联系人姓名:<input id="search_bill_contract_name" name='search_bill_contract_name' class="easyui-textbox"
			style="width: 70px" /> 3、项目名称:<input id="search_bill_pro_name" name='search_bill_pro_name'
			class="easyui-textbox" style="width: 70px" /> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconcls="icon-search"
			onclick="javascript:page_init()">查询</a>
			</form>
	</div>

</div>

<!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
	<!------------------ 在这里填写你的datagrid -------------------->
	<table id="search_bill_list_table"  pagination="true" class="easyui-datagrid"
		fit="true" sortName="itemid" singleSelect="true" >

	</table>

</div>
</div>
<script type='text/javascript'>
	/***
	 * 初始化
	 */

	var search_bill_rows_in_page;
	var search_bill_current_page;


	var search_bill_url;
	

	function search_bill_ready(url) {
		search_bill_url = url;
		search_bill_current_page = 1;
		
		search_bill_rows_in_page=<s:property value="#session.default_rows_in_page" />;
			datagrid_page_init('search_bill_list_table',search_bill_rows_in_page
					,function select_page_callback(pageNumber, pageSize){
				//console.log("select");
				search_bill_current_page=pageNumber;
				//console.log(pageNumber);
				search_bill_rows_in_page=pageSize;
				

				$("#search_bill_list_table").datagrid({
			    	
			    	pageNumber:pageNumber,
			    	pageSize:pageSize
			    	
			    	
			    });  

				$("#search_bill_list_table").datagrid("load");
				},
				function change_page_size_callback(pageSize){
					//console.log("size");
					search_bill_rows_in_page=pageSize;
					$("#search_bill_list_table").datagrid({
				    	
				    	
				    	pageSize:pageSize
				    	
				    	
				    }); 
					$("#search_bill_list_table").datagrid("load");
					});
		
		
			
			$('#search_bill_bill_status').combobox({
				required : true,
				multiple : false, //多选
				editable : false
			//是否可编辑

			});
			//根据request中的bill_status判断是否只读
			
			
			var bill_status='<s:property value="#request.bill_status"/>';
			//console.log(bill_status);
			if (bill_status=='0'||bill_status==''){
				$('#search_bill_bill_status').combobox('select', 0);
				$("#search_bill_bill_status").combobox('readonly',false);
				}
			else{
				$('#search_bill_bill_status').combobox('select', bill_status);
				$("#search_bill_bill_status").combobox('readonly',true);
				}
			
			

	}
</script>

<script type='text/javascript'>
	
	
	//获取明细记录
	function show_search_bill_list_table() {
		

		
		
		var gridOpts = $('#search_bill_list_table').datagrid('options');   
		
		gridOpts.queryParams=$('#search_bill_pars').serializeObject();
		
		gridOpts.url=search_bill_url;
		$("#search_bill_list_table").datagrid("load");
		
		//console.log($("#search_bill_list_table"));
	}
	
</script>

