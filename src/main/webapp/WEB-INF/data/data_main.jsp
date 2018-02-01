<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<script type="text/javascript">
function page_init() {
	

		
	
	

}


</script>
<script>
//json对象
var pars;
var logics;
var view_name;
var default_orders;

					function center_load_ready() {
						logics=null;
						view_name='${requestScope.view_name}';
						var par_json_string='${requestScope.par_json}';
						var order_json_string='${requestScope.default_order_json}';
						default_orders=JSON.parse(order_json_string);
						order_span();
						 pars= JSON.parse(par_json_string);
						//console.log(pars);
						//生成下拉列表
						$('#col').combobox({
							data:pars,
							required : true,
							multiple : false, //多选
							editable : false, //是否可编辑
							valueField : 'field_name',
							textField : 'field_chinese_name',
							onChange : function(newValue, oldValue) {

								change_op();
							}
						});
						$('#col').combobox('select', pars[0].field_name);
						var field_json_string='${requestScope.field_json}';
						var fileds=JSON.parse(field_json_string);
						fileds.sort(function(x,y){
							return x.order_id-y.order_id;
							});

						field_json_string="["+JSON.stringify(fileds)+"]";

						
						fileds=JSON.parse(field_json_string);
						
						//console.log(fileds);

						$('#detail_table').datagrid(
								{
									//border:false,  
									fitColumns : true,
									singleSelect : true,
									title : '数据',
									rownumbers : true,
									columns :fileds,
									onLoadSuccess : function(data) {
										
									}
								});
						search_bill_rows_in_page=<s:property value="#session.default_rows_in_page" />;
						datagrid_page_init('detail_table',search_bill_rows_in_page
								,function select_page_callback(pageNumber, pageSize){
							//search_bill_current_page=pageNumber;
							//$("#detail_table").datagrid("load");
							
	
							$("#detail_table").datagrid({
						    	
						    	pageNumber:pageNumber,
						    	pageSize:pageSize
						    	
						    	
						    });  

							$("#detail_table").datagrid("load");
							},
							function change_page_size_callback(pageSize){
								$("#detail_table").datagrid({
							    	
							    	
							    	pageSize:pageSize
							    	
							    	
							    }); 
								$("#detail_table").datagrid("load");
								});
						
						$('#files_table')
						.datagrid(
								{
									//border:false,  
									fitColumns : true,
									singleSelect : true,
									title : '当前条件',
									rownumbers : true,
									columns : [ [
										
											{
												field : 'col_name',
												title : '字段'
											},
											{
												field : 'op',
												title : '逻辑'
											},
											{
												field : 'value',
												title : '条件'
											},
											{
												field : 'opt',
												title : '操作',
												width : '100px',
												align : 'center',
												formatter : function(value, rec) {
													var btn = '<a class="remove_logic" onclick="remove_logic(\''
															+ rec.uuid
															+ '\')" id="remove_logic_'
															+ rec.uuid
															+ '" href="javascript:void(0)">删除条件</a>';
													return btn;
												}
											}
											] ],
									onLoadSuccess : function(data) {
										$('.remove_logic').linkbutton({
											text : '删除条件',
											plain : false,
											iconCls : 'icon-cancel'
										});
										
										if (data.total==0){
											var empty_date=JSON.parse("[]");
											//console.log(empty_date);
											$("#detail_table").datagrid({
										    	
										    	
										    	data:empty_date
										    	
										    	
										    }); 
											}
										else{
											do_search();
											}
									
									}
								});
/*
						user_rows_in_page=<s:property value="#session.default_rows_in_page" />;
							datagrid_page_init('detail_table',user_rows_in_page
									,function select_page_callback(pageNumber, pageSize){
								simple_current_page=pageNumber;
								$("#detail_table").datagrid("load");
								});
							*/
						
					}

					function remove_logic(uuid){
						
						
$.getJSON("../data/remove_logic.action", {
							
							
							logic_string:JSON.stringify(logics),
							uuid:uuid
						}, function(result) {
							var field=result.msg;
							if (field.success){
								//添加成功
								//console.log(field.o);
								logics=field.o;
								$('#files_table')
								.datagrid({
									data:logics
									});
								
								}
						
						});
						}
					
					function do_search(){
						$('#view_name').val(view_name);
						$('#logics').val(JSON.stringify(logics));

						
						$('#default_orders').val(JSON.stringify(default_orders));
						var gridOpts = $('#detail_table').datagrid('options');   
						
						gridOpts.queryParams=$('#search_par').serializeObject();
						//console.log($('#search_par').serializeObject());
						
						gridOpts.url="../data/get_data_web_datagrid.action";
						$("#detail_table").datagrid("load");

						
						
						}
					function add_logic(){
						
						//那个span是可用的
						var value;
						if ($('#text_span').css("display")=="inline"){
							var text_value=$('#text_value').textbox('getValue');
							if (text_value==""){
								$.messager.alert("操作提示", "添加查询错误：条件不能为空", "error");
								return;
								}
							value=text_value;
							}
						if ($('#number_span').css("display")=="inline"){
							value=$('#number_value').numberbox('getValue');
							}
						//alert($('#col').combobox('getValue'));
						
						$.getJSON("../data/add_logic.action", {
							
							col : $('#col').combobox('getValue'),
							op : $('#op').combobox('getValue'),
							value:value,
							col_name:$('#col').combobox('getText'),
							logic_string:JSON.stringify(logics),
							view_name:view_name
						}, function(result) {
							//console.log(result);
							var field=result.msg;
							if (field.success){
								//添加成功
								//console.log(field.o);
								logics=field.o;
								$('#files_table')
								.datagrid({
									data:logics
									});
								
								}
						
						});
					}
					function change_op(){
						
						var col_value = $('#col').combobox('getValue');
						//遍历pars得到类型
						var col_type;
						for (var i=0;i<pars.length;i++){
								var par=pars[i];
								if (par.field_name==col_value){
									//得到类型
									col_type=par.col_type;
									
									}
							}
						//console.log(col_type);
						var op_data;
						switch(col_type){
						case 'STR_':
							op_data='[{ "code": "=", "value": "=" },{ "code": "like", "value": "like" }]';
							$('#text_value').textbox('setValue','');
							$('#text_span').css("display", "inline");
							$('#number_span').css("display", "none");
							break;
						case 'NUM_':
							op_data='[{ "code": "=", "value": "=" },{ "code": ">", "value": ">" },{ "code": "<", "value": "<" }]';
							$('#number_value').numberbox('setValue','0');
							$('#text_span').css("display", "none");
							$('#number_span').css("display", "inline");
							break;
						case 'DATE':
							break;
						}
//console.log(op_data);
						var op_data_object=JSON.parse(op_data);
						
						$('#op').combobox({
							data:op_data_object,
							required : true,
							multiple : false, //多选
							editable : false, //是否可编辑
							valueField : 'code',
							textField : 'value'
						});
						$('#op').combobox('select', op_data_object[0].code);
						}

					function order_span(){
						//排序
						default_orders.sort(function(x,y){
							return x.order_order-y.order_order;
							});
						//console.log(default_orders);
						var html="";
						for (var i=0;i<default_orders.length;i++){
							var order=default_orders[i];
							var new_span="<span style='box-shadow: 2px 2px 2px #888888;margin:10px;'>"+order.col_chinese_name+" "+order.type_name+"</span>";
							$('#order_span').append(new_span);
							
							}
						
						}
					


					$.parser.onComplete = function(){
						
						center_load_ready();
						page_init();
					};	
</script>





<div class="easyui-layout" fit="true" style="background: red;">
	<!-- 搜索条件 -->
	<div id="head_panel" data-options="region:'north',border:true,collapsible:true"
		style="height: 140px; padding: 5px;">
		<!------------------ 在这里填写你的搜索条件（FORM） -------------------->
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',collapsed:false" style="width:50%">
			<h2>${requestScope.table_view_chinese_name}</h2>

		
		<form id="logic_form">
			条件<input id="col" style="width: 100px"> <input id="op"
				style="width: 50px">
				<span id="text_span"><input class="easyui-textbox"	id="text_value" style="width: 100px"/> </span>
				
			<span id="number_span"><input class="easyui-numberbox"	id="number_value" style="width: 100px"/> </span>
				
				
				<a ref="javascript:void(0)" class="easyui-linkbutton"
				onclick="javascript:add_logic()" iconCls="icon-add">加入条件</a>
				</form>
		<hr>
		默认排序规则：<span id="order_span"></span>
		<form id="search_par">
		<input type="hidden" id="view_name" name="view_name">
		<input type="hidden" id="logics" name="logics">
		<input type="hidden" id="default_orders" name="orders">
		
		</form>
			
			</div>
			<div data-options="region:'center'" >
			<table id="files_table">
			</table>
			</div>
		</div>
		


	</div>

	<!-- 查询结果 -->
	<div data-options="region:'center',border:false" style="padding: 0px;">
		<!------------------ 在这里填写你的datagrid -------------------->
		<table id="detail_table">

		</table>

	</div>
</div>
