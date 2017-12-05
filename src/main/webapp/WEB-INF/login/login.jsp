<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
<title>Insert title here</title>
<script type="text/javascript" src='../js/jquery-<s:property value="#request.jquery_version" />.min.js'>
	
</script>
<script type="text/javascript" src='../js/jquery-ui-<s:property value="jquery_ui_version" />/jquery-ui.min.js'>
	
</script>

<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-<s:property value="easyi_version" />/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-<s:property value="easyi_version" />/themes/icon.css" />
<script type="text/javascript" src="../js/jquery-easyui-<s:property value="easyi_version" />/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/qyd.js"></script>

<script  type='text/javascript'>

function login(){

	

	$.getJSON("../login/login.action", {"user_name":$("#user_name").val(),"password":$("#password").val()
	}, function(result) {
		
		var field=result.msg;
			
			
				if (field.success){
					//成功登录

				window.location.href='../frame/main_frame.action';
				}
				else{
					
					$.messager.alert('错误',field.body,'error');


					}
				
			
		
		
	});
	
}

$(document).ready(function() {
	//$("#login_dialog").panel("move",{top:$(document).scrollTop() + ($(window).height()-250) * 0.5});  
	dialog_init_mid('login_dialog');
	$('#login_dialog').dialog('open');

});


function root(){
	$('#user_name').val("");
	$('#password').val("");
	
}
</script>

</head>

<body >



	<div id="login_dialog" 
		style="width: 450px; height: 220px;"
		class="easyui-dialog" title="登录系统" 
		data-options="	iconCls: 'qyd',	buttons: '#login_buttons'"
		>
		
	<table style="width: 100%">
	<tr>
		<td width="30%"><img alt="" src="../img/audit.jpg" width="100px">
		</td>
		<td width="70%"><h1>地方银行数据查询系统</h1>
		</td>
	</tr>
	<tr>
		<td colspan='2' align="right" >重庆市审计局金融处2017.12</td>
	</tr>
	<tr>
		<td width="30%">服务器时间：
		</td>
		<td width="70%"><span id="time"></span>
		</td>
	</tr>
	<tr>
		<td>用户名:
		</td>
		<td><input type="text" required="true" id="user_name" name="userName" style="width 250px;"/>
		</td>
	</tr>
	<tr>
		<td>密码：
		</td>
		<td><input type="password" required="true" id ="password" name="pwd" label="密码" style="width 250px;"/>
		</td>
	</tr>
	</table>
			
			
			

		
	</div>

	<div id="login_buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:login()"
					icon="icon-ok">登录</a> <a href="
					javascript:void(0)" class="easyui-linkbutton" icon="icon-cancel" onclick="javascript:root()">取消</a>
	</div>




	<script type="text/javascript">
/**
* jquery 定时刷新
* edit 
*/

function Push() {
	$.getJSON("/util_web/system/get_system_dat.action", {}, function(result) {
		var field=result.msg;
		if (field.success) {
			$('#time').text(field.body);
		}

	});
	
}

Push();


setInterval(function(){ 
	Push()
	}, 1000*60); 



</script>
</body>
</html>