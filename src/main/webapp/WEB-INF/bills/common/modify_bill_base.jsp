<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>



<div title="修改基本信息" class="easyui-dialog" id='modify_bill_base_div'
	style="padding: 5px; width: 600px; height: 400px;"
	buttons="#modify_bill_base_div_buttons">
	<!-- 布局 -->
	<div class="easyui-layout" fit="true">


		<!-- 查询结果 -->
		<div data-options="region:'center',border:false"
			style="padding-top: 4px;">
			<!------------------ 在这里填写你的datagrid -------------------->
			<div style='width: 100%;  text-align: center;'>

				<table>
				<tr><td>联系人</td><td><input class="easyui-textbox" name="contract_name"
					id='contract_name' required="true"
					data-options="iconCls:'icon-man'" ></td>
					<td>联系电话</td><td><input name='contract_tell' id='contract_tell'
					class="easyui-textbox" required="true" ></td>
				</tr>
				<tr>
					<td>联系邮箱</td><td><input  id='contract_mail' name='contract_mail'
					class="easyui-textbox" required="true" ></td>
					<td>创建时间</td><td><input id="create_date"></td>
					
				</tr>
				<tr>
					<td>项目名称</td>
					<td ><input  id='pro_name' name='pro_name'
					class="easyui-textbox" required="true" style="width: 100%;"></td>
					<td>当前状态</td>
					<td> <SELECT id="bill_status" name='bill_status'style="width: 100px">
			
			<option VALUE="起草申请">起草申请</option>
			<option VALUE="打印待签">打印待签</option>
			<option VALUE="等待传单">等待传单</option>
			<option VALUE="等待返回">等待返回</option>
			<option VALUE="返回待审">返回待审</option>
			<option VALUE="查看结果">查看结果</option>
		</SELECT></td>
				</tr>
				<tr>
				<td>查询原因</td><td colspan='3'><input  id='search_reason' name='search_reason'
					class="easyui-textbox" style="width: 100%;height:50px" data-options="multiline:true">
				</tr>
				</table>


			</div>

		</div>

		
	</div>
</div>

<div id='modify_bill_base_div_buttons'>
<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:save_modify_bill_base()"
		iconCls="icon-save">保存并关闭</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:exit_modify_bill_base()"
		iconCls="icon-cancel">取消并关闭</a>
</div>





<script type='text/javascript'>
function save_modify_bill_base(){
	$
	.getJSON(
			"../bills/temp_save_bill.action",
			{

				"bill_uuid" : modify_bill_base_bill_uuid,
				"contract_name":$('#contract_name').textbox('getValue'),
				"contract_mail":$('#contract_mail').textbox('getValue'),
				"contract_tell":$('#contract_tell').textbox('getValue'),
				"pro_name":$('#pro_name').textbox('getValue'),
				"search_reason":$('#search_reason').textbox('getValue'),
				"create_date":$('#create_date').datetimebox('getValue'),
				"bill_status":$('#bill_status').combobox('getValue')
			},
			function(result) {
				ajax_stop();
				var field = result.msg;

				if (field.success){
					var bm=field.o;
					$('#contract_name').textbox('setValue',bm.contract_name);
					$('#contract_mail').textbox('setValue',bm.contract_mail);
					$('#contract_tell').textbox('setValue',bm.contract_tell);
					$('#pro_name').textbox('setValue',bm.pro_name);
					$('#search_reason').textbox('setValue',bm.search_reason);


					$("#create_date").datetimebox('setValue',bm.create_dat_print);
					$('#modify_bill_base_div').dialog('close');
					modify_bill_base_handler();
				

				} else {

					$.messager.alert("操作提示", "获取订单基本信息错误："
							+ field.body, "error");
					
				}

			});

	
}



function exit_modify_bill_base(){
	modify_bill_base_handler();


	
	$('#modify_bill_base_div').dialog('close');
}


var modify_bill_base_bill_uuid;







	function modify_bill_base_init(bill_uuid, object) {

		//modify_bill_base_handler=object;
		//得到图片列表
		modify_bill_base_bill_uuid = bill_uuid;
		

		ajax_start();
		$
				.getJSON(
						"../bills/get_bill.action",
						{

							"bill_uuid" : bill_uuid
						},
						function(result) {
							ajax_stop();
							var field = result.msg;

							if (field.success){
								var bm=field.o;
								$('#contract_name').textbox('setValue',bm.contract_name);
								$('#contract_mail').textbox('setValue',bm.contract_mail);
								$('#contract_tell').textbox('setValue',bm.contract_tell);
								$('#pro_name').textbox('setValue',bm.pro_name);
								$('#search_reason').textbox('setValue',bm.search_reason);

								$('#bill_status').combobox('select', bm.bill_status);

								$("#create_date").datetimebox('setValue',bm.create_dat_print);
								$('#modify_bill_base_div').dialog('open');
								modify_bill_base_handler();

							} else {

								$.messager.alert("操作提示", "获取订单基本信息错误："
										+ field.body, "error");
								
							}

						});

		
	}



</script>


<script type='text/javascript'>
/*
 *初始化ready 
 
 */
 var modify_bill_base_handler;

	

	


 
function modify_bill_base_ready(page_init){
	modify_bill_base_handler=page_init;
	$("#create_date").datetimebox({
	   
	});

	
	$('#bill_status').combobox({
		required : true,
		multiple : false, //多选
		editable : false
	//是否可编辑

	});
	
	

	easyui_ajax_div_clean('modify_bill_base_div');
	dialog_init('modify_bill_base_div');
	//console.log("ddd");

	
}



</script>

