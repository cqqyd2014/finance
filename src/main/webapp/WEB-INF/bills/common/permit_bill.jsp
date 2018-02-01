<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>



<div title="审核查询单" class="easyui-dialog" id='permit_bill_div'
	style="padding: 5px; width: 600px; height: 400px;"
	buttons="#permit_bill_div_buttons">
	<!-- 布局 -->
	<div class="easyui-layout" fit="true">


		<!-- 查询结果 -->
		<div data-options="region:'center',border:false"
			style="padding-top: 4px;">
			<!------------------ 在这里填写你的datagrid -------------------->
			<div style='width: 100%;  text-align: left;'>

				<div>审核意见:<input type="radio"  name="permit" value="同意" />同意<input type="radio" name="permit" value="不同意" />不同意</div>
				<div>备注：</div>
				<div><input style="height:70px;width:100%" class='easyui-textbox' id='permit_message' name='permit_message' data-options="multiline:true"></div>
				


			</div>

		</div>

		
	</div>
</div>

<div id='permit_bill_div_buttons'>
<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:save_permit_bill()"
		iconCls="icon-ok">保存审核结果并关闭</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:exit_permit_bill()"
		iconCls="icon-cancel">取消并关闭</a>
</div>





<script type='text/javascript'>
function save_permit_bill(){
	$
	.getJSON(
			"../bills/permit_bill.action",
			{

				"bill_uuid" : permit_bill_uuid,
				"permit":$("input[name='permit']:checked").val(),
				"permit_message":$('#permit_message').textbox('getValue')
			},
			function(result) {
				
				var field = result.msg;

				if (field.success){
					
					permit_bill_handler();
				

				} else {

					$.messager.alert("操作提示", "审批查询单错误："
							+ field.body, "error");
					
				}

			});
	$('#permit_bill_div').dialog('close');

	
}



function exit_permit_bill(){
	permit_bill_handler();


	
	$('#permit_bill_div').dialog('close');
}


var permit_bill_uuid;







	function permit_bill_init(bill_uuid, object) {
		$("input[name='permit']").get(0).checked=true; 
		$('#permit_message').textbox('setValue','');
		
		permit_bill_uuid = bill_uuid;
		$('#permit_bill_div').dialog('open');

		

		
	}



</script>


<script type='text/javascript'>
/*
 *初始化ready 
 
 */
 var permit_bill_handler;

	

	


 
function permit_bill_div(page_init){
	permit_bill_handler=page_init;
	
	
	

	easyui_ajax_div_clean('permit_bill_div');
	dialog_init_little('permit_bill_div');
	//console.log("ddd");

	
}



</script>

