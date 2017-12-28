<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>

	
</script>
<script  type='text/javascript'>
function qyd_pc(){
	window.location.href='login/login_init.action';
}


 

</script>
<jsp:include page="WEB-INF/common/include_easyui1.jsp" flush="true" />
</head>
<body>
	<table style='width: 100%'>
		<tr>
		<td><a style='width: 100%' href="#" class="easyui-linkbutton" 
			onclick="javascript:qyd_pc()">金融数据查询 V1（PC）</a></td>
		</tr>
		
	</table>
</body>
</html>
