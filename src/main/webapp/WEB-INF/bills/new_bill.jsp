<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<script type="text/javascript">
	var pic_num;
	$.parser.onComplete = function(){
		
		center_load_ready();
	};	
	

	function save_post_bill() {

		if (save_bill_check_field()){
			temp_save_bill(function(){
				/*
				print_bill('<s:property value="#request.bill_uuid"/>',function callback(){
					$('#body').layout('panel','center').panel('refresh',"../bills/my_bills_init.action");
					});
				
				*/
				$.getJSON("../bills/post_search_request.action", {
					bill_uuid : '<s:property value="#request.bill_uuid"/>'
				}, function(result) {

					var field = result.msg;

					if (field.success) {
						$.messager.alert("操作提示", "提交申请成功，等待金融处审核。", "info");
						$('#body').layout('panel','center').panel('refresh',"../bills/my_bills_init.action");

					} else {
						$.messager.alert("操作提示", "提交申请出错！" + field.body, "error");

					}

				});

				
				
				//console.log('refresh');

				});

			}

	}

	//临时保存之后返回保存时间
	function temp_save_callback(bill_m) {
		$('#last_save_time').text(bill_m.last_modify_dat_chinese_print);
	}
	//保存退出
	function save_bill_and_exit() {
		
			if (save_bill_check_field()){
				//console.log('检测陈宫');
				
				temp_save_bill(function(){
					//console.log('瑞出');
					
					var url="home_page_frame.action";
					$('#body').layout('panel','center').panel('refresh',url);
					//$('#body').layout('panel','center').panel('refresh',"home_page_frame.action");

					});

				}
			


			
	}

	/*
	正式保存之前，检测是否满足条件，是否都有值
	*/
		
	function save_bill_check_field(){
		temp_save_bill_check_field();
		
		//测试是否所有"_msg"字段为空
		var array=new Array("contract_name_msg","contract_tell_msg","pro_name_msg","search_reason_msg");
		if (allEmpty(array)){
			
			return true;
			}
		else{
			return false;
			}

		}

	//只产生提示信息，不返回true false，用于临时保存

	function temp_save_bill_check_field() {
		//检测字段是否合规
		//申请人信息

		check_string_allowed_blank_not_length('contract_name', '联系人姓名', 64);
		check_string_allowed_blank_not_length('contract_tell', '联系人电话', 64);
		check_string_allowed_blank_not_length('contract_mail', '联系人邮件', 64);
		check_string_allowed_blank_not_length('pro_name', '项目名称', 512);
		check_string_allowed_blank_not_length('search_reason', '查询原因', 1024);
		check_num_allowed_bigger_tip('seatch_item_count', 1);
		//检测，如果有对私查询，必须有“公款私存”
		var rows=$('#bds_table').datagrid('getRows');
		var reason=$('#search_reason').textbox('getValue');
		for (var i=0;i<rows.length;i++){
			var row=rows[i];
			if (row.business_code=='0002'&&reason.indexOf('公款私存')==-1){
				$('#search_reason_msg').text('依据《中华人民共和国审计法》，只有存在\'公款私存\'嫌疑才能查询对私存款！');
				$('#search_reason_msg').css('color','red');
				

				}
			

		}
		

		return;
	}

	function set_change_business_code() {
		var business_code = $("#business_code").combobox("getValue");
		change_business_code(business_code)

	}
	function change_business_code(business_code) {

		$.getJSON("../bills/get_search_par_code.action", {
			business_code : business_code
		}, function(result) {

			var field = result.msg;

			if (field.success) {
				//有效
				var pars = field.o;
				$("#search_par_code").combobox("loadData", pars);
				//var data = $('#search_par_code').combobox('getData');
				$('#search_par_code').combobox('select', pars[0].code);

			} else {
				$.messager.alert("操作提示", "获取查询参数出错！" + field.body, "error");

			}

		});
	}

	function add_detail() {
		var search_par_value = trim($('#search_par_value').val());
		$('#search_par_value').val(search_par_value);
		if (search_par_value == '') {
			$.messager.alert("操作提示", "查询条件不能为空！", "error");
			return;
		}
		//查询身份证的情况，测试输入内容是否为身份证
		if ($("#search_par_code").combobox("getValue")=='0004'&&(!isCardNo($('#search_par_value').val()))){
			$.messager.alert("操作提示", "请检查身份证号码是否合规！", "error");
			return;
			}
		if ($('#start_dat').datebox('getValue')<'2013-01-01'){
			$.messager.alert("操作提示", "本系统可查询的数据从2013年1月1日期，因此起始时间不能早于2013年1月1日！", "error");
			return;
			}

		$.getJSON("../bills/add_bill_detail.action", {
			"business_code" : $("#business_code").combobox("getValue"),
			"bank_code" : $("#bank_code").combobox("getValue"),
			"search_par_code" : $("#search_par_code").combobox("getValue"),
			"search_par_value" : $('#search_par_value').val(),
			"bill_uuid" : $('#bill_uuid').val(),
			start_dat:$('#start_dat').datebox('getValue'),
			end_dat:$('#end_dat').datebox('getValue'),
		}, function(result) {

			var field = result.msg;

			if (field.success) {
				//有效
				var bds = field.o;

				show_bds(bds);

			} else {

				$.messager.alert("操作提示", "增加查询条目错误：" + field.body, "error");
			}

		});

	}
	function temp_save_bill(callback) {
		ajax_start();
		//是否满足临时保存条件
		
		
		
		if (jQuery.isEmptyObject($('#edit_bill_form').serializeObject())){
			//表单不存在，不执行，并且销毁定时操作
			
			clearInterval(interval_temp_save);
			return ;
			}

		
		$.getJSON("../bills/temp_save_bill.action", $('#edit_bill_form').serializeObject(), function(result) {
			ajax_stop();

			var field = result.msg;

			if (field.success) {
				var dat=field.o;
				
				callback(dat);

			} else {

				$.messager.alert("操作提示", "暂存申请单错误：" + field.body, "error");
			}

		});

	}

	//
	var interval_temp_save;
	function get_bill(bill_uuid) {

		$
				.getJSON(
						"../bills/get_bill.action",
						{

							"bill_uuid" : bill_uuid
						},
						function(result) {

							var field = result.msg;

							if (field.success) {
								//有效
								var bill = field.o;
								var bds = field.o2;
								show_bill(bill);
								show_bds(bds);
								
								interval_temp_save=setInterval(
										"temp_save_bill(temp_save_callback)",
										<s:property value="#application.temp_save_time"/> * 1000 * 60);
								var bill_status = bill.bill_status;
								$('#bill_status').text(bill_status);
								
							} else {

								$.messager.alert("操作提示", "增加查询条目错误："
										+ field.body, "error");
							}

						});

	}

	function show_bill(data) {

		$('#dept_name').text(data.dept_name);
		$('#contract_name').textbox("setValue", data.contract_name);
		$('#contract_tell').textbox("setValue", data.contract_tell);
		$('#pro_name').textbox("setValue", data.pro_name);
		$('#search_reason').textbox("setValue", data.search_reason);
		$('#bill_status').text(data.bill_status);
		$('#last_save_time').text(data.last_modify_dat_chinese_print);
		$('#contract_mail').textbox("setValue",data.contract_mail);
	}

	function show_bds(data) {
		var n = data.length;
		$('#seatch_item_count').numberbox('setValue', n);
		$("#bds_table").datagrid('loadData', {
			total : n,
			rows : data
		});
	}

	function del_bd(uuid) {

		$.getJSON("../bills/del_bill_detail.action", {

			"detail_uuid" : uuid
		}, function(result) {

			var field = result.msg;

			if (field.success) {
				//有效
				var bds = field.o;

				show_bds(bds);

			} else {

				$.messager.alert("操作提示", "删除查询条目错误：" + field.body, "error");
			}

		});
	}
</script>


<div class="easyui-layout" data-options="fit:true" style="display:table;">

	<div style="display:table-cell;text-align:center;">

	<div 
		style="width:600px;background:white;display:inline-block;vertical-align: middle;box-shadow:5px 2px 6px #000;padding: 10px
		; margin: 10px;border:1px solid Gray">

		<h1 align='center'>查询账户审批单</h1>
<form id="edit_bill_form">
		<table border="1" width="90%" class="box" align='center'>
			<tr>
				<td colspan='4'>
					<div>
						<span style='float: left'>当前订单状态：<span id='bill_status'>
						
						</span>
						
					</div>
					<div style='float: right'>
						<a href="javascript:void(0)" class="easyui-linkbutton"
							icon="icon-ok" onclick="javascript:save_post_bill()">填写完成，提交申请</a>
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="javascript:save_bill_and_exit()" icon="icon-save">暂存退出</a>
						
					</div>
				</td>
			</tr>
			<tr>
				<td width='20%'>申请单位：</td>
				<td width='30%'><span id='dept_name'></span></td>
			
				<td width='20%'>
					<div id='contract_name_title'>联系人</div>
				</td>
				<td width='30%'><input class="easyui-textbox" name="contract_name"
					id='contract_name' required="true"
					data-options="iconCls:'icon-man'" style="width: 100%;">
					<div id="contract_name_msg"></div></td>
			</tr>
			<tr>
				<td>
					<div id='contract_tell_title'>联系电话</div>
				</td>
				<td><input name='contract_tell' id='contract_tell'
					class="easyui-textbox" required="true" style="width: 100%;">
					<div id="contract_tell_msg"></div></td>

			
				<td>
					<div id='contract_mail_title'>邮箱</div>
				</td>
				<td><input  id='contract_mail' name='contract_mail'
					class="easyui-textbox" required="true" style="width: 100%;">
					<input type="hidden"
					value='<s:property value="#request.bill_uuid"/>' id='bill_uuid' name='bill_uuid'>
					<div id="contract_mail_msg"></div></td>

			</tr>

			<tr>
				<td ><div id='pro_name_title'>审计（调查）项目名称</div></td>
				<td colspan='3'><input required="true"
					style="width: 100%;" id="pro_name" name='pro_name'
					class="easyui-textbox" ></input>
					<div id="pro_name_msg"></div></td>
			</tr>
			<tr>
				<td ><div id='search_reason_title'>查询理由</div></td>
				<td colspan='3'><input required="true"
					style="width: 100%; height: 50px" id="search_reason" name='search_reason'
					class="easyui-textbox" data-options="multiline:true"></input>
					<div id="search_reason_msg"></div></td>
			</tr>
			<tr>
				<td colspan='4'>
					<div>
						<div>录入查询条目</div>
						<div>
							1、银行：
							<s:select id="bank_code" name="bank_code" list="bank_code"
								listKey="code" listValue="value" cssClass="easyui-combobox"
								cssStyle="width:100px" />

							2、类型
							<s:select id="business_code" name="business_code"
								list="business_code" listKey="code" listValue="value"
								onchange="change_business_code();" cssClass="easyui-combobox"
								cssStyle="width:100px" />
							3、要素<input id="search_par_code" class="easyui-combobox"
								style="width: 100px"> </input>
							4、查询条件<input required="true" id='search_par_value' name='search_par_value'
								class="easyui-textbox" style="width: 150px">
							5、起始时间<input id='start_dat' name="start_dat" style="width: 100px" class="easyui-datebox"/>
							6、结束时间<input id="end_dat" name="end_dat" style="width: 100px" class="easyui-datebox" /><span
								align='right'>
								
								<a href="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:add_detail()"
								iconCls="icon-add">增加</a></span>
								</div><div><span>已录入</span><span><input
								class="easyui-numberbox" value="0" style="width: 50px"
								disabled='disabled' data-options="min:0,precision:0"
								id='seatch_item_count'></span> <span>条。</span><span
								id='seatch_item_count_msg'></span>
						</div>
						<div>
							
						</div>
					</div>
					<table width='100%' id='bds_table' style="height: 200px">
					</table>
				</td>
			</tr>
			<tr>
				<td>审计组主审意见</td>
				<td colspan='3'>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>业务部门负责人意见</td>
				<td colspan='3'>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>法规处审核意见</td>
				<td colspan='3'>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>分管领导意见</td>
				<td colspan='3'>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>局长意见</td>
				<td colspan='3'>&nbsp;签名&nbsp;日期</td>
			</tr>



	
			

			<tr>
				<td colspan='4'>
				系统每<span>${temp_save_time }</span><span>分钟暂存一次数据</span>,最后一次保存数据时间为<span id='last_save_time'></span>
				</td>
			</tr>

		</table>
</form>
	</div>
	</div>
	
</div>
<jsp:include page="../common/include_print.jsp" flush="true" />
<script language='javascript' type='text/javascript'>
function center_load_ready(){
	

/*
 *ready 

 
 */
						//$("#login_dialog").panel("move",{top:$(document).scrollTop() + ($(window).height()-250) * 0.5});  
						pic_num = 0;
						$('#bank_code').combobox({
							required : true,
							multiple : false, //多选
							editable : false
						//是否可编辑
						});
						$('#business_code').combobox({
							required : true,
							multiple : false, //多选
							editable : false, //是否可编辑
							onChange : function(newValue, oldValue) {

								set_change_business_code();
							}
						});

						$('#search_par_code').combobox({
							required : true,
							multiple : false, //多选
							editable : false, //是否可编辑
							valueField : 'code',
							textField : 'value'
						});

						$('#bds_table')
								.datagrid(
										{
											//border:false,  
											fitColumns : true,
											singleSelect : true,
											title : '查询条目列表',
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
														field : 'start_dat_print',
														title : '起始时间'
													},
													{
														field : 'end_dat_print',
														title : '结束时间'
													},

													{
														field : 'opt',
														title : '操作',
														width : '100px',
														align : 'center',
														formatter : function(
																value, rec) {
															var btn = '<a class="del_bd" onclick="del_bd(\''
																	+ rec.detail_uuid
																	+ '\')" href="javascript:void(0)">删除条目</a>';
															return btn;
														}
													} ] ],
											onLoadSuccess : function(data) {
												$('.del_bd').linkbutton({
													text : '删除条目',
													plain : true,
													iconCls : 'icon-cancel'
												});

												$('#bds_table').datagrid(
														'fixRowHeight')

											}
										});
						change_business_code('0001');
						get_bill('<s:property value="#request.bill_uuid"/>');
						$('#start_dat').datebox('setValue','2013-01-01');
						$('#end_dat').datebox('setValue',GetDateStr(0));
}
		
</script>
