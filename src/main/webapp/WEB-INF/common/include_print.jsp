<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">

function print_bill(bill_uuid){
	//测试条件，是否有明细记录，没有明细记录，不能打印
	$.getJSON("../bills/check_before_print_bill.action", {

		"bill_uuid" : bill_uuid
	}, function(result) {
		

		var field = result.msg;

		if (field.success) {
			if (field.boolean_flag){
				window.open('../bills/bill_print.action?bill_uuid='+bill_uuid);
				}
			else{
				$.messager.alert("操作提示", "打印的申请单查询条目为0，不能打印。", "error");
				
				}

		} else {

			$.messager.alert("操作提示", "打印申请单初始化错误：" + field.body, "error");
			
		}

	});

	
}
	
</script>
