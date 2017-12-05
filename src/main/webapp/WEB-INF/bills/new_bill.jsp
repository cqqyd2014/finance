<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="../common/include_js_css.jsp" flush="true" />

<script language='javascript' type='text/javascript'>
	
</script>

<title>框架头部文件</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<script type="text/javascript">

function change_business_code(){
	var id = $("#province").val();

	$.getJSON("get_search_par_code.action", {
		"id" : id
	}, function(result) {

		$.each(result, function(i, rs) {

			if (rs.success) {
				//有效
				var city_list = rs.o;
				var city_object = $("#city");
				city_object.empty();

				$.each(city_list, function(j, city) {
					city_object
							.append("<option value = '"+city.regionId+"'>"
									+ city.regionName + "</option>");
				});

				change2();

			} else {
				//$('#original_id_msg').text('');
				//alert("sdfsdfsdf");

			}

		});

	});
}

</script>

</head>

<body  style="padding: 0px;margin:0px">
<div id="tt" class="easyui-tabs" style="width:100%;height:100%;">
    <div title="在线填报" style="padding:30px;display:none;">
		<h1 align='center'>查询账户审批单</h1>
		<div>填写时间：<span id="current_time"><s:property value="#request.chinese_date"/></span>
		<input type="hidden" value='<s:property value="#request.bill_uuid"/>'>
		</div>
		<table border="1" width="100%" class="box">
		<tr>
			<td width='30%'>审计（调查）项目名称</td>
			<td width='70%'><textarea style="width:100%" id="pro_name" rows="2"></textarea></td>
		</tr>
		<tr>
			<td width='30%'>查询理由</td>
			<td width='70%'><textarea style="width:100%" id="search_reason" rows="4"></textarea></td>
		</tr>
		<tr>
			<td colspan='2'>
			<div>1、银行：<s:select id="bank_code"
						name="bank_code" list="bank_code" listKey="code" listValue="value" />
						
						2、业务类型<s:select id="business_code"
						name="business_code" list="business_code" listKey="code" listValue="value" onchange="change_business_code();"/>
						3、查询要素<select id="search_par_code"><option value ="——">——</option> </select>
						4、查询条件<input type="text" id='search_par_value'  disabled="disabled" >
			</div>
			</td>
		</tr>
		</table>
    </div>
    <div title="影印件" data-options="closable:true" style="overflow:auto;padding:30px;display:none;">
		tab2
    </div>
    
</div>
</body>
</html>