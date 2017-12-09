<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">

function print_bill(bill_uuid){

	window.open('/finance/bill/bill_print.action?bill_uuid='+bill_uuid);
}
	
</script>
